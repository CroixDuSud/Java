// ==========================================================================
// APPLICATION TestVoiture : TestVoiture avec tableaux
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestVoiture
{
   public static void main(String argv[]) throws IOException
   {
      Garage g1, g2;
      Vendeur tabVendeur[];       // Table des vendeurs
      Voiture tabVoiture[];       // Table des voitures
      int iVoiture;               // Indices
      int iVendeur;
      
      int nombreVoitures;         // Dimension de la table des voitures
      
      String nomVendeur;          // Nom du vendeur de la voiture
      int numeroMoteur;           // Numero de moteur de la voiture

// --------------------------------------------------------------------------
// Creation des garages
// --------------------------------------------------------------------------
      g1 = new Garage("10, avenue des Champs Elysees 75008 PARIS");
      g2 = new Garage();

// --------------------------------------------------------------------------
// Creation du tableau des vendeurs
// --------------------------------------------------------------------------
      tabVendeur = new Vendeur[3];
      tabVendeur[0] = new Vendeur("Michel", "GIROUD", g1);
      tabVendeur[1] = new Vendeur("Michel", "GINESTE", g2);      
      tabVendeur[2] = new Vendeur("Jean Pierre", "SIMARD", g1);

// --------------------------------------------------------------------------
// Creation et affichage des voitures
// --------------------------------------------------------------------------
      System.out.print("Entrer le nombre de voitures a creer : ");
      nombreVoitures = Clavier.readInt();
      tabVoiture = new Voiture[nombreVoitures];

// --------------------------------------------------------------------------
// Boucle de saisie des caracteristiques des voitures
// --------------------------------------------------------------------------
      for (iVoiture = 0; iVoiture < nombreVoitures; iVoiture++)
      {
         System.out.println("\n\nVoiture numero " + (iVoiture + 1) + " :");
         
         System.out.print("Numero de moteur (ou 0) : ");
         numeroMoteur = Clavier.readInt();
         
         System.out.print("Nom du vendeur : ");
         nomVendeur = Clavier.readString();
         
// --------------------------------------------------------------------------
// Boucle de recherche du nom de vendeur dans les objets de tabVendeur
// --------------------------------------------------------------------------
         iVendeur = 0;
         while ((iVendeur < tabVendeur.length) &&
                (tabVendeur[iVendeur].getNomVendeur().compareTo(nomVendeur)!= 0))
         {
            iVendeur++;
         }
         
// --------------------------------------------------------------------------
// Vendeur non trouve
// --------------------------------------------------------------------------
         if (iVendeur >= tabVendeur.length)
         {
            if (numeroMoteur == 0)
            {
               tabVoiture[iVoiture] = new Voiture();
            }
            else
            {
               tabVoiture[iVoiture] = new Voiture(numeroMoteur);
            }
         }
         
// --------------------------------------------------------------------------
// Vendeur trouve
// --------------------------------------------------------------------------
         else
         {
            if (numeroMoteur == 0)
            {
               tabVoiture[iVoiture] = new Voiture(tabVendeur[iVendeur]);
            }
            else
            {
               tabVoiture[iVoiture] = new Voiture(numeroMoteur, tabVendeur[iVendeur]);
            }
         }
      }
         
// --------------------------------------------------------------------------
// Boucle d'impression des voitures
// --------------------------------------------------------------------------
      System.out.println("\n\nListe des voitures :\n");

      for (iVoiture = 0; iVoiture < nombreVoitures; iVoiture++)
      {
         System.out.println(tabVoiture[iVoiture]);
      }
      
      Clavier.readString();
   }
}
 
