package pl.nordea.task.converter;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ScanFileForSentenceTest {

    @Test
    public void hasNext() {
        //given
        ScanFileForSentence scanFileForSentence = new ScanFileForSentence(new File(Paths.get("src/main/resources/test_data/lackOfSentenceEndMark.test").toAbsolutePath().toString()));
        //when

        //then
        assertTrue(scanFileForSentence.hasNext());
        scanFileForSentence.next();
        assertTrue(scanFileForSentence.hasNext());
        scanFileForSentence.next();
        assertTrue(scanFileForSentence.hasNext());
        scanFileForSentence.next();
        assertTrue(scanFileForSentence.hasNext());
        scanFileForSentence.next();
        assertTrue(scanFileForSentence.hasNext());
        scanFileForSentence.next();
        assertFalse(scanFileForSentence.hasNext());
    }

    @Test
    public void next() {
        //given
        String expected = "Mr. and \r\n" +
                "Ms. Smith \r\n" +
                "met Dr. Jekyll \r\n" +
                "outside";
        ScanFileForSentence scanFileForSentence = new ScanFileForSentence(new File(Paths.get("src/main/resources/sample_data/small.in").toAbsolutePath().toString()));
        //when
        String actual = scanFileForSentence.next();
        //then
        assertEquals(expected, actual);
    }
}