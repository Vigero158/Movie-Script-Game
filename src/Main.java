import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GUI myGUI = new GUI();
        Random generator = new Random();
        ScriptReader script = new ScriptReader();
        HashMap<String, String> text = new HashMap<>();

        try {
            text = script.readFile("E:/JavaProjects/Movie Script Game/MovieScripts");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[] values = text.values().toArray();
        String[] wordList;
        String[] movieNames = new String[text.size()];

        text.keySet().toArray(movieNames);
        // TODO: 7/6/2020 set it so the user can select what speed they want, add an impossible speed with a .sleep of 1 millisecond
        int speed;
        int score = 0;
        while (true) {
            // String randomScript = (String) movieNames[generator.nextInt(movieNames.length)];
            String movieName = movieNames[generator.nextInt((movieNames.length))];
            String randomScript = text.get(movieName);
            wordList = randomScript.split(" ");

            for (String word : wordList) {
                if (myGUI.enteredText.equals(movieName)) {
                   // score += myGUI.wordAmount - wordList.length;
                    break;
                }
                myGUI.wordText.setText("Word: " + word);
                myGUI.label.setText("Number of words shown: " + myGUI.wordAmount++);
                TimeUnit.SECONDS.sleep( 1);

            }
            while (!myGUI.enteredText.equals("yes") && !myGUI.enteredText.equals("no")) {
                TimeUnit.SECONDS.sleep(1);
                myGUI.wordText.setText("Would you like to play again? Yes/No");
            }

            if (myGUI.enteredText.equals("yes")) {
                myGUI.wordAmount = 1;
                continue;
            } else if (myGUI.enteredText.equals("no")) {
                break;
            }
        }
        myGUI.frame.dispose();
    }
}
