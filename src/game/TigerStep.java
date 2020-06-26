package game;
import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
/**
 *Causes the tiger to change direction once it reaches a certain x-direction.
 */

public class TigerStep implements StepListener {
    private Tiger tiger;

    public TigerStep(Tiger tiger) {this.tiger = tiger;}

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        if (tiger.getxPos() > tiger.getStartXPos() +27.1f){
            tiger.setEnemyDirection(-1);
            this.tiger.removeAllImages();
            this.tiger.addImage(new BodyImage("data/TigerLeft.png", 6.5f)); //flip the tiger so facing correct direction
        }
        if(tiger.getxPos() < tiger.getStartXPos()-6){
            tiger.setEnemyDirection(1);
            this.tiger.removeAllImages();
            this.tiger.addImage(new BodyImage("data/Tiger.png", 6.5f));
        }
        tiger.getxPos();
        tiger.startWalking(3*tiger.getEnemyDirection());
    }
}
