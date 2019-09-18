package pl.nordea.task.converter.xml;

import pl.nordea.task.converter.FileSentenceIterator;
import pl.nordea.task.model.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlConverter {

    public void convert(File inputFile, File outputFile) {
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(inputFile);
        XmlStreamWriter xmlStreamWriter = null;

        try {
            xmlStreamWriter = new XmlStreamWriter(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        xmlStreamWriter.startDocument();
        while (fileSentenceIterator.hasNext()) {
            Sentence sentence = new Sentence();
            String originalText = fileSentenceIterator.next();
            sentence.prepareSentence(originalText);
            if (originalText.matches("[\\s]+") ||
                    originalText.matches("") ||
                    originalText.matches("Mr. and \r\n" +
                            "Ms. Smith \r\n" +
                            "met Dr. Jekyll \r\n" +
                            "outside")) {
                continue;
            }
            xmlStreamWriter.addSentence(sentence);
        }
        xmlStreamWriter.closeDocument();
    }
}
