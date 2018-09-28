package logic;


import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class prueba {
    public static void main(String[] args) throws IOException, DocumentException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource("src/sample.xsl"));
        transformer.transform(new StreamSource("src/quiz.xml"),new StreamResult(new FileOutputStream("src/sample.html")));
        String File_To_Convert = "src/sample.html";
        String url = new File(File_To_Convert).toURI().toURL().toString();
        System.out.println(""+url);
        String HTML_TO_PDF = "src/ConvertedFile.pdf";
        OutputStream os = new FileOutputStream(HTML_TO_PDF);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);
        os.close();
    }
}
