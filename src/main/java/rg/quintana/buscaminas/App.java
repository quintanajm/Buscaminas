package rg.quintana.buscaminas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static rg.quintana.buscaminas.logicBuscaminas.cuadricula;
//llamada al numero y mostrar en consola
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        StackPane root = new StackPane ();
        var scene = new Scene(root,250,280);
        stage.setScene(scene);
        stage.show();
        Tablero tablero = new Tablero ();
        root.getChildren().add(tablero);
        logicBuscaminas LogicaBuscaminas = new logicBuscaminas();
        LogicaBuscaminas.mostrarConsola();
        LogicaBuscaminas.getNumeros();
        LogicaBuscaminas.mostrarConsola();

    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
//el valor que me de la suma lo teno que guardar en la posicion de la matriz