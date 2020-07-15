import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ScriptReader {

    public String[] words(String text) {
        String[] array = text.split(" ");
        return array;
    }


    public HashMap<String, String> readFile(String fileName) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        String text = "";
        String line = reader.readLine();
        int counter = 0;

        while (line != null) {
            // text += line + "\n";
            list.add(line);
            line = reader.readLine();
            counter ++;
        }

        String[] temporaryList = new String[2];
        for (String lines : list) {
            temporaryList = lines.split(":");
            hashMap.put(temporaryList[0], temporaryList[1]);
        }
        return hashMap;
    }
}
