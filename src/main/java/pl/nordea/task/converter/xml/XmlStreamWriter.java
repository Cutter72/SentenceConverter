package pl.nordea.task.converter.xml;

import java.io.FileOutputStream;

public class XmlStreamWriter {
    private FileOutputStream fileOutputStream;

    public XmlStreamWriter(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public void startDocument() {
    }

    public void closeDocument() {

    }
}
