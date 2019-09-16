package pl.nordea.task.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceTest {

    @Test
    public void prepareSentenceToSplit() {
        //given
        String expectedSentenceTextA = "Mary had a little lamb   ";
        String expectedSentenceTextB = "      Peter called for the wolf   and Aesop came   ";
        String expectedSentenceTextC = "    Cinderella likes shoes   ";
        String expectedSentenceTextD = "in In in ";

        String givenSentenceTextA = "Mary had a little lamb .\n";
        String givenSentenceTextB = "    \n Peter called for the wolf , and Aesop came .\n";
        String givenSentenceTextC = "    Cinderella likes shoes...";
        String givenSentenceTextD = "in In in.";
        //when
        Sentence sentenceA = new Sentence(givenSentenceTextA);
        Sentence sentenceB = new Sentence(givenSentenceTextB);
        Sentence sentenceC = new Sentence(givenSentenceTextC);
        Sentence sentenceD = new Sentence(givenSentenceTextD);
        String actualA = sentenceA.prepareSentenceToSplit(sentenceA.getoriginalText());
        String actualB = sentenceB.prepareSentenceToSplit(sentenceB.getoriginalText());
        String actualC = sentenceC.prepareSentenceToSplit(sentenceC.getoriginalText());
        String actualD = sentenceD.prepareSentenceToSplit(sentenceD.getoriginalText());
        //then
        assertEquals(expectedSentenceTextA, actualA);
        assertEquals(expectedSentenceTextB, actualB);
        assertEquals(expectedSentenceTextC, actualC);
        assertEquals(expectedSentenceTextD, actualD);
    }

    @Test
    public void splitSentenceIntoWords() {
        //given
        List<String> expectedA = new ArrayList<>();
        expectedA.add("a");
        expectedA.add("had");
        expectedA.add("lamb");
        expectedA.add("little");
        expectedA.add("Mary");
        List<String> expectedB = new ArrayList<>();
        expectedB.add("Aesop");
        expectedB.add("and");
        expectedB.add("called");
        expectedB.add("came");
        expectedB.add("for");
        expectedB.add("Peter");
        expectedB.add("the");
        expectedB.add("wolf");
        List<String> expectedC = new ArrayList<>();
        expectedC.add("Cinderella");
        expectedC.add("likes");
        expectedC.add("shoes");
        List<String> expectedD = new ArrayList<>();
        expectedD.add("in");
        expectedD.add("in");
        expectedD.add("In");
        String preparedSentenceTextA = "Mary had a little lamb   ";
        String preparedSentenceTextB = "      Peter called for the wolf   and Aesop came   ";
        String preparedSentenceTextC = "    Cinderella likes shoes   ";
        String preparedSentenceTextD = "in In in ";
        //when
        Sentence sentenceA = new Sentence();
        Sentence sentenceB = new Sentence();
        Sentence sentenceC = new Sentence();
        Sentence sentenceD = new Sentence();
        List<String> actualA = sentenceA.splitSentenceIntoWords(preparedSentenceTextA);
        List<String> actualB = sentenceB.splitSentenceIntoWords(preparedSentenceTextB);
        List<String> actualC = sentenceC.splitSentenceIntoWords(preparedSentenceTextC);
        List<String> actualD = sentenceD.splitSentenceIntoWords(preparedSentenceTextD);

        //then
        assertEquals(expectedA, actualA);
        assertEquals(expectedB, actualB);
        assertEquals(expectedC, actualC);
        assertEquals(expectedD, actualD);


    }

}