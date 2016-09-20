
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author afpa1800
 */
public class TP_ArbreXml
{

    private static Fenetre fenetre;
    private static DocumentBuilder parseurXml;

    public static void main(String[] args) throws ParserConfigurationException
    {

        DocumentBuilderFactory usineParseurXml;

        usineParseurXml = DocumentBuilderFactory.newInstance();
        usineParseurXml.setIgnoringComments(true);
        usineParseurXml.setIgnoringElementContentWhitespace(true);
        usineParseurXml.setValidating(true);

        parseurXml = usineParseurXml.newDocumentBuilder();
        parseurXml.setErrorHandler(new ErreurDtd());

        fenetre = new Fenetre("ArbreXml");

    }

    public static void litXml(File fichierXml)
    {
        Document documentDom;

        try
        {
            documentDom = parseurXml.parse(fichierXml);
            fenetre.afficheArbre(documentDom);

        } catch (SAXException e)
        {
            fenetre.afficheMessage(e.getMessage());
        } catch (IOException e)
        {
            fenetre.afficheMessage(e.getMessage());
        }
    }

    public static void arreter()
    {
        System.exit(0);
    }

}
