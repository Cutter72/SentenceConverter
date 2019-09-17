package pl.nordea.task.converter.xml;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlStreamWriterTest {

    @Test
    public void startDocument() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/startDocumentXmlStreamWriterTest").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expectedStartDocumentXmlStreamWriterTest").toAbsolutePath();
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
    public void closeDocument() {
    }
}