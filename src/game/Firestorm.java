/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kamal
  * Firestorm in the game.
  */

public class Firestorm extends DynamicBody implements ActionListener{
    private static final Shape shape = new PolygonShape(
            0.019f,0.111f, 0.177f,0.055f, 0.142f,-0.17f, 0.034f,-0.22f, -0.095f,-0.184f, -0.121f,0.079f);

    private static final BodyImage image =
            new BodyImage("data/fire.gif", 1);

    public Firestorm(World world) {
        
        super(world, shape);
        addImage(image);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("test");
        
        System.out.println("Action event!!!!!");
    }
    
}
