package rg.quintana.buscaminas;

import java.util.Optional;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;

public class logicBuscaminas {

    static char[][] cuadricula = new char[8][8];
    int contadorCasillasLevantas = 0;
    int estado = 1;  //victoria
    static char[][] visible = new char[8][8]; //0 tapado, 1 descubierto
    int casillasVistas = 0;


    public logicBuscaminas() {
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

            while (cuadricula[numeroF][numeroC] == '*') {
                numeroF = random.nextInt(8);
                numeroC = random.nextInt(8);
            }
            cuadricula[numeroF][numeroC] = '*';
//            repetir la generación de la fila y la columna mientras en esa posicion haya una mina

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

//    con este metodo, nos dice cuantas bombas tenemos en linea
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

//    con este metodo, vamos a hacer que nos diga el numero para referenciarnos a la bomba
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
