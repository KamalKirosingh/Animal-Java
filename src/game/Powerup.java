/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

import java.awt.*;

/**
 *
 * @author kamal
 */


/**
 * A powerup.
 */
public class Powerup extends StaticBody {   
    
    /**
     * Initialise a new powerup.
     * @param world The world.
     */
    public Powerup(World world) {
        super(world, new BoxShape(0.55f, 0.5f));
        setFillColor(Color.green);
    }
}
