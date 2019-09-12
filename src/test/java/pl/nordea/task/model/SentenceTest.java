package pl.nordea.task.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceTest {
    private final String givenSentenceA = "Mary had a little lamb .\n";
    private final String givenSentenceB = "    \n Peter called for the wolf , and Aesop came .\n";
    private final String givenSentenceC = "    Cinderella likes shoes...";
    private final String expectedSentenceA = "Mary had a little lamb   ";
    private final String expectedSentenceB = "      Peter called for the wolf   and Aesop came   ";
    private final String expectedSentenceC = "    Cinderella likes shoes   ";

    @Test
    public void prepareSentenceToSplitt() {
        //given

        //when
        Sentence sentenceA = new Sentence(givenSentenceA);
        Sentence sentenceB = new Sentence(givenSentenceB);
        Sentence sentenceC = new Sentence(givenSentenceC);
        String actualA = sentenceA.prepareSentenceToSplitt();
        String actualB = sentenceB.prepareSentenceToSplitt();
        String actualC = sentenceC.prepareSentenceToSplitt();
        //then
        assertEquals(expectedSentenceA, actualA);
        assertEquals(expectedSentenceB, actualB);
        assertEquals(expectedSentenceC, actualC);
    }
    @Test
    public void splittSentenceIntoWords() {
        //given
        List<String> expectedA = new ArrayList<>();
        expectedA.add("a");
        expectedA.add("had");
        expectedA.add("lamb");
        expectedA.add("little");
        expectedA.add("Mary");
        //when

        //then

    }

}