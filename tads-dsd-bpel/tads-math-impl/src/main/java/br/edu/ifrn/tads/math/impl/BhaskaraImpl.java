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
package br.edu.ifrn.tads.math.impl;

import javax.jws.*;

import br.edu.ifrn.tads.math.*;

import static java.lang.Math.*;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
@WebService(
    endpointInterface = "br.edu.ifrn.tads.math.BhaskaraInterface", 
    serviceName = "bhaskara",
    portName = "bhaskaraPort")
public class BhaskaraImpl implements BhaskaraInterface {

    @Override
    public RespostaBinaria bhaskara(EntradaBhaskara parameters) {

        double a = parameters.getA();
        double b = parameters.getB();

        double delta = parameters.getDelta();

        double raizDelta = sqrt(delta);

        final double _x1 = (-b + raizDelta) / (2 * a);
        final double _x2 = (-b - raizDelta) / (2 * a);

        System.out.println("Chamado serviço de bhaskara");

        return new RespostaBinaria() {{
            setX1(_x1);
            setX2(_x2);
        }};

    }

}
