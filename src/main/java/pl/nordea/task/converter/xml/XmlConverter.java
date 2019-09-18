package pl.nordea.task.converter.xml;

import pl.nordea.task.converter.FileSentenceIterator;
import pl.nordea.task.model.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class XmlConverter {

    void convert(File inputFile, File outputFile) {
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(inputFile);
        XmlStreamWriterImpl xmlStreamWriterImpl = null;

        try {
            xmlStreamWriterImpl = new XmlStreamWriterImpl(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        xmlStreamWriterImpl.startDocument();
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
            xmlStreamWriterImpl.addSentence(sentence);
        }
        xmlStreamWriterImpl.closeDocument();
    }
}
