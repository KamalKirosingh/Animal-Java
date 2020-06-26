package game;

import java.awt.*;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class MyView extends UserView {
    Deer deer;
    private Image background;
    private Game game;

    public MyView(World world, Deer deer, Game game, int width, int height) {
        super(world, width, height);
        this.deer = deer;
        this.game = game;
        this.background = new ImageIcon("data/Background.png").getImage();
    }

    public void updateDeer(Deer deer) {
        this.deer = deer;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.getLevel()==1){
            this.background = new ImageIcon("data/Flat Night 2 BG.png").getImage();
            g.drawImage(background, 0, -173, this);
        }

        if (game.getLevel()==2){
            this.background = new ImageIcon("data/Background.png").getImage(); //change background
            g.drawImage(background, 0, -280, this);

        }
        if (game.getLevel()==3){
            this.background = new ImageIcon("data/NighBg.png").getImage(); //change background
            g.drawImage(background, -50, -160, this);
        }

    }

    protected void paintForeground(Graphics2D g) {
        g.scale(1.5, 1.5);
        g.setColor(Color.WHITE);
        g.drawString("LIVES: " + deer.getLives(), 420, 50);
        g.drawString("SCORE: " + deer.getScore(), 25, 50);
    }
}








