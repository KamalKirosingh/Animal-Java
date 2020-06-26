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
 * A Plant.
 */
public class Plant extends DynamicBody {
private static SoundClip plantSound;

static {
    try {
        plantSound = new SoundClip("data/life.wav");
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        System.out.println(e);
    }
}

    private static final Shape shape = new PolygonShape(
            -0.227f,0.552f, -0.139f,0.624f, 0.137f,0.644f, 0.197f,0.5f, 0.273f,0.048f, -0.083f,-0.028f, -0.219f,0.508f);

    private static final BodyImage image =
            new BodyImage("data/Plant.png", 3.5f);

    public Plant(World world) {
        super(world, shape);
        addImage(image);

    }
    /**
     * Plays sound and then destroys the plant object.
     * Would be called in the collision handler when the character collides with the plant object.
     */
    @Override
    public void destroy()
    {
        plantSound.play();
        super.destroy();
    }
}



