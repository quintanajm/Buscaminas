/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rg.quintana.buscaminas;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import static rg.quintana.buscaminas.logicaBuscaminas.cuadricula;

/**
 *
 * @author josem
 */
public class Casilla extends Group {

    static final short TAM_CASILLA = 30;
    Image casillaImg = new Image(getClass().getResourceAsStream("/Images/casilla.PNG"));
    ImageView ImgCasilla = new ImageView(casillaImg);
    Image casillaBomba = new Image(getClass().getResourceAsStream("/Images/casillaBomba.PNG"));
    Image casilla0 = new Image(getClass().getResourceAsStream("/Images/casilla0.PNG"));
    Image casilla1 = new Image(getClass().getResourceAsStream("/Images/casilla1.PNG"));
    Image casilla2 = new Image(getClass().getResourceAsStream("/Images/casilla2.PNG"));
    Image casilla3 = new Image(getClass().getResourceAsStream("/Images/casilla3.PNG"));
    Image casilla4 = new Image(getClass().getResourceAsStream("/Images/casilla4.PNG"));
    Image casilla5 = new Image(getClass().getResourceAsStream("/Images/casilla5.PNG"));
    Image casilla6 = new Image(getClass().getResourceAsStream("/Images/casilla6.PNG"));
    Image casilla7 = new Image(getClass().getResourceAsStream("/Images/casilla7.PNG"));
    Image casilla8 = new Image(getClass().getResourceAsStream("/Images/casilla8.PNG"));

    public Casilla(char numeroMinas) {
        ImgCasilla.setFitHeight(TAM_CASILLA);
        ImgCasilla.setFitWidth(TAM_CASILLA);
        Rectangle rectCasillaSinLev = new Rectangle();

        this.getChildren().add(rectCasillaSinLev);
        this.getChildren().add(ImgCasilla);

//        casillaNormal
        if (numeroMinas == '.') {
            ImgCasilla.setImage(casillaImg);
        }
//        casillaBomba
        if (numeroMinas == '*') {
            ImgCasilla.setImage(casillaBomba);
        }
        if (numeroMinas == '0') {
            ImgCasilla.setImage(casilla0);
        }
        if (numeroMinas == '1') {
            ImgCasilla.setImage(casilla1);
        }
        if (numeroMinas == '2') {
            ImgCasilla.setImage(casilla2);
        }
        if (numeroMinas == '3') {
            ImgCasilla.setImage(casilla3);
        }
        if (numeroMinas == '4') {
            ImgCasilla.setImage(casilla4);
        }
        if (numeroMinas == '5') {
            ImgCasilla.setImage(casilla5);
        }
        if (numeroMinas == '6') {
            ImgCasilla.setImage(casilla6);
        }
        if (numeroMinas == '7') {
            ImgCasilla.setImage(casilla7);
        }
        if (numeroMinas == '8') {
            ImgCasilla.setImage(casilla8);
        }
        

    }

//    crear un método que permita cambiar la imagen de la casilla, pasándole por parametros el número de minas
//    cambiar la imagen al imageview
}
