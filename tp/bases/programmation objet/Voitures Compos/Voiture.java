// ==========================================================================
// Classe Voiture :  
// ==========================================================================

public class Voiture
{
   private static int kVoiture = 0;
   
   private int numVoiture;
   private Vendeur vendeurVoiture;
   private Moteur moteurVoiture;
   private static int kMoteur = 1000;
   
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
// Surcharge de la methode toString de la classe Object
// --------------------------------------------------------------------------
// Cette methode est executee lors de l'appel "System.out.println(v1)".
// Quand la fonction println s'execute, elle cherche une methode toString 
// correspondant a l'objet. Si elle ne la trouve pas, elle execute celle de
// la classe Object, qui affichera l'adresse memoire de v1...
// --------------------------------------------------------------------------
   public String toString()
   {
      if(vendeurVoiture != null)
      {
         return "\nVOITURE   : "  + numVoiture +
                "\nMOTEUR    : "  + moteurVoiture +
                "\nVENDEUR   : "  + vendeurVoiture;
      }
      else
      {
         return "\nVOITURE   : "  + numVoiture +
                "\nMOTEUR    : "  + moteurVoiture +
                "\nVENDEUR INCONNU";
      }
   }

// ==========================================================================
// Classe interne Moteur : cette classe ne pourra pas etre instanciee en 
//                         dehors de Voiture...
// ==========================================================================

   private class Moteur
   {
// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// numMoteur : numéro du moteur de l'objet courant.
// --------------------------------------------------------------------------
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
         return numMoteur;
      }
   }
}