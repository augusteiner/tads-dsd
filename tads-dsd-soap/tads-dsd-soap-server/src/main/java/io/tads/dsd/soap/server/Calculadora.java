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
package io.tads.dsd.soap.server;

import javax.jws.WebService;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@WebService(endpointInterface = "localhost._9090.calculadora.Calculadora")
public class Calculadora implements localhost._9090.calculadora.Calculadora {

    /**
     * @see {@link https://kerflyn.wordpress.com/2011/11/16/implementing-the-factorial-function-using-java-and-guava/}
     */
    private static int fat(int n, int k) {

        if (n == 0) return k;
        else return fat(n - 1, n * k);

    }

    @Override
    public int fatorial(int numero) {

        return fat(numero, 1);
    }

}
