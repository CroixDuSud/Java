// ==========================================================================
// SurveilleeNonSurveillee : types d'exceptions
// ==========================================================================

import java.io.*;   
import utilitairesMG.divers.*;

public class SurveilleeNonSurveillee
{
   public static void main(String argv[]) throws IOException
   {
   	int nombre;
   	
   	System.out.print("Saisir un nombre entier : ");
   	nombre = Clavier.readInt();
      
   	System.out.println("\nNombre saisi : " + nombre);
      Clavier.readString();
   }
}