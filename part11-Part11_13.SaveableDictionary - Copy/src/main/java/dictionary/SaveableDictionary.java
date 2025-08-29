package dictionary;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
    private HashMap<String, String> dict;
    private String file;
    //private HashMap<String, String> finToEng;

    public SaveableDictionary() {
        this.dict = new HashMap<>();
    }

    //constructor doesn't read file, only tells dictionary the name of the file
    public SaveableDictionary(String file) {
        this.dict = new HashMap<>();
        this.file = file;
    }

    //reads from the file passed to the Dict object from its constructor
    //Then parses each line as a word:translation pair and adds it to this.dict
    public boolean load() {
        boolean wasSuccess;
        try (Scanner fileReader = new Scanner(Paths.get(this.file))) {
            while (fileReader.hasNext()) {
                //read next line of file
                String line = fileReader.nextLine();
                //parse the line that's currently formatted something like "apina:monkey" or "alla oleva:below"
                String[] parts = line.split(":");
                String word = parts[0];
                String translation = parts[1];
                this.dict.put(word, translation);
            }
            wasSuccess=true;
        } catch (Exception e) {
            System.out.println(e);
            wasSuccess=false;
        }
        return wasSuccess;
    }

    public boolean save() {
        boolean wasSuccessful;
        try {
            PrintWriter writer = new PrintWriter(this.file);
            for (String key : this.dict.keySet()) {
                writer.println(String.format("%s:%s", key, this.dict.get(key)));
            }
            writer.close();
            wasSuccessful=true;
        } catch (Exception e) {
            System.out.println(e);
            wasSuccessful=false;
        }
        return wasSuccessful;
    }

    public void add(String word, String translation) {
        dict.putIfAbsent(word, translation);
    }

    public String translate(String word) {
        String translation = null;
        //check if the word argument is one of the keys
        if (this.dict.containsKey(word)) {
            translation = this.dict.get(word);
            return translation;
        }
        //check if the word argument is one of the values
        //iterate through each key and check its corresponding value
        for (String key : this.dict.keySet()) {
            if (this.dict.get(key).equals(word)) {
                translation = key;
                return translation;
            }
        }
        //if word was neither a key nor a value, return null
        return translation;
    }

    //this works but suggested solution calls translate() and then
    //simply does dict.remove(word) and dict.remove(translation)
    public void delete(String word) {
        //check if word arg is one of the keys
        if (this.dict.containsKey(word)) {
            this.dict.remove(word);
            return;
        }
        //check if word arg is one of the values by iterating through each key and checking
        //its corresponding value
        for (String key : this.dict.keySet()) {
             if (this.dict.get(key).equals(word)){
            this.dict.remove(key);
            return;
        }
        }
    }
}
