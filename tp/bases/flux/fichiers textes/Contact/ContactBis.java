// ==========================================================================
// CLASSE Contact                                             Projet Contacts
// ==========================================================================

public class ContactBis implements Comparable<ContactBis>
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
   private Integer numero;
   private String  nom;
   private String  adresse;
   private String  codePostal;
   private String  ville;
   private Integer codeSecteur;

// ==========================================================================
// CONSTRUCTEUR
// ==========================================================================

public ContactBis(Integer num, String nom, String adr, String cp, String vil, Integer cs)
{
    numero = num;
    this.nom= nom;
    adresse = adr;
    codePostal = cp;
    ville = vil;
    codeSecteur = cs;
}

// ==========================================================================
// METHODES
// ==========================================================================

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
/*   public void setNumero(Integer numero)
   {
      this.numero = numero;
   }
   
   public void setNom(String nom)
   {
      this.nom = nom;
   }
   
   public void setAdresse(String adresse)
   {
      this.adresse = adresse;
   }
   
   public void setCodePostal(String codePostal)
   {
      this.codePostal = codePostal;
   }
   
   public void setVille(String ville)
   {
      this.ville = ville;
   }

   public void setCodeSecteur(Integer codeSecteur)
   {
      this.codeSecteur = codeSecteur;
   }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
   public Integer getNumero()
   {
      return numero;
   }
   
   public String getNom()
   {
      return nom;
   }
   
   public String getAdresse()
   {
      return adresse;
   }
   
   public String getCodePostal()
   {
      return codePostal;
   }
   
   public String getVille()
   {
      return ville;
   }
   
   public Integer getCodeSecteur()
   {
      return codeSecteur;
   }
*/ 
// --------------------------------------------------------------------------
// COMPARAISON DE DEUX OBJETS Contact
// --------------------------------------------------------------------------
   @Override
   public int compareTo(ContactBis c)
   {
      //return getNumero().compareTo(c.getNumero());
      return numero.compareTo(c.numero);
   }
  
// --------------------------------------------------------------------------
// AFFICHAGE DU Contact
// --------------------------------------------------------------------------
   @Override
   public String toString()
   {
      String retour;
      
      retour =  numero + ";" + 
                nom + ";" + 
                adresse + ";" + 
                codePostal + ";" +
                ville + ";" + 
                codeSecteur;

      return retour;
   }
}
