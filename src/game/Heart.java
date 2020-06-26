package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 *
 * @author kamal
 */


/**
 * A Heart.
 */
public class Heart extends DynamicBody {
    private static SoundClip heartSound;

    static {
        try {
            heartSound = new SoundClip("data/health.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape shape = new PolygonShape(
            0.026f,0.715f, 0.506f,0.644f, 0.695f,0.478f, 0.641f,-0.526f, -0.006f,-0.715f, -0.635f,-0.17f, -0.692f,0.647f);

    private static final BodyImage image =
            new BodyImage("data/heart.gif", 1.5f);

    public Heart(World world) {
        super(world, shape);
        addImage(image);

    }
    /**
     * Plays sound and then destroys the heart object.
     * Would be called in the collision handler when the character collides with the heart object.
     */
    @Override
    public void destroy()
    {
        heartSound.play();
        super.destroy();
    }
}