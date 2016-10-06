package objetDistant;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.*;
import tables.*;
import utilitairesMG.divers.Colonne;
import javax.validation.constraints.Size;

/**
 *
 * @author 89EZ022
 */
@Stateless
public class MappingEntite implements MappingEntiteRemote
{
    @PersistenceContext
    private EntityManager em;

// ----------------------------------------------------------------------------
// Chercher un contact (lire) : retourne le contact "numero" ou null...
// ----------------------------------------------------------------------------
    public Contact lireContact(Integer numero)
    {

// ----------------------------------------------------------------------------
// Remarque : la difference entre find et getReference reste a preciser.
// Dans la documentation, pour getReference, il est question d'une entite dont
// l'etat peut etre cherche de façon "lazy"... ?
// ----------------------------------------------------------------------------
        Contact contact = em.find(Contact.class, numero);

// ----------------------------------------------------------------------------
// refresh() permet de relire la valeur dans la base. A defaut, la valeur de
// l'entite en memoire est conservee. On ne voit pas les modifs effectuees
// dans la base (par quelqu'un d'autre)...
// ----------------------------------------------------------------------------
// Attention : refresh() peut envoyer une EntityNotFoundException (si l'entite
// a disparu dans la base ! Dans ce cas, il semble que l'entite soit détachée.
// ----------------------------------------------------------------------------
/*        if (contact != null)
        {
            try
            {
                em.refresh(contact);
            }
            catch(EntityNotFoundException e)
            {
                contact = null;
            }
        } */
        return contact;
    }

// ----------------------------------------------------------------------------
// Creation d'un contact.
// ----------------------------------------------------------------------------
// Code retour :
//    0 : creation reussie
//    1 : le contact existe deja en entite ET dans la base
//    2 : le contact existe en entite mais PAS dans la base.
// ----------------------------------------------------------------------------
    public int creerContact(Contact contact)
    {
        int retour;

        Contact cont = em.find(Contact.class, contact.getNumero());

// ----------------------------------------------------------------------------
// Attention : persist() se plante en EntityExistsException si l'ENTITE existe
// deja. Si l'entite n'existe pas mais que le contact existe deja DANS LA BASE,
// c'est le INSERT (genere par persist) qui se plante avec erreur : clef en
// double)...
// ----------------------------------------------------------------------------
// Le test ci-dessous evite de faire un persist() sur un contact qui existe
// deja dans la base...
// ----------------------------------------------------------------------------
        if (cont == null)
        {
            em.persist(contact);
            retour = 0;
        }
        else
        {

// ----------------------------------------------------------------------------
// L'entite cont a ete trouvee. L'appel de refresh() permet de verifier qu'elle
// existe aussi dans la base. Il est en effet possible que l'entite existe bien
// que l'enregistrement ait ete detruit dans la base (par une autre
// application). Le code 2 indiquera que la creation a echoue a cause de la
// presence de l'entite malgre l'absence dans la table. Dans ce cas le refresh
// semble dereferencer l'entite. Il suffira de relancer creerContact pour
// effectuer la creation.
// ----------------------------------------------------------------------------
            try
            {
                em.refresh(cont);
                retour = 1;
            }
            catch(EntityNotFoundException e2)
            {
                retour = 2;
            }
        }
        return retour;
    }

// ----------------------------------------------------------------------------
// Modification d'un contact.
// ----------------------------------------------------------------------------
// Code retour :
//    0 : modification reussie
//    1 : le contact n'existe pas
//    2 : le contact existe en entite mais PAS dans la base.
// ----------------------------------------------------------------------------
    public int modifierContact(Contact contact)
    {
        int retour;

        Contact cont = em.find(Contact.class, contact.getNumero());

        if (cont != null)
        {

// ----------------------------------------------------------------------------
// L'entite contact a ete trouvee. L'appel de refresh() permet de verifier qu'elle
// existe aussi dans la base. Le code 2 indiquera que la modification a echoue
// parce que le contact n'est pas dans la base bien que l'entite soit presente.
// A l'appel suivant, a cause du refresh, le contact ne sera ni dans la base, ni
// en entite. On aura le code 1...
// ----------------------------------------------------------------------------
            try
            {
                em.refresh(cont);
                retour = 0;

// ----------------------------------------------------------------------------
// Les appels des methodes set... provoquent une modification dans la base, si
// toutefois la valeur de la propriete en memoire est MODIFIEE. Aucune action
// sinon...
// ----------------------------------------------------------------------------
                cont.setNom(contact.getNom());
                cont.setAdresse(contact.getAdresse());
                cont.setCodePostal(contact.getCodePostal());
                cont.setVille(contact.getVille());
                cont.setCodeSecteur(contact.getCodeSecteur());
            }
            catch(EntityNotFoundException e2)
            {
                retour = 2;
            }
        }
        else
        {
            retour = 1;
        }

        return retour;
    }

// ----------------------------------------------------------------------------
// Destruction d'un contact. Retourne 1 si la destruction est reussie, 0 sinon
// ----------------------------------------------------------------------------
// Code retour :
//    0 : destruction reussie
//    1 : le contact n'existe pas
// ----------------------------------------------------------------------------
// Remarque : Si le contact existe en entite et PAS dans la base, on renvoie le
// code 0. La destruction est de toutes façons effectuee...
// ----------------------------------------------------------------------------
    public int detruireContact(Contact contact)
    {
        int retour;
        Contact cont = em.find(Contact.class, contact.getNumero());

        if (cont != null)
        {
            em.remove(cont);
            retour = 0;
        }
        else
        {
            retour = 1;
        }
        return retour;
    }

// ----------------------------------------------------------------------------
// Liste de tous les contacts
// ----------------------------------------------------------------------------
    public Vector<Contact> lireListeContacts()
    {
        Vector<Contact> listeContacts;

        Query q = em.createNamedQuery("Contact.findAll");
        listeContacts = (Vector<Contact>)q.getResultList();

        return listeContacts;
    }

// ----------------------------------------------------------------------------
// Liste des contacts dont le nom contient extraitNom
// ----------------------------------------------------------------------------
    public Vector<Contact> lireListeContactsParNom(String extraitNom)
    {
        Vector<Contact> listeContacts;
        String requeteEJBQL;

        requeteEJBQL = "select c from Contact c where c.nom like '%" +
                       extraitNom + "%'";

        Query q = em.createQuery(requeteEJBQL);
        listeContacts = (Vector<Contact>)q.getResultList();
        return listeContacts;
    }

// ----------------------------------------------------------------------------
// Liste des versements du contact
// ----------------------------------------------------------------------------
    public Vector<Versement> lireListeVersementsContact(Contact contact)
    {
        Vector<Versement> listeVersementsContact = new Vector<Versement>();
        String requeteSQL;
        List listeLue;

        requeteSQL =
            "select * from VERSEMENT where VERSEMENT.NUMERO_CONTACT = " +
            contact.getNumero();

        Query q = em.createNativeQuery(requeteSQL, Versement.class);
        listeLue = q.getResultList();

        for (int i = 0; i < listeLue.size(); i++)
        {
            listeVersementsContact.addElement((Versement)listeLue.get(i));
        }

        return listeVersementsContact;
    }

// --------------------------------------------------------------------------
// Cette methode permet de lire les caractéristiques des colonnes de la table
// correspondant a la classe EJB Entity passee en parametre. Il s'agit d'une
// introspection dans la classe générée.    
// --------------------------------------------------------------------------
// Le vecteur retourné (listeColonnes) est un vecteur d'objets "Colonne".
// Chaque Colonne contient trois proprietes :
// Le nom de la colonne (String)
// La taille de la colonne (Integer)
// Le type de la colonne (String)
// --------------------------------------------------------------------------
    
