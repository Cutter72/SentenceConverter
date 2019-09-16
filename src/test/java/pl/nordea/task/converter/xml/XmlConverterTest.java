package pl.nordea.task.converter.xml;

import org.junit.Test;

import java.io.File;

public class XmlConverterTest {

    @Test
    public void convert() {
    }

    @Test
    public void readOryginalSentenceFromFile() {
        //given
        File inputFile = new File("sample_data/small.in");
        File outputFile = new File("test_data/smallTest.xml");
        String expected = "";
        //when
        //then

    }

    @Test
    public void writeSentenceToFile() {
    }
}