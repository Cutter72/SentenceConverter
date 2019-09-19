package pl.nordea.task.converter;

import pl.nordea.task.model.Sentence;

import java.io.File;

public class WordCounter {
    public int findMaxNumberOfWordsInSentence(File inputFile) {
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(inputFile);
        int maxNumberOfWOrds = 0;
        while (fileSentenceIterator.hasNext()) {
            Sentence sentence = new Sentence();
            sentence.prepareSentenceForCsv(fileSentenceIterator.next());
            if (sentence.getWordsList().size() > maxNumberOfWOrds) {
                maxNumberOfWOrds = sentence.getWordsList().size();
            }
        }
        return maxNumberOfWOrds;
    }
}
