package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Deer player;
    private Tiger tiger;
    private Lion lion;
    private Rex trex;

    public Deer getPlayer() {
        return player;
    }
    public Tiger getTiger() { return tiger;}
    public Lion getLion() { return lion;}
    public Rex getTrex() {return trex;}

    /** -5,-8  -8, 4.5
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        // make a character
        // the object that the code was written in
        player = new Deer(this);
        player.setPosition(startPosition());

        //tiger
        tiger = new Tiger(this);
        tiger.setPosition(tigerPosition());
        tiger.addCollisionListener(new Pickup(player));

        //lion
        lion = new Lion(this);
        lion.setPosition(lionPosition());
        lion.addCollisionListener(new Pickup(getPlayer()));

        //trex
        trex = new Rex(this);
        trex.setPosition(rexPosition());
        trex.addCollisionListener(new Pickup(getPlayer()));

        //door
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();


    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** The position of the  tiger. */
    public abstract Vec2 tigerPosition();

    /** The position of the lion. */
    public abstract Vec2 lionPosition();

    /** The position of the t-rex. */
    public abstract Vec2 rexPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();

    public abstract void actionPerformed(ActionEvent ae);
}
