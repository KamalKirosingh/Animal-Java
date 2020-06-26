package game;

import city.cs.engine.*;
/**
 *
 * @author kamal
 */


/**
 * A Lion.
 */

public class Lion extends Walker {
    private float startXPos = -6;
    private float xPos;
    private int enemyDirection = 1;

    private static final Shape shape = new PolygonShape(
            -0.92f,1.72f, 2.35f,1.3f, 2.53f,-0.45f, 1.26f,-1.66f, -2.16f,-1.64f, -2.59f,0.99f, -1.89f,1.67f);


    private static final BodyImage image =
            new BodyImage("data/lionleft.png", 3.5f);

    public Lion(World world) {
        super(world, shape);
        addImage(image);
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