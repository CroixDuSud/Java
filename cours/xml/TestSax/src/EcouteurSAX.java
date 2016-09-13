
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// ==========================================================================
// Classe EcouteurSAX : redefinition des methodes startElement et characters
// de la classe DefaultHandler. Cette classe implemente (entre autres) 
// l'interface ContentHandler qui contient les methodes appelees lors de 
// l'apparition d'un evenement de lecture du fichier XML. La methode 
// startElement est appelee lors de la lecture d'une balise ouvrante (de 
// debut). La methode characters lors de la lecture d'une feuille (PCDATA).
// ==========================================================================
public class EcouteurSAX extends DefaultHandler
{
    public void startElement(String namespaceURI,
        String lname,
        String qname,
        Attributes attrs) throws SAXException
    {
        System.out.println(qname);
    }

// --------------------------------------------------------------------------
// Dans la methode characters, la DTD est prise en compte par defaut. Les
// blancs et les autres caracteres de presentation ne provoquent pas 
// d'evenement...
// --------------------------------------------------------------------------
    public void characters(char[] ch, int start, int length)
    {
        String texte;

        texte = new String(ch, start, length);

        System.out.println("   " + texte);
    }
}
