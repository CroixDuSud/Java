// ==========================================================================
// APPLICATION TestAnimal
// --------------------------------------------------------------------------
// Héritage - redefinition de methode - polymorphisme
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestAnimal
{
   public static void main(String argv[]) throws IOException
   {  
      Animal tableAnimal[] = new Animal[2];
      int iAnimal;
    
// --------------------------------------------------------------------------
// Création des objets 
// --------------------------------------------------------------------------
      tableAnimal[0] = new Vache(2);
      tableAnimal[1] = new Mouton(1);
      
// --------------------------------------------------------------------------
// Tant que des animaux sont vivants, on les fait crier et vieillir.
// --------------------------------------------------------------------------
      while (Animal.getNombreAnimauxVivants() > 0)
      {
         for(iAnimal = 0; iAnimal < tableAnimal.length; iAnimal++)
         {
            if(tableAnimal[iAnimal].getVivant())
            {
               tableAnimal[iAnimal].crier();
               tableAnimal[iAnimal].vieillir();
            }
         }
      }
      
      Clavier.readString();
   }
}