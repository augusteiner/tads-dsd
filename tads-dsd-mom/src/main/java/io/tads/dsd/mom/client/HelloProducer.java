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

import static io.tads.dsd.mom.JMSSessionFactory.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class HelloProducer {

    private Session session;
    private Destination responseQueue;

    private Queue queue;

    public HelloProducer(Session session, Destination responseQueue) {

        this.session = session;
        this.responseQueue = responseQueue;
    }

    private void doSayHello(String text) throws JMSException {

        Destination requestQueue = this.getQueue();
        MessageProducer producer = this.session.createProducer(requestQueue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        Message message = this.session.createTextMessage(text);
        message.setJMSReplyTo(responseQueue);

        producer.send(message);
        System.out.printf("Mensagem enviada: %s\n", text);

        producer.close();

    }

    protected Destination getQueue() throws JMSException {

        if (this.queue == null)
            this.queue = this.session.createQueue(QUEUE_NAME);

        return this.queue;

    }

    public void sayHello(String text) {

        try {

            this.doSayHello(text);

        } catch (JMSException e) {

            e.printStackTrace();

            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
