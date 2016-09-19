// ==========================================================================
// APPLICATION Exception02 : try...catch, throws
// ==========================================================================


import java.io.*;
import utilitairesMG.divers.*;


public class Exception02
{
   public static void main(String argv[]) throws IOException
   {
   	int nombre;
   	
   	System.out.print("Saisir un nombre entier : ");
   	
// --------------------------------------------------------------------------
// La "capture" de l'erreur d'execution se fait par l'inclusion des 
// instructions qui "craignent" dans le bloc try. 
// --------------------------------------------------------------------------
   	try
   	{
   	   nombre = Clavier.readInt();
   	   System.out.println("\nNombre saisi : " + nombre);
   	}
// --------------------------------------------------------------------------
// Le bloc try DOIT etre IMMEDIATEMENT suivi par un ou plusieurs blocs catch
// contenant les traitements a effectuer.
// --------------------------------------------------------------------------
// Chaque bloc catch doit comporter l'indication de la classe de l'erreur a
// traiter.
// La reference e contient l'adresse de l'objet Exception qui a ete instancie
// par la machine virtuelle.
// --------------------------------------------------------------------------
   	catch (NumberFormatException e)
   	{
         e.printStackTrace();
   	   System.out.println("\nMais vous etes nul !");
   	}
      
      Clavier.readString();
   }
}