package pl.nordea.task.converter.xml;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class XmlConverterTest {

    @Test
    public void convert() {
        //given
        XmlConverter xmlConverter = new XmlConverter();
        Path inputFile = Paths.get("src/main/resources/sample_data/small.in").toAbsolutePath();
        Path outputFile = Paths.get("src/main/resources/test_data/small.xml").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/sample_data/small.xml").toAbsolutePath();
        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when
        xmlConverter.convert(inputFile.toFile(), outputFile.toFile());
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