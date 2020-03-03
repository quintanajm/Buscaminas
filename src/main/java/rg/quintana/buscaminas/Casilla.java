/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rg.quintana.buscaminas;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author josem
 */
public class Casilla extends Group{
    public Casilla() {
        Rectangle rectCasillaSinLev = new Rectangle ();
        rectCasillaSinLev.setWidth(30);
        rectCasillaSinLev.setHeight(30);
        rectCasillaSinLev.setFill(Color.GRAY);
        this.getChildren().add(rectCasillaSinLev);
    }
}

    

