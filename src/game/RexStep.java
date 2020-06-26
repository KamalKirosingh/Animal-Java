package game;
import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
/**
 *Causes the rex to change direction once it reaches a certain x-direction.
 */

public class RexStep implements StepListener {
    private Rex trex;

    public RexStep(Rex trex) {this.trex = trex;}

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        if (trex.getxPos() > trex.getStartXPos() +2){
            trex.setEnemyDirection(-1);
            this.trex.removeAllImages();
            this.trex.addImage(new BodyImage("data/trexleft.png", 6)); //flip the trex
        }
        if(trex.getxPos() < trex.getStartXPos()-2){
            trex.setEnemyDirection(1);
            this.trex.removeAllImages();
            this.trex.addImage(new BodyImage("data/trex.png", 6));
        }
        trex.getxPos();
        trex.startWalking(3*trex.getEnemyDirection());
    }
}
