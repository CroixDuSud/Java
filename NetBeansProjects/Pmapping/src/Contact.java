// ==========================================================================
// Classe Contact                                         Application JTable4
// ==========================================================================

public class Contact
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
   private Integer numero;                                   // Clef primaire
   private String nom;
   private String adresse;
   private String codePostal;
   private String ville;
   private Integer codeSecteur;                // Clef etrangere vers Secteur
   
// ==========================================================================
// METHODES
// ==========================================================================

// --------------------------------------------------------------------------
// CONSTRUCTEURS
// --------------------------------------------------------------------------
   public Contact()
   {
   }
   
   public Contact(Integer numero, String nom, String adresse, String codePostal,
           String ville, Integer codeSecteur)
   {
       this.numero = numero;
       this.nom = nom;
       this.adresse = adresse;
       this.codePostal = codePostal;
       this.ville = ville;
       this.codeSecteur = codeSecteur;
   }
   
// --------------------------------------------------------------------------
// SETERS
// --------------------------------------------------------------------------
   public void setNumero(Integer numero)
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
// GETERS
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

// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
   public String toString()
   {
      String retour;
      
      retour =  "Numero              : " + numero + "\n";
      retour += "Nom                 : " + nom + "\n";
      retour += "Adresse             : " + adresse + "\n";      
      retour += "Code Postal         : " + codePostal + "\n";      
      retour += "Ville               : " + ville + "\n"; 
      retour += "Code secteur        : " + codeSecteur + "\n\n";

      return retour;
   }
}
