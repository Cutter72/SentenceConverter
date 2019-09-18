package pl.nordea.task.converter;

import pl.nordea.task.model.Sentence;

public interface StreamWriterInterface {
    void startDocument();
    void addSentence(Sentence sentence);
    void closeDocument();
}
