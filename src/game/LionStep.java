package game;
import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
/**
 *Causes the lion to change direction once it reaches a certain x-direction.
 */

public class LionStep implements StepListener {
    private Lion lion;

    public LionStep(Lion lion) {this.lion = lion;}

    @Override
    public void preStep(StepEvent e) {
    }
    @Override
    public void postStep(StepEvent e) {
        if (lion.getxPos() > lion.getStartXPos() +2){
            lion.setEnemyDirection(-1);
            this.lion.removeAllImages();
            this.lion.addImage(new BodyImage("data/lion.png", 3.5f));
        }
        if(lion.getxPos() < lion.getStartXPos()-2){
            lion.setEnemyDirection(1);
            this.lion.removeAllImages();
            this.lion.addImage(new BodyImage("data/lionleft.png", 3.5f)); //so facing correct direction
        }
        lion.getxPos();
        lion.startWalking(3*lion.getEnemyDirection());
    }
}
