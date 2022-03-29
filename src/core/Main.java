package core;

import java.io.IOException;
import java.util.List;

import utils.FileManager;
import utils.PrettyPrint;
import utils.SuffixTree;

public class Main {
    public static void main(String args[]) throws IOException {
        PrettyPrint.ScrollTextPrintln(
            "##### Hello and welcome to Java Pigeon #####",
            50l,
            0l);
        PrettyPrint.ScrollTextPrint(
            "Create by Jeffrey Qian",
            50l,
            1000l);
        PrettyPrint.ScrollTextPrintln(
            "...In his attempt to beat his friends\n",
            50l,
            400l);

        PrettyPrint.ScrollTextPrintln(
            "Initializing dictionary...",
            50l,
            0l);

        // Make sure that all words have been processed ( >= length 3)
        // lowercase
        // remove special character!

        List<String> dictionary= null;
        if (!FileManager.isFileExist(Config.FILTERED_DICT_FILE)) {
            List<String> lst= FileManager.readText(Config.RAW_DICT_FILE);
            lst.removeIf((String s) -> s.length() < 3);
            lst.replaceAll((s) -> s.toLowerCase());
            lst.removeIf((String s) -> {
                for (int i= 0; i < s.length(); i++ ) {
                    char letter= s.charAt(i);
                    if (letter < 'a' || letter > 'z') return true;
                }
                return false;
            });

            FileManager.writeText(Config.FILTERED_DICT_FILE, lst);
            dictionary= lst;
        } else {
            dictionary= FileManager.readText(Config.FILTERED_DICT_FILE);
        }

        // constructing
        PrettyPrint.ScrollTextPrintln(
            "Initializing suffix tree...",
            50l,
            0l);

        SuffixTree suffixTree= new SuffixTree(dictionary);

    }
}