/* 
// ==========================================================================
// Classe Voiture :  
// ==========================================================================

class Voiture
{
// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// kVoiture : compteur du nombre de voitures instanciees.
// numVoiture : numéro de voiture de l'objet courant.
// vendeurVoiture : vendeur de la voiture.
// moteurVoiture : moteur de la voiture.
// --------------------------------------------------------------------------
   private static int kVoiture = 0;
   
   private int numVoiture;
   private Vendeur vendeurVoiture;
   private Moteur moteurVoiture;

// --------------------------------------------------------------------------
// Constructeurs : utilisent kVoiture pour initialiser numVoiture.
// --------------------------------------------------------------------------
// Constructeur sans paramètre.
// --------------------------------------------------------------------------
   public Voiture()
   {
      kVoiture++;
      numVoiture = kVoiture;   
      moteurVoiture = new Moteur();
   }
   
// --------------------------------------------------------------------------
// Constructeur avec paramètre : idem que le précédent mais ce constructeur
// utilise une variable num de type entier pour initialiser le numéro de 
// moteur de la voiture.
// --------------------------------------------------------------------------
   public Voiture(int num)
   {
      kVoiture++;
      numVoiture = kVoiture;   
      moteurVoiture = new Moteur(num);
   }
   
// --------------------------------------------------------------------------
// Constructeur avec paramètre : idem que le premier mais ce constructeur
// utilise une variable vendeurVoiture de type Vendeur pour initialiser le
// nom du vendeur de la voiture.
// --------------------------------------------------------------------------
   public Voiture(Vendeur vendeurVoiture)
   {
      kVoiture++;
      numVoiture = kVoiture;   
      moteurVoiture = new Moteur();
      this.vendeurVoiture = vendeurVoiture;
   }

// --------------------------------------------------------------------------
// Constructeur avec paramètres : combinaison des deux constructeurs
// précédents.
// --------------------------------------------------------------------------
   public Voiture(int num, Vendeur vendeurVoiture)
   {
      kVoiture++;
      numVoiture = kVoiture;   
      moteurVoiture = new Moteur(num);
      this.vendeurVoiture = vendeurVoiture;
   }

// --------------------------------------------------------------------------
// - Surcharge de la fonction toString de la classe Object
//   Cette méthode est exécutée lors de l'appel "System.out.println(v1)".
//   Quand la fonction println s'exécute, elle cherche une méthode toString 
//   correspondant à l'objet. Si elle ne la trouve pas, elle exécute celle de
//   la classe Object, qui affichera l'adresse mémoire de v1...
// --------------------------------------------------------------------------
   public String toString()
   {
      if(vendeurVoiture != null)
      {
         return("\nVOITURE   : "  + numVoiture +
                "\nMOTEUR    : "  + moteurVoiture.toString() +
                "\nVENDEUR   : " + vendeurVoiture.toString());
      }
      else
      {
         return("\nVOITURE   : "  + numVoiture +
                "\nMOTEUR    : "  + moteurVoiture.toString() +
                "\nVENDEUR INCONNU");
      }
   }
}


// ==========================================================================
// Classe Moteur :  
// ==========================================================================

class Moteur
{
// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// kMoteur : numéro de moteur à attribuer à tout nouveau moteur (compteur).
// numMoteur : numéro du moteur de l'objet courant.
// --------------------------------------------------------------------------
   private static int kMoteur = 1000;
   private String numMoteur;

// --------------------------------------------------------------------------
// Constructeurs :
// --------------------------------------------------------------------------
// Constructeur sans paramètre : utilise kMoteur pour initialiser le numéro
// de moteur numMoteur.
// --------------------------------------------------------------------------
   public Moteur()
   {
      kMoteur++;
      numMoteur = "NMOT" + kMoteur;
   }

// --------------------------------------------------------------------------
// Constructeur avec paramètre : utilise une variable num de type entier 
// pour initialiser numMoteur.
// --------------------------------------------------------------------------
   public Moteur(int num)
   {
      numMoteur = "NMOT" + num;
   }

// --------------------------------------------------------------------------
// Methode toString
// --------------------------------------------------------------------------
   public String toString()
   {
      return (numMoteur);
   }
}


// ==========================================================================
// Classe Garage :  
// ==========================================================================

class Garage
{
// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// nomGarage : nom du garage (fixe pour tous les garages)
// adresseGarage : adresse du garage
// --------------------------------------------------------------------------
   private static String nomGarage = "AFPA ROMEO";
   private String adresseGarage = "1, rue Marc Seguin 94000 CRETEIL";
   
// --------------------------------------------------------------------------
// Constructeurs :
// --------------------------------------------------------------------------
   public Garage(String adresseGarage)
   {
      this.adresseGarage = adresseGarage;
   }
   
   public Garage()
   {
   }
   
// --------------------------------------------------------------------------
// Methodes :
// --------------------------------------------------------------------------
   public String toString()
   {
      return (nomGarage + " - " + adresseGarage);
   }
   
   public static String getNomGarage()
   {
      return (nomGarage);
   }
}


// ==========================================================================
// Classe Vendeur :  
// ==========================================================================

class Vendeur
{
// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
   private String prenomVendeur;
   private String nomVendeur;
   private Garage garageVendeur;
   
// --------------------------------------------------------------------------
// Constructeur :
// --------------------------------------------------------------------------
   public Vendeur(String prenomVendeur, 
                  String nomVendeur, 
                  Garage garageVendeur)
   {
      this.prenomVendeur = prenomVendeur;
      this.nomVendeur = nomVendeur;
      this.garageVendeur = garageVendeur;
   }
   
// --------------------------------------------------------------------------
// Methodes :
// --------------------------------------------------------------------------
   public String toString()
   {
      return ("\n" + prenomVendeur + " " + nomVendeur + 
              "\n" + garageVendeur.toString());
   }
   
   public String getNomVendeur()
   {
      return (nomVendeur);
   }
}
*/