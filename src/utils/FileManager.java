package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    /** Reads from a text file
     *
     * @param fileName the name of the file
     * @return a list of strings where each item corresponds to a line in the file
     * @throws IOException */
    public static List<String> readText(String fileName) throws IOException {
        Scanner sc= new Scanner(new File(fileName));

        List<String> ret= new ArrayList<>();

        while (sc.hasNext()) {
            ret.add(sc.nextLine());
        }
        sc.close();
        return ret;
    }

    /** Writes to a text file
     *
     * @param fileName the name of the file
     * @param data     each item in the list corresponds to a line in the output file
     * @throws IOException */
    public static void writeText(String fileName, List<String> data) throws IOException {
        FileWriter fw= new FileWriter(fileName);
        for (String s : data) fw.write(s + "\n");
        fw.close();
    }

    /** Determines if file exists
     *
     * @param fileName
     * @return true if file exists and false if file does not exist */
    public static boolean isFileExist(String fileName) {
        File testFile= new File(fileName);
        if (testFile.isFile()) return true;
        else return false;
    }
}
