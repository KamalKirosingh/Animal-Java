package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Deer deer;

    /**
     * Initialises deer variable.
     *
     * @param deer, the character the user controls.
     */
    public Pickup(Deer deer) {
        this.deer = deer;
    }

    /**
     * Handles all collisions involving the main character.
     * Other methods are called within this method to make things happen when the main character collides with something.
     * For example when the main character collides with an enemy decrementLives is called.
     *
     * @param e Objects involved in the collision.
     */

    @Override
    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof Plant && e.getOtherBody() == deer) {
            deer.incrementScore();
            e.getReportingBody().destroy();
        }
        if (e.getReportingBody() instanceof Heart && e.getOtherBody() == deer) {
            deer.incrementLives();
            e.getReportingBody().destroy();
        }
        if (e.getReportingBody() instanceof Tiger && e.getOtherBody() == deer) {
            deer.decrementLives();
            deer.playSoundTiger();
        }
        if (e.getReportingBody() instanceof Rex && e.getOtherBody() == deer) {
            deer.decrementLives();
            deer.playSoundRex();
        }
        if (e.getReportingBody() instanceof Lion && e.getOtherBody() == deer) {
            deer.decrementLives();
            deer.playSoundLion();
        }
        if (e.getReportingBody() instanceof Firestorm && e.getOtherBody() == deer) {
            e.getReportingBody().destroy();
            deer.decrementLives();
            deer.playSoundFire();
            System.out.println(deer.getLives() + "fire");
        }
        if (e.getReportingBody() instanceof Powerup && e.getOtherBody() == deer) {
            deer.setLinearVelocity(new Vec2(0, 15));
            deer.playSoundPowerup();
            System.out.println("hit powerup");
        }

    }
}


