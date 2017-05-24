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
package io.tads.dsd.mom.server;

import javax.jms.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class HelloListener implements MessageListener {

    private Session session;

    public HelloListener(Session session) {

        this.session = session;
    }

    @Override
    public void onMessage(Message message) {

        if (message instanceof TextMessage) {

            try {

                this.respond(message);

            } catch (JMSException e) {

                e.printStackTrace();

                throw new RuntimeException(e.getMessage(), e);

            }

        } else {

            throw new RuntimeException("Mensagem inválida recebida");

        }

    }

    protected void respond(Message request) throws JMSException {

        String text = ((TextMessage) request).getText();
        String resposta = text + " World!";

        System.out.printf("Mensagem recebida: %s\n", text);

        Queue destination = (Queue) request.getJMSReplyTo();
        System.out.printf("Criando resposta para queue: %s\n", destination.getQueueName());

        MessageProducer responseProducer = this.session.createProducer(destination);
        responseProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        Message response = this.session.createTextMessage(resposta);
        response.setJMSDestination(destination);

        // response.setJMSCorrelationID(request.getJMSCorrelationID());

        responseProducer.send(destination, response);

        System.out.printf("Resposta enviada: %s\n", resposta);

    }

}
