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

/**
 *
 * @author josem
 */
public class Casilla extends Group{
    static final short TAM_CASILLA = 30;
    Image casillaImg = new Image(getClass().getResourceAsStream("/Images/casilla.PNG"));
    ImageView ImgCasilla = new ImageView (casillaImg);
    public Casilla() {
        ImgCasilla.setFitHeight(TAM_CASILLA);
        ImgCasilla.setFitWidth(TAM_CASILLA);
        Rectangle rectCasillaSinLev = new Rectangle ();

        this.getChildren().add(rectCasillaSinLev);
        this.getChildren().add(ImgCasilla);
    }
}

    

