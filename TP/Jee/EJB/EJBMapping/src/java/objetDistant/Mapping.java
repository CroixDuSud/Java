package objetDistant;

import daoJdbcMapping.*;
import java.sql.*;
import java.util.Vector;
import javax.annotation.*;
import javax.ejb.Stateless;
import javax.naming.*;
import javax.sql.DataSource;
import metierMapping.*;
import utilitairesMG.divers.*;
import utilitairesMG.jdbc.*;

@Stateless
public class Mapping implements MappingRemote
{
    private BaseDeDonnees base;
    private DataSource ds;

// ----------------------------------------------------------------------------
// Chargement de l'EJB : ouverture de la connexion a la base
// ----------------------------------------------------------------------------
    @PostConstruct
    public void ouvreBase()
    {
        base = new BaseDeDonnees();

        try
        {
            Context ctx = new InitialContext();
            ctx.addToEnvironment("org.omg.CORBA.ORBInitialHost", "localhost");
            ctx.addToEnvironment("org.omg.CORBA.ORBInitialPort", "3700");
            ds = (DataSource)ctx.lookup("jndiPoolGnmi");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

// ----------------------------------------------------------------------------
// Chercher un contact (lire) : retourne le contact "numero" ou une SQLException
// ----------------------------------------------------------------------------
   public Contact lireContact(Integer numero) throws SQLException
   {
      Contact contact = new Contact();
      ContactDAO contactDAO;
      contact.setNumero(numero);

      base.setConnection(ds.getConnection());
      contactDAO = new ContactDAO(base);

      try
      {
         contactDAO.lire(contact);
      }
      finally
      {
         base.closeConnection();
      }
      return contact;
   }

// ----------------------------------------------------------------------------
// Liste de tous les contacts ou SQLException
// ----------------------------------------------------------------------------
// Le Vector<Vector> retourne contient deux Vector :
// . le premier (poste 0) contient le Vector<Contact> de tous les contacts
// . le deuxieme (poste 1) contient le Vector<Colonne> des colonnes de la table
//   des contacts.
// ----------------------------------------------------------------------------
   public Vector<Vector> lireListeContacts() throws SQLException
   {
      Vector<Vector> resultat;
      Vector<Contact> listeContacts;
      Vector<Colonne> listeColonnes;
      ContactDAO contactDAO;

      base.setConnection(ds.getConnection());
      contactDAO = new ContactDAO(base);

      try
      {
         listeContacts = contactDAO.lireListe();
         listeColonnes = contactDAO.getListeColonnes();

         resultat = new Vector<Vector>();
         resultat.addElement(listeContacts);
         resultat.addElement(listeColonnes);
      }
      finally
      {
         base.closeConnection();
      }

      return resultat;
    }

// ----------------------------------------------------------------------------
// Modification d'un contact.
// ----------------------------------------------------------------------------
// Retourne 1 si la modification est reussie, 0 si incident (le contact
// n'existe pas) ou une SQLException...
// ----------------------------------------------------------------------------
   public int modifierContact(Contact contact) throws SQLException
   {
      int retour;
      ContactDAO contactDAO;

      base.setConnection(ds.getConnection());
      contactDAO = new ContactDAO(base);

      try
      {
         retour = contactDAO.modifier(contact);
      }
      finally
      {
         base.closeConnection();
      }

      return retour;
   }

// ----------------------------------------------------------------------------
// Liste de tous les secteurs ou SQLException
// ----------------------------------------------------------------------------
// Le Vector<Vector> retourne contient deux Vector :
// . le premier (poste 0) contient le Vector<Secteur> de tous les secteurs
// . le deuxieme (poste 1) contient le Vector<Colonne> des colonnes de la table
//   des secteurs.
// ----------------------------------------------------------------------------
   public Vector<Vector> lireListeSecteurs() throws SQLException
   {
      Vector<Vector> resultat;
      Vector<Secteur> listeSecteurs;
      Vector<Colonne> listeColonnes;
      SecteurDAO secteurDAO;

      base.setConnection(ds.getConnection());
      secteurDAO = new SecteurDAO(base);

      try
      {
        listeSecteurs = secteurDAO.lireListe();
        listeColonnes = secteurDAO.getListeColonnes();

        resultat = new Vector<Vector>();
        resultat.addElement(listeSecteurs);
        resultat.addElement(listeColonnes);
      }
      finally
      {
         base.closeConnection();
      }

      return resultat;
   }
}
