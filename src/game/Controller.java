package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 12;
    private static final float WALKING_SPEED = 6;
    
    private Walker body;

    public Controller(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) { // SPACE = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            this.body.removeAllImages();
            this.body.addImage(new BodyImage("data/DeerLeft.png", 3.5f));
            body.startWalking(- WALKING_SPEED); // LEFT ARROW = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // RIGHT ARROW = walk right
            this.body.removeAllImages();
            this.body.addImage(new BodyImage("data/Deer.png", 3.5f));
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }
    
    public void setBody(Walker body) {
        this.body = body;
    }
}
