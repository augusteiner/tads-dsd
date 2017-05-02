/*
 * MIT License
 *
 * Copyright (c) 2016 José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.tads.dsd.xmlrpc.client;

import java.net.*;

import org.apache.xmlrpc.client.*;
import org.apache.xmlrpc.client.util.*;

import io.tads.dsd.xmlrpc.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class Client {

    public static void main(String[] args) throws Exception {

        /** XXX: Exemplo adaptado de https://ws.apache.org/xmlrpc/server.html */

        // create configuration
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://127.0.0.1:9091/"));
        config.setEnabledForExtensions(true);
        config.setConnectionTimeout(60 * 1000);
        config.setReplyTimeout(60 * 1000);

        XmlRpcClient client = new XmlRpcClient();

        // use Commons HttpClient as transport
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        // set configuration
        client.setConfig(config);

        // XXX: Chamada direta
        Object[] params = new Object[] { new Double(2), new Double(3) };

        double result = (Double) client.execute("calculadora.soma", params);
        System.out.println("2 + 3 = " + result);

        // XXX: Usando um client-proxy
        ClientFactory factory = new ClientFactory(client);

        ICalculadora adder = (ICalculadora) factory.newInstance(
            Client.class.getClassLoader(),
            ICalculadora.class,
            "calculadora");

        double sum = adder.soma(2, 4);
        System.out.println("2 + 4 = " + sum);

    }
}
