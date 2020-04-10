package rg.quintana.buscaminas;

import java.util.Timer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
        
        VBox vbox = new VBox();
        Label labelTiempo = new Label ();
        labelTiempo.setText("Time");
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(labelTiempo);
        
        
        
        Tablero tablero = new Tablero (labelTiempo);
//        llamo el objeto timer para agruparlo al vbox
        Timer timer = new Timer();
        
        tablero.startTime();
        
        vbox.getChildren().add(tablero);
        root.getChildren().add(vbox);


        logicBuscaminas LogicaBuscaminas = new logicBuscaminas();
        LogicaBuscaminas.getNumeros();
        LogicaBuscaminas.mostrarConsola();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
