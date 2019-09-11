package pl.nordea.task.converter.xml;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class XmlConverterTest {

    @Test
    public void convert() {
    }

    @Test
    public void readOryginalSentenceFromFile() {
        //given
        File inputFile = new File("sample_data/small.in");
        File outputFile = new File("sample_test/smallTest.xml");
        String expected = "";
        //when
        //then

    }

    @Test
    public void writeSentenceToFile() {
    }
}