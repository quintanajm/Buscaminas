
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
        this.setPadding(new Insets(0, 10, 0, 10));
//        for(int i=0;i<8; i)
            Casilla casilla = new Casilla ();
            this.getChildren().add(casilla);
        
    }
}
