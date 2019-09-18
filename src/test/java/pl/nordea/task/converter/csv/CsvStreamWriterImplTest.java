package pl.nordea.task.converter.csv;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class CsvStreamWriterImplTest {

    @Test
    public void startDocument() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_CsvStreamWriter.startDocument").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_CsvStreamWriter.startDocument").toAbsolutePath();
        CsvStreamWriterImpl csvStreamWriter = null;
        try {
            csvStreamWriter = new CsvStreamWriterImpl(new FileOutputStream(outputFile.toFile()));
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
        csvStreamWriter.startDocument(5);
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
    }

}