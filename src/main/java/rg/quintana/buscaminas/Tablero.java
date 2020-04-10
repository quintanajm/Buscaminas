package rg.quintana.buscaminas;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import static rg.quintana.buscaminas.logicBuscaminas.visible;

public class Tablero extends GridPane {

    int timersec = 0;
    int timermin = 0;
    int timerhr = 0;
    Label labelTiemp;
    final int DELAY = 1000;
    final int PERIOD = 1000;
    int estado = 1;  //victoria
    static char[][] visible = new char[8][8]; //0 tapado, 1 descubierto
    int casillasVistas = 0;
    logicBuscaminas logicBuscaminas = new logicBuscaminas();

    public Tablero(Label labelTiemp) {
        this.labelTiemp = labelTiemp;
        
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

            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                this.add(new Casilla(logicBuscaminas.cuadricula[fila][columna]), columna, fila);
                DeteccionBomba(clicX, clicY, columna, fila);
                clicCasilla(fila, columna);
            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                this.add(new Casilla('9'), columna, fila);
            }

//            añadir en fila y columna una casilla del valor que le corresponda(cuadricula)
        });
    }

    public void DeteccionBomba(int clicX, int clicY, int columna, int fila) {
        if (logicBuscaminas.cuadricula[fila][columna] == '*') {
            System.out.println("boom");
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText("GAME OVER, you hit a bomb!");
            alert.setContentText("Choose an option");

            // Crear un icono para la imagen de alerta
            ImageView icon = new ImageView("/Images/casillaBomba.PNG");
            icon.setFitHeight(48);
            icon.setFitWidth(48);
            // Cambiar la imagen
            alert.getDialogPane().setGraphic(icon);

            ButtonType buttonTypeOne = new ButtonType("Play again");
//            ButtonType buttonTypeTwo = new ButtonType("Salir");

            ButtonType buttonTypeCancel = new ButtonType("Finish", ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {

                this.getChildren().clear();
                this.setPadding(new Insets(0, 4, 0, 4));
                for (int c = 0; c < 8; c++) {
                    for (int r = 0; r < 8; r++) {
                        this.add(new Casilla('.'), c, r);

                    }
                }
                this.logicBuscaminas = new logicBuscaminas();
                logicBuscaminas.mostrarConsola();
                logicBuscaminas.getNumBombasLineas(fila, fila, fila, clicY);
                logicBuscaminas.getNumeros();

                System.out.println();

            } else {
                // ... usar opción SALIR 
            }

        }
    }

    public void clicCasilla(int f, int c) {
        //Si la casilla esta tapada
        if (visible[f][c] == 0) {
            //abre la casilla
            visible[f][c] = 1;
            casillasVistas++;
            if (casillasVistas == 54) {
                //Si llega a 54 casillas descubiertas gana
                System.out.println("Victoria");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle(null);
                alert.setHeaderText("CONGRATULATIONS, you win!");
                alert.setContentText("Choose an option");

                // Crear un icono para la imagen de alerta
                ImageView icon = new ImageView("/Images/trophy.jpg");
                icon.setFitHeight(48);
                icon.setFitWidth(48);
                // Cambiar la imagen
                alert.getDialogPane().setGraphic(icon);

                ButtonType buttonTypeOne = new ButtonType("Play again");
//            ButtonType buttonTypeTwo = new ButtonType("Salir");

                ButtonType buttonTypeCancel = new ButtonType("Finish", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeOne) {
                    this.getChildren().clear();
                    this.setPadding(new Insets(0, 4, 0, 4));
                    for (int l = 0; l < 8; l++) {
                        for (int o = 0; o < 8; o++) {
                            this.add(new Casilla('.'), l, o);

                        }
                    }
                    this.logicBuscaminas = new logicBuscaminas();
                    logicBuscaminas.mostrarConsola();
                    logicBuscaminas.getNumeros();

                } else {
                    // ... usar opción SALIR 
                }
            }
        }
    }

    public void startTime() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {

                timersec++;

                Platform.runLater(new Runnable() {
                    public void run() {

                        if (timersec == 60) {
                            timersec = 0;
                            timermin++;
                        }
                        if (timermin == 60) {
                            timermin = 0;
                            timerhr++;
                        }

                        String seconds = Integer.toString(timersec);
                        String minutes = Integer.toString(timermin);
                        String hours = Integer.toString(timerhr);

                        if (timersec <= 9) {
                            seconds = "0" + Integer.toString(timersec);
                        }
                        if (timermin <= 9) {
                            minutes = "0" + Integer.toString(timermin);
                        }
                        if (timerhr <= 9) {
                            hours = "0" + Integer.toString(timerhr);
                        }
                        labelTiemp.setText(hours + ":" + minutes + ":" + seconds);
//                        System.out.println(labelTiemp.getText());
                    }

                });

            }

        };
        timer.schedule(timerTask, DELAY, PERIOD); // (TimerTask task,long delay,long period)
//        delay =  Este es el retraso en milisegundos antes de que se ejecute la tarea.
//        period = Este es el tiempo en milisegundos entre ejecuciones de tareas sucesivas.

    }

}
