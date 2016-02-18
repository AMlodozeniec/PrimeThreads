package primeThreads.util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * CS442 Assignment 2
 * FileProcessor.java
 * Purpose: Class for file operations. Reads and returns a line from
 * a given file.
 *
 */
public class FileProcessor {

    private FileReader input;
    private BufferedReader buffInput;
    private String line = null;

    /**
    * Constructor. Instantiates FileReader input using file arg.
    * Uses input to create new BufferedReader object. 
    *
    * @args FileReader file   one line of a file
    */
    public FileProcessor(FileReader file) {
        this.input = file;
        this.buffInput = new BufferedReader(input);
    }

    /**
    * Method to read and return one line from the file.
    *
    * @return String  one line of file
    */
    public String readLineFromFile() {
        try {
            line = buffInput.readLine();
            return line;
        } catch (IOException e) {
            System.err.println("Error reading file. Exiting");
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    /**
     * Override toString() method for debugging
     *
     * @return String   class description for debugging
     */
    public String toString() {
        return "primeThreads.util.FileProcessor.";
    }
}
