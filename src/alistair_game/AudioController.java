package alistair_game;

import org.newdawn.slick.*;

public class AudioController  {
    /** Handles the game audio.
     * Initialized in App.init().
     * To play a sound, call play(event) */

    private static Sound[] intro = new Sound[2];
    private static Sound[] gameover = new Sound[2];
    private static Sound victory, quickSort, python, mergeSort, insertionSort, commerceStudent, alcohol;

    static void init() {
        try {
            String path = "assets\\audio\\";

            // Sounds
            intro[0] = new Sound(path + "Intro.ogg");
            intro[1] = new Sound(path + "Intro2.ogg");
            gameover[0] = new Sound(path + "GameOver.ogg");
            gameover[1] = new Sound(path + "Gameover2.ogg");

            victory = new Sound(path + "Victory.ogg");

            alcohol = new Sound(path + "Alcohol.ogg");
            commerceStudent = new Sound(path + "CommerceStudent.ogg");
            python = new Sound(path + "Python.ogg");

            insertionSort = new Sound(path + "InsertionSort.ogg");
            mergeSort = new Sound(path + "MergeSort.ogg");
            quickSort = new Sound(path + "QuickSort.ogg");

            // Music
            // TODO: Find some music? Can add an array of songs to a musicLoop() method.
            /*
            Music bgmusic = new Music(Path + "");
            bgmusic.loop();
            */
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

    public static void play(String event) {
        // TODO: Add pitch and volume control
    	// TODO: put the sounds in a hash map
        switch (event) {
            case "intro":
                intro[Util.rand(intro.length)].play();
                break;
            case "gameover":
                gameover[Util.rand(gameover.length)].play();
                break;
            case "victory":
                victory.play();
                break;
            case "quicksort":
                quickSort.play();
                break;
            case "insertionsort":
                insertionSort.play();
                break;
            case "mergesort":
                mergeSort.play();
                break;
            case "python":
                python.play();
                break;
            case "alcohol":
            	alcohol.play();
            	break;
            case "commercestudent":
            	commerceStudent.play();
        }
    }
}
