package alistair_game;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import org.newdawn.slick.*;

public class AudioController {
    /**
     * Handles the game audio. Initialized in App.init(). To play a sound, call
     * play(event)
     */

    private static HashMap<String, Sound> singleSounds = new HashMap<String, Sound>();
    private static HashMap<String, Sound[]> listSounds = new HashMap<String, Sound[]>();
    static {
        // Load audio files
        File folder = new File("assets\\audio");
        try {
            for (File f : folder.listFiles()) {
                if (f.isFile()) {
                    // Get file name without extension
                    String name = f.getName().replaceFirst("[.][^.]+$", "");
                    // Add the sound to the hash map
                    singleSounds.put(name.toLowerCase(), new Sound(f.getPath()));
                } else {
                    // Add all the sounds in the subfolder to an array
                    Sound[] new_sounds = Arrays.stream(f.listFiles()).filter(file -> file.isFile()).map(file -> {
                        try {
                            return new Sound(file.getPath());
                        } catch (SlickException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }).toArray(Sound[]::new);
                    listSounds.put(f.getName().toLowerCase(), new_sounds);
                }
            }
        } catch (SlickException e) {
            e.printStackTrace();
        }

        // TODO: Find some music? Can add an array of songs to a musicLoop() method.
    }

    public static void play(String event) {
        // TODO: Add pitch and volume control
        Sound[] list = listSounds.get(event);
        if (list != null) {
            list[Util.rand(list.length)].play();
        } else {
            Sound single = singleSounds.get(event);
            if (single != null) {
                single.play();
            } else {
                System.err.printf("ERROR: Could not find sound '%s'%n", event);
            }
        }
    }
}
