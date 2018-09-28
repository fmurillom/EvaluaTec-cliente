package logic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Clase encargada de Realizar la conversion de una clase a formato xml
 */
public class XMLizer {

    /**
     * Metodo para conversion de XML a Curso
     * @param name nombre del archivo
     * @param tag llave principal del xml nuevo
     * @return
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static List<Curso> getXMLCursos(String name, String tag) throws IOException, SAXException, ParserConfigurationException {
        List<Curso> cursos = new LinkedList<>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(name + ".xml"));
        doc.getDocumentElement().normalize();


        NodeList nList = doc.getChildNodes().item(0).getChildNodes();

        for(int i = 0; i < nList.getLength(); i++){
            Node nNode = nList.item(i);
            if(nNode.getNodeName().equals(tag)){
                Curso curso = new Curso();
                Element eElement = (Element)nNode;
                String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String codigo = eElement.getElementsByTagName("Codigo").item(0).getTextContent();
                List<Element> temasAux = findAllElementsByTagName(eElement, "Tema");
                List<String> temas = new LinkedList<>();
                for(Element elemnt : temasAux){
                    temas.add(elemnt.getFirstChild().getTextContent());
                }
                curso.setNombre(nombre);
                curso.setCodigo(codigo);
                curso.setTemas(temas);
                cursos.add(curso);
            }
        }
        return cursos;
    }

    /**
     * Metodo para conversion de XML a Universidad
     * @param name Nombre del archivo a leer
     * @param tag Llave principal del archivo
     * @return
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static List<Universidad> getXmlUni(String name, String tag) throws IOException, SAXException, ParserConfigurationException {
        List<Universidad> listUni = new LinkedList<>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(name + ".xml"));
        doc.getDocumentElement().normalize();


        NodeList nList = doc.getChildNodes().item(0).getChildNodes();

        for(int i = 0; i < nList.getLength(); i++){
            Node nNode = nList.item(i);
            if(nNode.getNodeName().equals(tag)){
                Universidad uniAux = new Universidad();
                Element eElement = (Element)nNode;

                String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                List<Element> escuelas = findAllElementsByTagName(eElement, "Escuela");
                List<Element> areasA = findAllElementsByTagName(eElement, "AreaA");
                List<Element> cursos = findAllElementsByTagName(eElement, "Curso");
                List<String> escAux = new LinkedList<>();
                List<String> arAux = new LinkedList<>();
                List<String> curAuxL = new LinkedList<>();

                for(Element elaux : escuelas){
                    escAux.add(elaux.getFirstChild().getTextContent());
                }

                for(Element areAux : areasA){
                    arAux.add(areAux.getFirstChild().getTextContent());
                }

                for(Element curAux : cursos){
                    curAuxL.add(curAux.getFirstChild().getTextContent());
                }

                uniAux.setNombre(nombre);
                uniAux.setAreasA(arAux);
                uniAux.setCursos(curAuxL);
                uniAux.setEscuelas(escAux);
                listUni.add(uniAux);
            }
        }
        return listUni;
    }

    /**
     * Metodo encargado de buscar todos los elementos que posean un mismo Tag en el xml
     * @param elem Elemento que contiene los tags
     * @param tagName nombre del tag a obtener
     * @return
     */
    public static List<Element> findAllElementsByTagName(Element elem, String tagName) {
        List<Element> ret = new LinkedList<Element>();
        findAllElementsByTagName(elem, tagName, ret);
        return ret;
    }

    private static void findAllElementsByTagName(Element el, String tagName, List<Element> elementList) {

        if (tagName.equals(el.getTagName())) {
            elementList.add(el);
        }
        Element elem = getFirstElement(el);
        while (elem != null) {
            findAllElementsByTagName(elem, tagName, elementList);
            elem = getNextElement(elem);
        }
    }

    private static void findAllElementsByTagNameNS(Element el, String nameSpaceURI, String localName,
                                                   List<Element> elementList) {

        if (localName.equals(el.getLocalName()) && nameSpaceURI.contains(el.getNamespaceURI())) {
            elementList.add(el);
        }
        Element elem = getFirstElement(el);
        while (elem != null) {
            findAllElementsByTagNameNS(elem, nameSpaceURI, localName, elementList);
            elem = getNextElement(elem);
        }
    }

    /**
     * Obtiene el primer elemento de un tag
     * @param parent nodo en el que se encuentran los tags
     * @return
     */
    public static Element getFirstElement(Node parent) {
        Node n = parent.getFirstChild();
        while (n != null && Node.ELEMENT_NODE != n.getNodeType()) {
            n = n.getNextSibling();
        }
        if (n == null) {
            return null;
        }
        return (Element) n;
    }

    public static Element getNextElement(Element el) {
        Node nd = el.getNextSibling();
        while (nd != null) {
            if (nd.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) nd;
            }
            nd = nd.getNextSibling();
        }
        return null;
    }


    /**
     * Serializa la clase Pregunta a un xml
     * @param preg la pregunta a serializar
     * @throws JAXBException
     */
    public static void marshallPregunta(Pregunta preg) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Pregunta.class);
        Marshaller ms = jc.createMarshaller();
        ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ms.marshal(preg, System.out);
        ms.marshal(preg, new File("../GenPreg.xml"));
        java.io.OutputStream ans = new ByteArrayOutputStream(4090);
        ms.marshal(preg, ans);
        String anstring = ans.toString();
        Globals.pushQ(anstring);
        //System.out.println("This is ans:" + anstring);
    }


    /**
     * Serializa la clase marqueX a un xml
     * @param preg la pregunta a serializar
     * @throws JAXBException
     */
    public static void marshallPreguntaX(MargueX preg) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(MargueX.class);
        Marshaller ms = jc.createMarshaller();
        ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ms.marshal(preg, System.out);
        ms.marshal(preg, new File("GenPreg.xml"));
        java.io.OutputStream ans = new ByteArrayOutputStream(4090);
        ms.marshal(preg, ans);
        String anstring = ans.toString();
        Globals.pushQ(anstring);
        //System.out.println("This is ans:" + anstring);
    }

}
