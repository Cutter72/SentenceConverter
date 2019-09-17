package pl.nordea.task.converter.xml;

import org.junit.Test;
import pl.nordea.task.model.Sentence;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlStreamWriterTest {

    @Test
    public void startDocument() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_XmlStreamWriter.startDocument").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_XmlStreamWriter.startDocument").toAbsolutePath();
        XmlStreamWriter xmlStreamWriter = null;
        try {
            xmlStreamWriter = new XmlStreamWriter(new FileOutputStream(outputFile.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when
        xmlStreamWriter.startDocument();
        List<String> actual = null;
        try {
            actual = Files.readAllLines(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void addSentence() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_XmlStreamWriter.addSentence").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_XmlStreamWriter.addSentence").toAbsolutePath();
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(outputFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        XmlStreamWriter xmlStreamWriter;
        xmlStreamWriter = new XmlStreamWriter(outputStream);

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


        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when

        xmlStreamWriter.addSentence(sentenceA, outputStream);
        xmlStreamWriter.addSentence(sentenceB, outputStream);
        List<String> actual = null;
        try {
            actual = Files.readAllLines(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void closeDocument() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_XmlStreamWriter.closeDocument").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_XmlStreamWriter.closeDocument").toAbsolutePath();
        XmlStreamWriter xmlStreamWriter = null;
        try {
            xmlStreamWriter = new XmlStreamWriter(new FileOutputStream(outputFile.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when
        xmlStreamWriter.closeDocument();
        List<String> actual = null;
        try {
            actual = Files.readAllLines(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(expected, actual);
    }
}