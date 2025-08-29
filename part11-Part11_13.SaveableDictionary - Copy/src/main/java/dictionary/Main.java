package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here

        // original contents of words.txt:
        // apina:monkey
        // alla oleva:below
        // olut:beer

        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        dictionary.load();

        // boolean wasSuccessful = dictionary.load();

        // if (wasSuccessful) {
        // System.out.println("Successfully loaded the dictionary from file");
        // }

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("ohjelmointi"));
        System.out.println(dictionary.translate("alla oleva"));

        dictionary.delete("monkey");

        System.out.println(dictionary.translate("apina"));

        dictionary.save();
    }
}
