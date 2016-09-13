// ==========================================================================
// APPLICATION TestSax                                                    XML
// --------------------------------------------------------------------------
// Utilisation d'un analyseur SAX.
// ==========================================================================

import java.io.*;                   // Pour File, IOException
import javax.xml.parsers.*;         // Pour DocumentBuilder...
import org.xml.sax.*;               // Pour Attributes

public class TestSax
{
    public static void main(String args[]) throws ParserConfigurationException,
                                                  SAXException,
                                                  IOException
    {

// --------------------------------------------------------------------------
// SAXParserFactory est une classe permettant d'obtenir un parser (analyseur 
// syntaxique) permettant d'analyser un fichier (ou un flux) XML.
// SAXParser est un parser (analyseur syntaxique).
// EcouteurSAX est la classe qui permet la gestion des evenements de lecture
// du flux XML.
// --------------------------------------------------------------------------
        SAXParserFactory usineParseurXml;
        SAXParser parseurXml;
        EcouteurSAX ecouteur;

// --------------------------------------------------------------------------
// Fichier XML a analyser
// --------------------------------------------------------------------------
        File fichierXml;

        fichierXml = new File("font.xml");

// --------------------------------------------------------------------------
// Analyse du document SAX
// --------------------------------------------------------------------------
        usineParseurXml = SAXParserFactory.newInstance();
        parseurXml = usineParseurXml.newSAXParser();
        ecouteur = new EcouteurSAX();

        parseurXml.parse(fichierXml, ecouteur);
    }
}