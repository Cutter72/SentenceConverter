package pl.nordea.task.converter.csv;

import pl.nordea.task.converter.StreamWriterInterface;
import pl.nordea.task.model.Sentence;

import java.io.FileOutputStream;

public class CsvStreamWriterImpl implements StreamWriterInterface {
    private FileOutputStream fileOutputStream;

    public CsvStreamWriterImpl(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void startDocument() {

    }

    @Override
    public void addSentence(Sentence sentence) {

    }

    @Override
    public void closeDocument() {

    }

}
