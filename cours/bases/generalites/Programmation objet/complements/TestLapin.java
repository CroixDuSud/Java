// ==========================================================================
// APPLICATION TestLapin : CONSTRUCTEUR PRIVE
// --------------------------------------------------------------------------
// Constructeur private
// Il s'agit d'empecher l'utilisation directe du constructeur afin de ne
// construire un nouvel objet que lorsque c'est possible.
// Ici, on ne creera un nouveau lapin que si le nombre de lapins n'est pas
// trop grand. Il faut donc tester le nombre avant d'instancier... Mais pour
// tester la variable nombremaxi il faut etre dans la classe, car elle est
// encapsulee !!!
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestLapin
{
   public static void main(String argv[]) throws IOException
   {  
   	
// --------------------------------------------------------------------------
// Definition d'une variable Lapin.
// --------------------------------------------------------------------------
      Lapin l;
 
// --------------------------------------------------------------------------
// Creation des objets.
// --------------------------------------------------------------------------
      do
      {
         l = Lapin.creerLapin();
      }
      while(l != null);
      
      System.out.println("\n\nVoila... Ca suffit comme ca !\n");
      
      Clavier.readString();
   }
}

// ==========================================================================
// Classe Lapin :
// ==========================================================================

class Lapin
{

// --------------------------------------------------------------------------
// Proprietes : 
// --------------------------------------------------------------------------
// nombre : nombre de lapins crees
// nombremaxi : nombre maximum de lapins de l'elevage
// --------------------------------------------------------------------------
   private static int nombre = 0;
   private static int nombremaxi = 10;
   
// --------------------------------------------------------------------------
// Methodes : Constructeur (mis en private et incrementation du compteur)
// --------------------------------------------------------------------------
   private Lapin()
   {
      ++nombre;
   }

// --------------------------------------------------------------------------
// creerLapin : methode public avec test du nombremaxi
// --------------------------------------------------------------------------
// public : pour etre utilisable de l'exterieur
// static : pour etre appelee sans instancier d'objet (on doit tester
//          avant la creation de l'objet l (Lapin)
// Lapin : on va retourner un pointeur vers un objet Lapin ou null
// --------------------------------------------------------------------------
   public static Lapin creerLapin()
   {
      Lapin l;
      
      if (nombre < nombremaxi)
      {
         l = new Lapin();
         System.out.println("Lapin cree avec le numero " + nombre);
         return l;
      }
      else
      {
         System.out.println("Lapin non cree, il y en a deja " + nombremaxi);
         return null;
      }
   }
}