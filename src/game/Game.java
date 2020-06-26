package game;

import city.cs.engine.SoundClip;

import java.awt.*;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;
    private int level;
    private Controller controller;
    private SoundClip gameMusic;
    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1(); {
        }

        world.populate(this);
        world.addStepListener(new TigerStep(world.getTiger()));
        try {
            gameMusic = new SoundClip("data/itachi.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        view = new MyView(world, world.getPlayer(), this,800, 500);

        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");

        Container buttons = new ControlPanel(this);
        frame.add(((ControlPanel) buttons).getMainPanel(), BorderLayout.WEST);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));


        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // uncomment to make the view track the bird
        // world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    /**
     * The player in the current level.
     */
    public Deer getPlayer() {
        return world.getPlayer();
    }
    /**
     * Freezes everything in the game.
     */
    public void pause() {
        world.stop();
    }
    /**
     * Unfreezes everything in the game. If the game has not been paused (frozen) this does not do anything.
     */
    public void resume() {
        world.start();
    }

    /**
     * Sets the game state back to its original settings. Game restarts at level 1 with max lives and no coins collected.
     */
    public void reset(){
        world.stop();
        world = new Level1();
        world.populate(this);
        world.addStepListener(new TigerStep(world.getTiger()));
        controller.setBody(world.getPlayer());
        view.setWorld(world);
        world.start();
    }
    /**
     * Skips the level so the win condition does not need to be met in order to progress.
     * This also handles music playing in each level. The variable gameMusic is reset and given a new sound file when
     * the level progress. This ensures that when a level is skipped the music also changes with the level.
     */

    public void skip(){
        world.stop();
        if (level == 3) {
            System.exit(0);
        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TigerStep(world.getTiger()));
            world.addStepListener(new LionStep(world.getLion()));
            world.addStepListener(new RexStep(world.getTrex()));
            view.updateDeer(world.getPlayer());
            // switch the keyboard control to the new players
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            gameMusic.close();
            try {
                gameMusic = new SoundClip("data/itachi.wav");   // Open an audio input stream
                 gameMusic.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
               System.out.println(e);
           }
            world.start();

        } else if (level == 2){
            level++;
            // get a new world
            world = new Level3();
            gameMusic.close();
            try {
                gameMusic = new SoundClip("data/itachi.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TigerStep(world.getTiger()));
            world.addStepListener(new LionStep(world.getLion()));
            world.addStepListener(new RexStep(world.getTrex()));
            view.updateDeer(world.getPlayer());
            // switch the keyboard control to the new players
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
    }

    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /** Advance to the next level of the game.
     * This also handles music playing in each level. The variable gameMusic is reset and given a new sound file when
     * the level progress. This ensures that when the user progresses the music also changes with the level.
     */
    public void goNextLevel() {
        world.stop();
        if (level == 3) {
            System.exit(0);
        }

        else if (level == 0) {
            level++;
            // get a new world
            world = new Level1();
            gameMusic.close();
            try {
                gameMusic = new SoundClip("data/itachi.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TigerStep(world.getTiger()));
            world.addStepListener(new LionStep(world.getLion()));
            world.addStepListener(new RexStep(world.getTrex()));
            view.updateDeer(world.getPlayer());
            // switch the keyboard control to the new players
            controller.setBody(world.getPlayer());

            // show the new world in the view
            view.setWorld(world);
            world.start();
        }

        else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            gameMusic.close();
            try {
                gameMusic = new SoundClip("data/itachi.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TigerStep(world.getTiger()));
            world.addStepListener(new LionStep(world.getLion()));
            view.updateDeer(world.getPlayer());
            // switch the keyboard control to the new players
            controller.setBody(world.getPlayer());

            // show the new world in the view
            view.setWorld(world);
            world.start();

        } else if (level == 2){
            level++;
            // get a new world
            world = new Level3();
            gameMusic.close();
            try {
            gameMusic = new SoundClip("data/itachi.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TigerStep(world.getTiger()));
            world.addStepListener(new LionStep(world.getLion()));
            world.addStepListener(new RexStep(world.getTrex()));
            view.updateDeer(world.getPlayer());
            // switch the keyboard control to the new players
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
    }
    /**
     * set the level.
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * return the level.
     */
    public int getLevel(){
        return level;
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}

