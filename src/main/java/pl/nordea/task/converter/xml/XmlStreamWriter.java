package pl.nordea.task.converter.xml;

import java.io.FileOutputStream;
import java.io.IOException;

public class XmlStreamWriter {
    private FileOutputStream fileOutputStream;

    public XmlStreamWriter(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public void startDocument() {
        try {
            fileOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<oryginalText>".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeDocument() {

    }
}
