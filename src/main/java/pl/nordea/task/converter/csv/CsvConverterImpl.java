package pl.nordea.task.converter.csv;

import pl.nordea.task.converter.ConverterInterface;
import pl.nordea.task.converter.FileSentenceIterator;
import pl.nordea.task.model.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CsvConverterImpl implements ConverterInterface {

    @Override
    public void convert(File inputFile, File outputFile) {
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(inputFile);
        CsvStreamWriterImpl csvStreamWriterImpl = null;

        try {
            csvStreamWriterImpl = new CsvStreamWriterImpl(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        csvStreamWriterImpl.startDocument(5);
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
            csvStreamWriterImpl.addSentence(sentence);
        }
    }
}
