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
//                mira derecha
                int numBombasDerecha = LogicaBuscaminas.getNumBombasLineas (f,c,0,1);
//                mira izquierda
                int numBombasIzquierda = LogicaBuscaminas.getNumBombasLineas (f,c,0,-1);
//                mira arriba
                int numBombasArriba = LogicaBuscaminas.getNumBombasLineas (f,c,-1,0);
//                mira abajo
                int numBombasAbajo = LogicaBuscaminas.getNumBombasLineas (f,c,1,0);
//                mira diag1
                int numBombasDiag1 = LogicaBuscaminas.getNumBombasLineas (f,c,1,1);           
//                mira diag2
                int numBombasDiag2 = LogicaBuscaminas.getNumBombasLineas (f,c,1,-1);
//                mira diag3
                int numBombasDiag3 = LogicaBuscaminas.getNumBombasLineas (f,c,-1,1);
//                mira diag4
                int numBombasDiag4 = LogicaBuscaminas.getNumBombasLineas (f,c,-1,-1);                
                
                int sumaBombas = numBombasDerecha+numBombasIzquierda+numBombasArriba+numBombasAbajo+numBombasDiag1+numBombasDiag2+numBombasDiag3+numBombasDiag4;
                System.out.println(sumaBombas);
                
                
//                int bombasderecha = LogicaBuscaminas.getNumBombasLineaDerecha(f,c);
//                int bombasizquierda = LogicaBuscaminas.getNumBombasLineaIzquierda(f,c);
//                int bombasarriba = LogicaBuscaminas.getNumBombasLineaArriba(f,c);
//                int bombasabajo = LogicaBuscaminas.getNumBombasLineaAbajo(f,c);

            }
        }
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
//el valor que me de la suma lo teno que guardar en la posicion de la matriz