// ==========================================================================
// APPLICATION TestAnimal
// --------------------------------------------------------------------------
// Héritage - redefinition de methode - polymorphisme
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class TestAnimalAL
{
   public static void main(String argv[]) throws IOException
   {  
      //Animal tableAnimal[] = new Animal[2];
      ArrayList<Animal> tableAnimal = new ArrayList<Animal>();
      int iAnimal;
 
// --------------------------------------------------------------------------
// Création des objets 
// --------------------------------------------------------------------------
      tableAnimal.add( new Vache(2) );
      tableAnimal.add( new Animal(2) );
      
// --------------------------------------------------------------------------
// Tant que des animaux sont vivants, on les fait crier et vieillir.
// --------------------------------------------------------------------------
      while (Animal.getNombreAnimauxVivants() > 0)
      {
         for(iAnimal = 0; iAnimal < tableAnimal.size(); iAnimal++)
         {
            if(tableAnimal.get(iAnimal).getVivant())
            {
               tableAnimal.get(iAnimal).crier();
               tableAnimal.get(iAnimal).vieillir();
            }
         }
      }
      
      Clavier.readString();
   }
}