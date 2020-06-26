package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel implements ActionListener {

    private static final int NUM_PLANT = 11;
    private Timer timer;
    private Heart heart;

    /**
     * Populate the world.
     */

    @Override
    public void populate(Game game) {
        super.populate(game);
        timer = new Timer(10000, this);
        timer.setInitialDelay(100);
        timer.start();

        // make the ground
        Shape groundShape = new BoxShape(100, 0.00000005f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -9.87f));

        // walls
        Shape leftWallShape = new BoxShape(0.00000005f, 6, new Vec2(-20.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.00000005f, 20, new Vec2(20f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make some platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(5, -5.5f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-6, 0.5f));
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(5, 6.5f));
        Shape platform4Shape = new BoxShape(2, 0.5f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(18, 9));
        platform4.setFillColor(Color.green);

        //power up
        Powerup powerup = new Powerup(this);
        powerup.setPosition(new Vec2(13, -1.5f));
        powerup.addCollisionListener(new Pickup(getPlayer()));

        //heart
        heart = new Heart(this);
        heart.setPosition(new Vec2(18,10));
        heart.addCollisionListener(new Pickup(getPlayer()));

        for (int i = 0; i < NUM_PLANT; i++) {
            Body plant = new Plant(this);
            plant.setPosition(new Vec2(i * 2 - 10, 10));
            plant.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {return new Vec2(5, -9.5f);}
    /**
     * starting position of the tiger.
     * @return Vec2 coordinates.
     */
    @Override
    public Vec2 tigerPosition() {
        return new Vec2(-10, -9);
    }
    /**
     * starting position of the lion.
     * @return Vec2 coordinates.
     */
    @Override
    public Vec2 lionPosition() {
        return new Vec2(-6, 0.7f);
    }
    /**
     * starting position of the trex.
     * @return Vec2 coordinates.
     */
    @Override
    public Vec2 rexPosition() {
        return new Vec2(5, 10);
    }
    /**
     * Position of the door within the game.
     * @return the coordinates of the door.
     */
    @Override
    public Vec2 doorPosition() {
        return new Vec2( -19.5f, -8.5f);
    }

    /**
     * Win condition, method to allow user to progress to the next level should the condition be met.
     *
     * @return The number of plants collected by the player.
     */
    @Override
    public boolean isCompleted() {
        return getPlayer().getScore() == NUM_PLANT;
    }

    /**
     * Creates a set of 5 fireballs every specified time interval.
     * The fireballs can be created in 3 different positions for variety.
     * @param ae variable passes in from the timer.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        Random rand = new Random();
        int  n = rand.nextInt(3) + 1;
        switch (n) {

            case 1:
                for (int i = 0; i < 2; i++) {
                    Firestorm firestorm = new Firestorm(this);
                    firestorm.setPosition(new Vec2(i*2-10, 10));
                    firestorm.addCollisionListener(new Pickup(getPlayer()));
                    firestorm.setGravityScale(0.2f);

                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    Firestorm firestorm2 = new Firestorm(this);
                    firestorm2.setPosition(new Vec2(i*2, 10));
                    firestorm2.addCollisionListener(new Pickup(getPlayer()));
                    firestorm2.setGravityScale(0.2f);

                }
                break;
            case 3:
                for (int i = 0; i < 2; i++) {
                    Firestorm firestorm3 = new Firestorm(this);
                    firestorm3.setPosition(new Vec2(i*2+10, 10));
                    firestorm3.addCollisionListener(new Pickup(getPlayer()));
                    firestorm3.setGravityScale(0.2f);

                }
                break;
            default:
                break;

        }

    }
}
