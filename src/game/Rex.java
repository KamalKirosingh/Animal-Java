package game;

import city.cs.engine.*;
/**
 *
 * @author kamal
 */


/**
 * A T-rex.
 */

public class Rex extends Walker {
    private float startXPos = 5;
    private float xPos;
    private int enemyDirection = 1;

    private static final Shape shape = new PolygonShape(
            3.38f,2.64f, 4.43f,1.45f, -0.31f,-2.72f, -4.12f,-1.99f, -4.39f,0.25f, 1.37f,2.51f);


    private static final BodyImage image =
            new BodyImage("data/trexleft.png", 6);

    public Rex(World world) {
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