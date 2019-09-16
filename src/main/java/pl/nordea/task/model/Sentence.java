package pl.nordea.task.model;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Sentence {
    private String originalText;
    private List<String> wordList;

    public Sentence() {
        this.originalText = null;
        this.wordList = null;
    }

    public Sentence(String originalText) {
        this.originalText = originalText;
        this.wordList = null;
    }

    public String getoriginalText() {
        return originalText;
    }

    public void setoriginalText(String originalText) {
        this.originalText = originalText;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public String prepareSentenceToSplit(String originalText) {
        return originalText.replaceAll("[.!?,:;\"\\n]"," ");
    }

    public List<String> splitSentenceIntoWords(String preparedSentenceText) {
        String[] words = preparedSentenceText.split("[ ]+");
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(words));
        while (wordList.contains("")) {
            wordList.remove("");
        }
        return wordList;
    }

    public List<String> sortWordList(List<String> wordList) {
        wordList.sort(Collator.getInstance(Locale.ENGLISH));
        return wordList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        if (!originalText.equals(sentence.originalText)) return false;
        return wordList.equals(sentence.wordList);
    }

    @Override
    public int hashCode() {
        int result = originalText.hashCode();
        result = 31 * result + wordList.hashCode();
        return result;
    }
}
