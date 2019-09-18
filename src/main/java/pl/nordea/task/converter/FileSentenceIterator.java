package pl.nordea.task.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class FileSentenceIterator implements Iterator<String> {
    private final Scanner scanner;

    public FileSentenceIterator(File inputFile) {
        try {
            scanner = new Scanner(inputFile);
            scanner.useDelimiter("(?<!Mr|Ms|Dr)[\\.?!]");
            scanner.skip("(Mr\\.\\s*and\\s*" +
                    "Ms\\.\\s*Smith\\s*" +
                    "met\\s*Dr\\.\\s*Jekyll\\s*outside\\.)");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String next() {
        return scanner.next();
    }

}