    public Vector<Colonne> lireListeColonnes(String nomTable)
    {
        Vector<Colonne> listeColonnes = new Vector<Colonne>();
        Colonne colonne;
        
        Annotation annotColumn;
        Annotation annotSize;
        Annotation annotJoinColumn;
        
        String annot;
        int debut;
        int fin;
        
        Class classeTable = null;
        
        try
        {
            classeTable = Class.forName(nomTable);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        
/* ------------------------------------------------------------------------- */        
/* Liste des proprietes de la classe                                         */        
/* ------------------------------------------------------------------------- */        
        Field tabFields[] = classeTable.getDeclaredFields();
        
        for(int i = 0; i < tabFields.length; i++)
        {
            
/* ------------------------------------------------------------------------- */        
/* Pour chaque propriete, recherche des annotation Column, JoinColumn, Size  */        
/* ------------------------------------------------------------------------- */
            annotColumn= tabFields[i].getAnnotation(Column.class);
            annotJoinColumn = tabFields[i].getAnnotation(JoinColumn.class);
            annotSize= tabFields[i].getAnnotation(Size.class);
            
/* ------------------------------------------------------------------------- */        
/* Les proprietes issues de la base ont une annotation @Column. La propriete */        
/* de mapping issue de la clef etrangere a une annotation @JoinColumn. On    */
/* considere ici que cette clef est un Integer (longueur 11)                 */
/* ------------------------------------------------------------------------- */
            if((annotColumn != null) || (annotJoinColumn != null))
            {
                colonne = new Colonne();
                
                if (annotColumn != null)
                {
                    colonne.setType(tabFields[i].getType().getName());
                    
                    annot = annotColumn.toString();
                    debut = annot.indexOf("name=") + 5;
                    fin = annot.indexOf(',', debut);
                    colonne.setNom(annot.substring(debut, fin));
                    
/* ------------------------------------------------------------------------- */        
/* Recherche de la longueur du champ s'il s'agit d'une String.               */        
/* Pour le type BigDecimal on mettra 16. Pour le type date on mettra 23.     */
/* Pour les autres types 11 (Integer par exemple).                           */
/* ------------------------------------------------------------------------- */
                    if(tabFields[i].getType().getName().
                        compareTo("java.lang.String") == 0)
                    {
                        if (annotSize != null)
                        {
                            annot = annotSize.toString();
                            debut = annot.indexOf("max=") + 4;
                            fin = annot.indexOf(',', debut);
                            colonne.setLongueur(
                                new Integer(annot.substring(debut, fin)));
                        }
                    }
                    else
                    {
                        if(tabFields[i].getType().getName().
                            compareTo("java.math.BigDecimal") == 0)
                        {
                            colonne.setLongueur(16);
                        }
                        else
                        {
                            if(tabFields[i].getType().getName().
                                compareTo("java.util.Date") == 0)
                                {
                                    colonne.setLongueur(23);
                                }
                            else
                            {
                                colonne.setLongueur(11);
                            }
                        }
                    }
                }
                else
                {
                    colonne.setType("java.lang.Integer");
                    colonne.setLongueur(11);
                    
                    annot = annotJoinColumn.toString();
                    debut = annot.indexOf("name=") + 5;
                    fin = annot.indexOf(',', debut);
                    colonne.setNom(annot.substring(debut, fin));
                }
                
                listeColonnes.add(colonne);
            }
        }

        return listeColonnes;
    }

// ----------------------------------------------------------------------------
// Chercher un contact (lire) : retourne le contact "numero" ou null...
// ----------------------------------------------------------------------------
    public Secteur lireSecteur(Integer numero)
    {

// ----------------------------------------------------------------------------
// Remarque : la difference entre find et getReference reste a preciser.
// Dans la documentation, pour getReference, il est question d'une entite dont
// l'etat peut etre cherche de façon "lazy"... ?
// ----------------------------------------------------------------------------
        Secteur secteur = em.find(Secteur.class, numero);

        return secteur;
    }

// ----------------------------------------------------------------------------
// Liste de tous les secteurs
// ----------------------------------------------------------------------------
    public Vector<Secteur> lireListeSecteurs()
    {
        Vector<Secteur> listeSecteurs;

        Query q = em.createNamedQuery("Secteur.findAll");
        listeSecteurs = (Vector<Secteur>)q.getResultList();

        return listeSecteurs;
    }
}
