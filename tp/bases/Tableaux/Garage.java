// ==========================================================================
// Classe Garage :  
// ==========================================================================

public class Garage
{
// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// nomGarage : nom du garage (fixe pour tous les garages)
// adresseGarage : adresse du garage
// --------------------------------------------------------------------------
   private static String nomGarage = "AFPA ROMEO";
   private String adresseGarage;
   
// --------------------------------------------------------------------------
// Constructeurs :
// --------------------------------------------------------------------------
   public Garage(String adresseGarage)
   {
      this.adresseGarage = adresseGarage;
   }
   
   public Garage()
   {
      adresseGarage = "1, rue Marc Seguin 94000 CRETEIL";
   }
   
// --------------------------------------------------------------------------
// Methodes :
// --------------------------------------------------------------------------
   public String toString()
   {
      return nomGarage + " - " + adresseGarage;
   }
   
   public static String getNomGarage()
   {
      return nomGarage;
   }
}