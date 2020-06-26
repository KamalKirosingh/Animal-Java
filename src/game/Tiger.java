package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
/**
 *
 * @author kamal
 */


/**
 * A Tiger.
 */

public class Tiger extends Walker {
    private float startXPos = -10;
    private float xPos;
    private int enemyDirection = 1;

    private static final Shape shape = new PolygonShape(
            0.85f, 1.33f, 2.23f, 1.42f, 2.7f, 0.78f, 1.6f, -1.37f, -1.88f, -1.38f, -2.62f, -0.36f, -0.98f, 0.94f, 0.73f, 1.31f);

    private static final BodyImage image =
            new BodyImage("data/Tiger.png", 6.5f);

    public Tiger(World world) {
        super(world, shape);
        addImage(image);
        SolidFixture fixture = new SolidFixture(this, shape);
        fixture.setFriction(0);
    }

    public float getxPos() {
        xPos = getPosition().x;
        return xPos;
    }

    public float getStartXPos() {
        return startXPos; }


        public int getEnemyDirection() { return enemyDirection;}
        public void setEnemyDirection(int enemyDirection) {
        this.enemyDirection = enemyDirection;
        }
}

