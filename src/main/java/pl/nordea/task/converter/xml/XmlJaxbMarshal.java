package pl.nordea.task.converter.xml;

import pl.nordea.task.model.Sentence;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

public class XmlJaxbMarshal {
    private JAXBContext jaxbContext;
    private Marshaller marshaller;

    public XmlJaxbMarshal() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(Sentence.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    public void addSentence(Sentence sentence, FileOutputStream fileOutputStream) throws JAXBException {
        marshaller.marshal(sentence, fileOutputStream);
    }
}
