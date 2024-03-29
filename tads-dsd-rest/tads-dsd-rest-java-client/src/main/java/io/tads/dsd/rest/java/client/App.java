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
package io.tads.dsd.rest.java.client;

import java.util.*;

import org.apache.cxf.jaxrs.client.*;

import com.fasterxml.jackson.jaxrs.json.*;

import io.tads.dsd.rest.java.stub.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static void main(String[] args) {

        JacksonJsonProvider provider = new JacksonJsonProvider();

        List<Object> providers = new ArrayList<Object>();
        providers.add(provider);

        CalculadoraApi calculadora = JAXRSClientFactory.create(
            "http://localhost:9090",
            CalculadoraApi.class,
            providers
        );

        Double parcela1 = 3D;
        Double parcela2 = 4D;

        Double resultado = calculadora.soma(parcela1, parcela2);

        System.out.printf(
            "A soma de %s + %s = %s\n",
            parcela1,
            parcela2,
            resultado
        );

    }

}
