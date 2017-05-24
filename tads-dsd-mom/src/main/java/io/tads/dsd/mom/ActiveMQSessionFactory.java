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
package io.tads.dsd.mom;

import javax.jms.*;

import org.apache.activemq.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ActiveMQSessionFactory implements JMSSessionFactory {

    private String brokerURL;

    public ActiveMQSessionFactory(String brokerURL) {

        this.brokerURL = brokerURL;
    }

    public Connection createConnection(String brokerURL) throws JMSException {

        ConnectionFactory factory;
        Connection connection;

        factory = new ActiveMQConnectionFactory(brokerURL);

        connection = factory.createConnection();
        connection.start();

        return connection;

    }

    @Override
    public Session openSession() throws JMSException {

        return this.createConnection(this.brokerURL)
            .createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    @Override
    public Session openSession(String brokerURL) throws JMSException {

        return this.createConnection(brokerURL)
            .createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

}
