package rg.quintana.buscaminas;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Tablero extends GridPane {

    public Tablero() {
        this.setPadding(new Insets(0, 4, 0, 4));
        for (int c = 0; c < 8; c++) {
            for (int r = 0; r < 8; r++) {
                this.add(new Casilla('.'), c, r);
            }
        }
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("Mouse clicked X,Y: "
                    + mouseEvent.getX() + " : " + mouseEvent.getY());
            int clicX = (int) mouseEvent.getX();
            int columna = clicX / Casilla.TAM_CASILLA;
            System.out.println("Columna: " + columna);
            int clicY = (int) mouseEvent.getY();
            int fila = clicY / Casilla.TAM_CASILLA;
            System.out.println("Fila: " + fila);

            this.add(new Casilla(logicaBuscaminas.cuadricula[fila][columna]), columna, fila);
            DeteccionBomba(clicX, clicY, columna, fila);

//            añadir en fila y columna una casilla del valor que le corresponda(cuadricula)
        });
    }

    public void DeteccionBomba(int clicX, int clicY, int columna, int fila) {
        if (logicaBuscaminas.cuadricula[fila][columna] == '*') {
            System.out.println("boom");
            Alert alert = new Alert(AlertType.CONFIRMATION);

            alert.setTitle(null);
            alert.setHeaderText("Oh, has pulsado una bomba");
            alert.setContentText("Elige una opción");

            // Crear un icono para la imagen de alerta
            ImageView icon = new ImageView("/Images/casillaBomba.PNG");
            icon.setFitHeight(48);
            icon.setFitWidth(48);
            // Cambiar la imagen
            alert.getDialogPane().setGraphic(icon);

            ButtonType buttonTypeOne = new ButtonType("Jugar de nuevo");
//            ButtonType buttonTypeTwo = new ButtonType("Salir");

            ButtonType buttonTypeCancel = new ButtonType("Salir", ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {
                this.setPadding(new Insets(0, 4, 0, 4));
                for (int c = 0; c < 8; c++) {
                    for (int r = 0; r < 8; r++) {
                        this.add(new Casilla('.'), c, r);
                    }
                }
            } else {
                // ... user chose CANCEL or closed the dialog
            }

        }
    }

}

//si hace bomba click en bomba que haga boom
//hacer click con el derecho que hay que pintar la bandera
