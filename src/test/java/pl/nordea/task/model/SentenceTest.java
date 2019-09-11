package pl.nordea.task.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceTest {
    private final String oryginalSentence = "Mary had a little lamb .\n" +
            "    \n" +
            "    Peter called for the wolf , and Aesop came .\n" +
            "    Cinderella likes shoes...";
    private final String preparedSentence = "Mary had a little lamb   " +
            "     " +
            "    Peter called for the wolf   and Aesop came   " +
            "    Cinderella likes shoes   ";

    @Test
    public void prepareSentenceToSplitt() {
        //given

        //when
        Sentence sentence = new Sentence(oryginalSentence);
        String result = sentence.prepareSentenceToSplitt();
        //then
        assertEquals(preparedSentence, result);
    }
    @Test
    public void splittSentenceIntoWords() {
        //given
        List<String> expected = new ArrayList<>();
        expected.add("");
        //when

        //then

    }

}