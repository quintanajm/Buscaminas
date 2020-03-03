
package rg.quintana.buscaminas;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 *
 * @author josem
 */
public class Tablero extends GridPane{
    public Tablero(){ 
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(0, 4, 0, 4));
        for(int c=0;c<8; c++) {
            for(int r=0;r<8; r++) {
                Casilla casilla = new Casilla ();
                this.add(new Casilla(), c, r);
            }
        }
    }
}
