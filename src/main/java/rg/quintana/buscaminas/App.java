package rg.quintana.buscaminas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static rg.quintana.buscaminas.LogicaBuscaminas.cuadricula;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        StackPane root = new StackPane ();
        var scene = new Scene(root,450,600);
        stage.setScene(scene);
        stage.show();
        Tablero tablero = new Tablero ();
        root.getChildren().add(tablero);
        LogicaBuscaminas LogicaBuscaminas = new LogicaBuscaminas();
        LogicaBuscaminas.mostrarConsola();
        for(int f=0; f<8; f++) {
            for(int c=0; c<8; c++) {
                LogicaBuscaminas.getNumBombasLinea(f,c);
            }
        } 
    }

    public static void main(String[] args) {
        launch();
    }

}