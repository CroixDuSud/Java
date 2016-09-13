// ==========================================================================
// APPLICATION Exception03 : try...catch (Plus de throws)
// ==========================================================================


import java.io.*;
import utilitairesMG.divers.*;


public class Exception03
{
   public static void main(String argv[])
   {
   	int nombre;
   	
   	System.out.print("Saisir un nombre entier : ");
   	
   	try
   	{
   	   nombre = Clavier.readInt();
   	   System.out.println("\nNombre saisi : " + nombre);
   	}
   	catch (NumberFormatException e)
   	{
   	   System.out.println("\nMais vous etes nul !");
   	}
   	catch (IOException e)
   	{
   	   System.out.println("\nErreur IOException dans readInt !");
   	}
      
      try
      {
         Clavier.readString();
      }
   	catch (IOException e)
   	{
   	   System.out.println("\nErreur IOException dans readString !");
   	}
   }
}