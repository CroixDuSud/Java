package objetDistant;

import java.util.Vector;
import javax.ejb.Remote;
import tables.*;
import utilitairesMG.divers.Colonne;

@Remote
public interface MappingEntiteRemote
{
    public Contact lireContact(Integer numero);
    public Vector<Contact> lireListeContacts();
    public Vector<Contact> lireListeContactsParNom(String extraitNom);
    public int creerContact(Contact contact);
    public int modifierContact(Contact contact);
    public int detruireContact(Contact contact);
    public Vector<Versement> lireListeVersementsContact(Contact contact);
    public Vector<Colonne> lireListeColonnes(String nomTable);

    public Secteur lireSecteur(Integer numero);
    public Vector<Secteur> lireListeSecteurs();
}
