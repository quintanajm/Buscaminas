
package rg.quintana.buscaminas;

import java.util.Random;

public class LogicaBuscaminas {
    
    char[][] cuadricula = new char[8][8];
    
    public LogicaBuscaminas() {
        for(int f=0; f<8; f++) {
            for(int c=0; c<8; c++) {
                cuadricula[f][c] = '.';

            }
        } 
        //un for para dibujar las bombas de manera aleatoria a lo largo de la cuadricula  
        for(double j=0; j<10; j++) {
                Random random = new Random ();
                int numeroF = random.nextInt(8);
                int numeroC = random.nextInt(8);

                cuadricula[numeroF][numeroC] = '1';
            }
    }
    public void mostrarConsola() {
        for(int f=0; f<8; f++) {
            for(int c=0; c<8; c++) {
                System.out.print(cuadricula[f][c]);
            }
            System.out.println("");
        }        
    }
}
        