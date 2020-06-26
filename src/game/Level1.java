package game;

import city.cs.engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;


/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel implements ActionListener{

    private static final int NUM_PLANT = 5;
    private Timer timer;
    public int timeCount;


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
        Shape leftWallShape = new BoxShape(0.000005f, 6, new Vec2(-20.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.00005f, 6, new Vec2(20f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(5, -5.5f));

        for (int i = 0; i < 5; i++) {
            Body plant = new Plant(this);
            plant.setPosition(new Vec2(i*2-4, 10));
            plant.addCollisionListener(new Pickup(getPlayer()));
            }
        }
    /**
     * starting position of the player.
     * @return Vec2 coordinates.
     */
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
        return new Vec2(-100, 100);
    }
    /**
     * starting position of the rex.
     * @return Vec2 coordinates.
     */
    @Override
    public Vec2 rexPosition() {
        return new Vec2(-100, 100);
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
         * @return The number of plants collected by the player.
         */

    @Override
    public boolean isCompleted() { return getPlayer().getScore() >= NUM_PLANT; }
    /**
     * increments timeCount by 1 each second.
     */
    @Override
    public void actionPerformed(ActionEvent e) { timeCount++;

    }

}

