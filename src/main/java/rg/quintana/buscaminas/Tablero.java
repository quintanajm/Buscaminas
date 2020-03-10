
package rg.quintana.buscaminas;

import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class Tablero extends GridPane{
    public Tablero(){ 
        this.setPadding(new Insets(0, 4, 0, 4));
        for(int c=0;c<8; c++) {
            for(int r=0;r<8; r++) {
                this.add(new Casilla(), c, r);
            }
        }
         this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("Mouse clicked X,Y: " +
                    mouseEvent.getX() + " : " + mouseEvent.getY());
            int clicX = (int)mouseEvent.getX();
            int columna = clicX / Casilla.TAM_CASILLA;
            System.out.println("Columna: " + columna);
            int clicY = (int)mouseEvent.getY();
            int fila = clicY / Casilla.TAM_CASILLA;
            System.out.println("Fila: " + fila); 
            DeteccionBomba(clicX,clicY,columna,fila);
        });
    }
    public void DeteccionBomba (int clicX, int clicY, int columna, int fila){
        if(LogicaBuscaminas.cuadricula[fila][columna]=='*') {
            System.out.println("boom");
        }
    }
}