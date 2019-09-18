package pl.nordea.task.converter.csv;

import pl.nordea.task.converter.StreamWriterInterface;
import pl.nordea.task.model.Sentence;

import java.io.FileOutputStream;

public class CsvStreamWriterImpl implements StreamWriterInterface {
    private FileOutputStream fileOutputStream;

    public CsvStreamWriterImpl(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public void startDocument() {

    }

    public void addSentence(Sentence sentence) {

    }

    public void closeDocument() {

    }

}
