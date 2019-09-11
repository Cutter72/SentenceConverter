package pl.nordea.task.model;

import java.util.List;

public class Sentence {
    private final String oryginalText;
    private final List<String> wordList;

    public Sentence(String oryginalText) {
        this.oryginalText = oryginalText;
        this.wordList = splittSentenceIntoWords(oryginalText);
    }

    public List<String> splittSentenceIntoWords(String oryginalText) {
        return null;
    }

    public String prepareSentenceToSplitt(String oryginalText) {
        return null;
    }
}
