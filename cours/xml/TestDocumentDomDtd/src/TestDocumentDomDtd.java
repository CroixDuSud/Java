// ==========================================================================
// APPLICATION TestDocumentDomDtd                                         XML
// --------------------------------------------------------------------------
// Lecture d'un fichier XML, utilisation d'un fichier DTD associe
// ==========================================================================

import java.io.*;                   // Pour File, IOException
import org.w3c.dom.*;               // Pour Document, Element, Node, NodeList
import javax.xml.parsers.*;         // Pour DocumentBuilder...
import org.xml.sax.*;               // Pour SAXException
// (generee par parse de DocumentBuilder)

public class TestDocumentDomDtd
{
    public static void main(String args[]) throws IOException,
                                                  ParserConfigurationException,
                                                  SAXException
    {
        DocumentBuilderFactory usineParseurXml;
        DocumentBuilder parseurXml;

        File fichierXml;

        Document documentDom;
        Element racine;
        NodeList enfants;
        Node enfant;

// --------------------------------------------------------------------------
// Creation de l'objet parseurXml.
// --------------------------------------------------------------------------
// setIgnoringComments(true) :
//    les commentaires ne sont pas pris en compte.
//
// setIgnoringElementContentWhitespace(true) :
//    les blancs ne sont pas pris en compte.
//
// setValidating(true) :
//   cette option demande au parseur de verifier le fichier XML au cours de
//   la conversion. Cette option doit etre activee dans le cas ou un fichier
//   de validation (par exemple DTD) est appele dans le fichier XML par une
//   balise : <!DOCTYPE ...>. En cas d'absence de cette balise, il y a erreur
//   a l'execution.
//
//   En cas d'erreur sur le parse du fichier XML, une SAXParseException,
//   erreur derivee de SAXException, se produit. Pour la traiter, il est
//   necessaire de creer une classe qui implemente l'interface ErrorHandler.
//   En cas d'erreur, c'est l'une des 3 methodes de cette classe qui est
//   appelee.
// --------------------------------------------------------------------------
        usineParseurXml = DocumentBuilderFactory.newInstance();
        usineParseurXml.setIgnoringComments(true);
        usineParseurXml.setIgnoringElementContentWhitespace(true);
        usineParseurXml.setValidating(true);

// --------------------------------------------------------------------------
// Creer le parseur et lui associer le gestionnaire d'erreur
// --------------------------------------------------------------------------
        parseurXml = usineParseurXml.newDocumentBuilder();
        parseurXml.setErrorHandler(new ErreurDtd());

// --------------------------------------------------------------------------
// Creation de l'objet File correspondant au fichier XML a convertir
// --------------------------------------------------------------------------
        fichierXml = new File("font.xml");

// --------------------------------------------------------------------------
// Conversion du fichier en objet Document
// --------------------------------------------------------------------------
        documentDom = parseurXml.parse(fichierXml);

// --------------------------------------------------------------------------
// Recuperation de l'element racine de l'arbre
// --------------------------------------------------------------------------
        racine = documentDom.getDocumentElement();

// --------------------------------------------------------------------------
// Affichage du nom de la racine de l'arbre, suivi de l'affichage du nom de
// ses enfants.
// --------------------------------------------------------------------------
        System.out.println("Racine et premier niveau de l'arbre DOM :\n");
        System.out.println(racine.getNodeName());

        enfants = racine.getChildNodes();

        for (int i = 0; i < enfants.getLength(); i++)
        {
            enfant = enfants.item(i);
            System.out.println("   " + enfant.getNodeName());
        }
    }
}
