// ==========================================================================
// APPLICATION TestDocumentDom                                            XML
// --------------------------------------------------------------------------
// Lecture d'un fichier XML.
// ==========================================================================

import java.io.*;                   // Pour File, IOException
import org.w3c.dom.*;               // Pour Document, Element, Node, NodeList
import javax.xml.parsers.*;         // Pour DocumentBuilder...
import org.xml.sax.*;               // Pour SAXException
                                    // (generee par parse de DocumentBuilder)

public class TestDocumentDom
{
    public static void main(String args[]) throws IOException,
                                                  ParserConfigurationException,
                                                  SAXException
    {

// --------------------------------------------------------------------------
// DocumentBuilderFactory est une classe permettant d'obtenir un parser
// (analyseur syntaxique) permettant de generer un objet Document a partir
// d'un fichier XML.
// DocumentBuilder est un parser (analyseur syntaxique).
// --------------------------------------------------------------------------
// Ces deux classes sont abstraites. Dans le programme, on affiche le nom
// des classes derivees qui leur correspondent.
// --------------------------------------------------------------------------
        DocumentBuilderFactory usineParseurXml;
        DocumentBuilder parseurXml;

// --------------------------------------------------------------------------
// Fichier XML a convertir
// --------------------------------------------------------------------------
        File fichierXml;

// --------------------------------------------------------------------------
// Node est une interface dont derivent toutes les interfaces representant un
// noeud de l'arbre DOM.
// --------------------------------------------------------------------------
// Document est une interface derivee de Node qui represente l'ensemble de
// l'arbre DOM. C'est en fait la racine de l'arbre, qui permet d'acceder a
// tous les autres noeuds.
//
// Element est une interface derivee de Node.
// --------------------------------------------------------------------------
// NodeList est une collection de noeuds (Node).
// --------------------------------------------------------------------------
        Document documentDom;
        Element racine;
        NodeList enfants;
        Node enfant;

// --------------------------------------------------------------------------
// Creation de l'objet parseurXml.
// --------------------------------------------------------------------------
// La methode setIgnoringComments permet d'indiquer que le parseur ne tiendra
// pas compte des commentaires presents dans le fichier XML. Il existe aussi
// une methode setIgnoringElementContentWhitespace, mais elle ne produit
// aucun effet ici...
// --------------------------------------------------------------------------
        usineParseurXml = DocumentBuilderFactory.newInstance();
        usineParseurXml.setIgnoringComments(true);
        parseurXml = usineParseurXml.newDocumentBuilder();

// --------------------------------------------------------------------------
// Affichage des noms des classes derivees des classes abstraites
// DocumentBuilderFactory et DocumentBuilder
// --------------------------------------------------------------------------
        System.out.println("usineParseurXml : "
            + usineParseurXml.getClass().getName());
        System.out.println("parseurXml      : "
            + parseurXml.getClass().getName());

// --------------------------------------------------------------------------
// Creation de l'objet File correspondant au fichier XML a convertir
// --------------------------------------------------------------------------
        fichierXml = new File("font.xml");

// --------------------------------------------------------------------------
// Conversion du fichier en objet Document
// --------------------------------------------------------------------------
// Affichage du nom de la classe (derivee de Document) correspondant au
// document DOM obtenu
// --------------------------------------------------------------------------
        documentDom = parseurXml.parse(fichierXml);
        System.out.println("documentDom     : "
            + documentDom.getClass().getName() + "\n");

// --------------------------------------------------------------------------
// Recuperation de l'element racine de l'arbre et affichage de son type
// --------------------------------------------------------------------------
        racine = documentDom.getDocumentElement();
        System.out.println("racine          : "
            + racine.getClass().getName() + "\n\n");

// --------------------------------------------------------------------------
// Affichage du nom de la racine de l'arbre, suivi de l'affichage du nom de
// ses enfants.
// --------------------------------------------------------------------------
// Remarque : quand le noeud est une feuille, la methode getNodeName()
// renvoie son type.
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
