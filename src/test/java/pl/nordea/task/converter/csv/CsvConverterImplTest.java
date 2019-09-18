package pl.nordea.task.converter.csv;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class CsvConverterImplTest {

    @Test
    public void convert() {
        //given
        CsvConverterImpl csvConverterImpl = new CsvConverterImpl();
        Path inputFile = Paths.get("src/main/resources/sample_data/small.in").toAbsolutePath();
        Path outputFile = Paths.get("src/main/resources/test_data/small.csv").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/sample_data/small.csv").toAbsolutePath();
        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when
        csvConverterImpl.convert(inputFile.toFile(), outputFile.toFile());
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