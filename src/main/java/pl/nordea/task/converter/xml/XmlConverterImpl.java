package pl.nordea.task.converter.xml;

import pl.nordea.task.converter.ConverterInterface;
import pl.nordea.task.converter.FileSentenceIterator;
import pl.nordea.task.model.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class XmlConverterImpl implements ConverterInterface {

    @Override
    public void convert(File inputFile, File outputFile) {
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
            if (Sentence.isValid(originalText)) {
                sentence.prepareSentence(originalText);
                xmlStreamWriterImpl.addSentence(sentence);
            }
        }
        xmlStreamWriterImpl.closeDocument();
    }
}
