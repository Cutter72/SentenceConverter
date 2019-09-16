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

        Sentence sentence = new Sentence();
        List<String> wordList = new ArrayList<>();
        wordList.add("Love");
        wordList.add("is");
        wordList.add("everything");
        wordList.add("you");
        wordList.add("need");
        sentence.setWordList(wordList);

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
            xmlJaxbMarshal.addSentence(
                    sentence,
                    outputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        List<String> actual = Files.readAllLines(outputFile);
        //then
        assertEquals(expected, actual);


    }
}