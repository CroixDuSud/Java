// ==========================================================================
// APPLICATION TestAnimauxAbstract
// --------------------------------------------------------------------------
// Classes et methodes abstraites
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestAnimauxAbstract
{
   public static void main(String argv[]) throws IOException
   {  
      Animal tableAnimal[] = new Animal[2];
      int iAnimal;
 
// --------------------------------------------------------------------------
// Création des objets 
// --------------------------------------------------------------------------
      tableAnimal[0] = new Vache(0);
      tableAnimal[1] = new Mouton(0);
      
// --------------------------------------------------------------------------
// Tant que des animaux sont vivants, on les fait crier et vieillir.
// --------------------------------------------------------------------------
      while (Animal.getNombreAnimauxVivants() > 0)
      {
         for(iAnimal = 0; iAnimal < 2; iAnimal++)
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