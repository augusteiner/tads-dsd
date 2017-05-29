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
package io.tads.dsd.mom.client;

import javax.jms.*;

import io.tads.dsd.mom.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static JMSSessionFactory factory;

    public static void main(String[] args) throws JMSException {

        System.out.printf("Broker URL: %s\n", args[0]);
        factory = new ActiveMQSessionFactory(args[0]);

        Session session = factory.openSession();
        session.setMessageListener(new WorldListener());

        Session responseSession = factory.openSession();

        Queue responseQueue = responseSession.createTemporaryQueue();
        MessageConsumer responseConsumer = responseSession.createConsumer(responseQueue);
        responseConsumer.setMessageListener(new WorldListener());

        System.out.printf("Criada queue temp. de resposta: %s\n", responseQueue.getQueueName());

        new HelloProducer(session, responseQueue).sayHello("Hello 2");

    }

}
