package pl.nordea.task.converter.xml;

import org.junit.Test;
import pl.nordea.task.model.Sentence;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlJaxbMarshalTest {

    @Test
    public void addSentence() throws IOException {
        //given
        XmlJaxbMarshal xmlJaxbMarshal;
        try {
            xmlJaxbMarshal = new XmlJaxbMarshal();
        } catch (JAXBException e) {
            e.printStackTrace();
            return;
        }

        Sentence sentenceA = new Sentence();
        List<String> wordListA = new ArrayList<>();
        wordListA.add("Love");
        wordListA.add("is");
        wordListA.add("everything");
        wordListA.add("you");
        wordListA.add("need");
        sentenceA.setWordList(wordListA);

        Sentence sentenceB = new Sentence();
        List<String> wordListB = new ArrayList<>();
        wordListB.add("Be");
        wordListB.add("yourself");
        sentenceB.setWordList(wordListB);

        Path outputFile = Paths.get("src/main/resources/test_data/sentenceXmlWriteTest").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expectedSentenceXmlWriteTest").toAbsolutePath();
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(outputFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        List<String> expected = Files.readAllLines(expectedFile);
        //when
        try {
            xmlJaxbMarshal.addSentence(sentenceA, outputStream);
            xmlJaxbMarshal.addSentence(sentenceB, outputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        List<String> actual = Files.readAllLines(outputFile);
        //then
        assertEquals(expected, actual);
    }
}