
package rg.quintana.buscaminas;

import java.util.Random;

public class LogicaBuscaminas {
    
    static char[][] cuadricula = new char[8][8];
    
    public LogicaBuscaminas() {
        for(int f=0; f<8; f++) {
            for(int c=0; c<8; c++) {
                cuadricula[f][c] = '.';
            }
        } 
        //un for para dibujar las bombas de manera aleatoria a lo largo de la cuadricula  
        for(int j=0; j<10; j++) {
                Random random = new Random ();
                int numeroF = random.nextInt(8);
                int numeroC = random.nextInt(8);
                cuadricula[numeroF][numeroC] = '*';
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
    public int getNumBombasLinea(int fila, int columna) {
        int bomba = cuadricula[fila][columna];
        int contadorBombasLinea = 1;
        int i=1;
        try {
           if(cuadricula[fila][columna+i] == bomba) {
                contadorBombasLinea++;
                i++;
                System.out.println("Bombas en linea:" + contadorBombasLinea);
            }
        } catch(Exception e) {
            
        }
        return contadorBombasLinea;
//        tengo que hacer un if
    }
}
        