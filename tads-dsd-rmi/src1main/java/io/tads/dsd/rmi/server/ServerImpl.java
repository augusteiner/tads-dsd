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
package io.tads.dsd.rmi.server;

import java.util.*;

import io.tads.dsd.rmi.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ServerImpl implements Server {

    private Random random;

    private long clienteNo;

    public ServerImpl() {

        this.random = new Random();
        this.clienteNo = 1;
    }

    @Override
    public String digaOi(String nome) {

        int i = this.random.nextInt();

        System.out.printf("INFO: servindo cliente %d.\n", clienteNo++);

        if (i % 2 == 0) {

            return String.format("Oi %s!", nome);

        } else {

            return String.format("Olá %s!", nome);

        }

    }

}
