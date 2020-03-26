package rg.quintana.buscaminas;

import java.util.Random;

public class LogicaBuscaminas {

    static char[][] cuadricula = new char[8][8];

    public LogicaBuscaminas() {
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                cuadricula[f][c] = '.';
            }
        }
        //un for para dibujar las bombas de manera aleatoria a lo largo de la cuadricula  
        for (int j = 0; j < 10; j++) {
            Random random = new Random();
            int numeroF = random.nextInt(8);
            int numeroC = random.nextInt(8);
            cuadricula[numeroF][numeroC] = '*';
        }
    }

    public void mostrarConsola() {
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                System.out.print(cuadricula[f][c]);
            }
            System.out.println("");
        }
    }

    public int getNumBombasLineas(int f, int c, int incFil, int incCol) {
        int contadorBombasLinea = 0;
        try {
            if (cuadricula[f + incFil][c + incCol] == '*') {
                contadorBombasLinea++;
            }
        } catch (Exception e) {
        }
        return contadorBombasLinea;
    }

    public void getNumeros() {
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                if (cuadricula[f][c] != '*') {
                    //                mira derecha
                    int numBombasDerecha = getNumBombasLineas(f, c, 0, 1);
                    //                mira izquierda
                    int numBombasIzquierda = getNumBombasLineas(f, c, 0, -1);
                    //                mira arriba
                    int numBombasArriba = getNumBombasLineas(f, c, -1, 0);
                    //                mira abajo
                    int numBombasAbajo = getNumBombasLineas(f, c, 1, 0);
                    //                mira diag1
                    int numBombasDiag1 = getNumBombasLineas(f, c, 1, 1);
                    //                mira diag2
                    int numBombasDiag2 = getNumBombasLineas(f, c, 1, -1);
                    //                mira diag3
                    int numBombasDiag3 = getNumBombasLineas(f, c, -1, 1);
                    //                mira diag4
                    int numBombasDiag4 = getNumBombasLineas(f, c, -1, -1);

                    int sumaBombas = numBombasDerecha + numBombasIzquierda + numBombasArriba + numBombasAbajo + numBombasDiag1 + numBombasDiag2 + numBombasDiag3 + numBombasDiag4;
                    System.out.println(sumaBombas);

                    cuadricula[f][c] = (char) (sumaBombas + '0');
                }
            }
        }
    }
}
