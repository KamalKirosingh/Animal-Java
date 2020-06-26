package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 *
 * @author Kamal
 */
/**
 * Deer in the game.
 */

public class Deer extends Walker {

    private static final Shape shape = new PolygonShape(
            1.61f, -1.08f, -1.03f, -1.58f, -1.45f, 0.24f, 0.52f, 1.33f, 1.37f, 0.77f, 1.63f, -1.04f);

    private static final BodyImage image =
            new BodyImage("data/Deer.png", 3.5f);

    private int score;
    private int lives;
    private static SoundClip tigerDie;
    private static SoundClip lionDie;
    private static SoundClip rexDie;
    private SoundClip firestormDeath;
    private SoundClip powerupSound;


    public Deer(World world) {
        super(world, shape);
        addImage(image);
        score = 0;
        lives = 9;
    }
    /**
     * set the number of plants the character has collected.
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * The number of plants the character has collected.
     * @return score integer variable, this specifies how many plants have been collected.
     */
    public int getScore() {
        return score;
    }
    /**
     * Adds one to the score variable.
     * This would be called where the character's collisions with the coins are handled.
     */
    public void incrementScore() {
        score++;
        System.out.println("Tasty! Score = " + score);
    }
    /**
     * set the lives.
     */
    public void setLives(int lives) {
        this.lives = lives;
    }
    /**
     * return the lives.
     */
    public int getLives() {
        return lives;
    }
    /**
     * Adds 1 to the variable lives, used to hold the number of lives the user has remaining.
     * This would be called in the character's collision handler when the character collides with the heart object.
     */

    public void incrementLives() {
        lives++;
        System.out.println("Caught! Lives = " + lives);}
    /**
     * Minuses 1 from the variable lives, used to hold the number of lives the user has remaining. Provides an exit
     * condition from the game if lives reaches 0.
     * This would be called in the character's collision handler when the character collides with any enemy objects.
     */

    public void decrementLives() {
        lives--;
        System.out.println("Caught! Lives = " + lives);
        if (lives == 0) {
            System.exit(0);
        }
    }
        /**
         * Plays the sound 'tiger.wav' which is a sound made by the tiger.
         * Would be used in the collision handler when the character collides with the tiger.
         */
        public void playSoundTiger(){
            try {

                tigerDie = new SoundClip("data/tiger.wav");
                tigerDie.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException r) {
                System.out.println(r);
            }
        }

    /**
     * Plays the sound 'lion.wav' which is a sound made by the lion.
     * Would be used in the collision handler when the character collides with the lion.
     */
    public void playSoundLion(){
        try {

            lionDie = new SoundClip("data/lion.wav");
            lionDie.play();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException r) {
            System.out.println(r);
        }
    }

    /**
     * Plays the sound 'hurt.wav' which is a sound made by the trex.
     * Would be used in the collision handler when the character collides with the trex.
     */
    public void playSoundRex(){
        try {

            rexDie = new SoundClip("data/trex.wav");
            rexDie.play();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException r) {
            System.out.println(r);
        }
    }

    /**
     * Plays the sound fireball
     * Would be used in the collision handler when the character collides with an enemy.
     */
    public void playSoundFire(){
        try {
            firestormDeath = new SoundClip("data/fireball.wav");
            firestormDeath.play();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException r) {
            System.out.println(r);
        }
    }

    /**
     * Plays the sound boing.wav which is a spring sound.
     * Would be used in the collision handler when the character collides with a powerup or spring.
     */
    public void playSoundPowerup(){
        try {

            powerupSound = new SoundClip("data/boing.wav");
            powerupSound.play();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException r) {
            System.out.println(r);
        }
    }
}


