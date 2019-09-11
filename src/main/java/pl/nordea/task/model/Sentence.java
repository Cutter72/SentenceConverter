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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        if (!oryginalText.equals(sentence.oryginalText)) return false;
        return wordList.equals(sentence.wordList);
    }

    @Override
    public int hashCode() {
        int result = oryginalText.hashCode();
        result = 31 * result + wordList.hashCode();
        return result;
    }
}
