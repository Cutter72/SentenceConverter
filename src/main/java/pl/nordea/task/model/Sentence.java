package pl.nordea.task.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@XmlRootElement
public class Sentence {
    private String originalText;
    @XmlElement(name = "word")
    private List<String> wordList;

    public Sentence() {
        this.originalText = null;
        this.wordList = null;
    }

    public Sentence(String originalText) {
        this.originalText = originalText;
        this.wordList = null;
    }

    public void prepareSentence(String originalText) {
        this.originalText = originalText;
        this.wordList = sortWordList(splitSentenceIntoWords(prepareSentenceToSplit(originalText)));
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    String getOriginalText() {
        return originalText;
    }

    String prepareSentenceToSplit(String originalText) {
        String preparingTextStepA = originalText.replaceAll("(?<!Mr|Ms|Dr)[.]+", " ");
        String preparingTextStepB = preparingTextStepA.replaceAll("[!?,:;\\-\\s()]+", " ");
        return preparingTextStepB.replaceAll("['’]+", "&apos;");
    }

    List<String> splitSentenceIntoWords(String preparedSentenceText) {
        String[] words = preparedSentenceText.split("[ ]+");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        while (wordList.contains("") || wordList.contains(" ")) {
            wordList.remove("");
            wordList.remove(" ");
        }
        return wordList;
    }

    List<String> sortWordList(List<String> wordList) {
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
