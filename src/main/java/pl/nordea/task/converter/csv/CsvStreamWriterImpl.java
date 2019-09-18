package pl.nordea.task.converter.csv;

import pl.nordea.task.converter.StreamWriterInterface;
import pl.nordea.task.model.Sentence;

import java.io.FileOutputStream;
import java.io.IOException;

public class CsvStreamWriterImpl implements StreamWriterInterface {
    private FileOutputStream fileOutputStream;
    private int sentenceCount;

    CsvStreamWriterImpl(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
        this.sentenceCount = 0;
    }

    void startDocument(int wordCount) {
        for (int i = 1; i <= wordCount; i++) {
            try {
                fileOutputStream.write((", Word " + i).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addSentence(Sentence sentence) {
        this.sentenceCount++;
        try {
            fileOutputStream.write(("Sentence " + this.sentenceCount).getBytes());
            for (String word : sentence.getWordsList()) {
                fileOutputStream.write((", " + word).getBytes());
            }
            fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
