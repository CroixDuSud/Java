// ==========================================================================
// TestEmploye2 : constructeurs, surdefinition de methodes
// --------------------------------------------------------------------------
// Chaque employe possede un matricule(int) et un nom(String)
//
// La classe Employe possede deux constructeurs :
// - un constructeur d'initialisation qui recoit deux parametres
// - un constructeur d'initialisation qui effectue la saisie clavier des 
//   parametres
//
// Elle possede les methodes suivantes :
// - affichage d'un employe
// - modification du nom (a partir d'un nom saisi dans le programme 
//   principal)
// - modification du matricule (a partir d'un entier saisi dans le programme 
//   principal)
// - modification du matricule (la saisie est faite dans la methode)
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestEmploye2
{
   public static void main(String argv[]) throws IOException
   {
      Employe2 e1, e2;
      int matricule;
      String nom;

      e1 = new Employe2(10, "CREVURE"); 
      e1.afficheEmploye();
      
      e2 = new Employe2();
      e2.afficheEmploye();
      
      System.out.print("Nouveau Nom de l'employe " + e2.getNom() + " : ");
      nom = Clavier.readString();
      e2.modifNom(nom);
      e2.afficheEmploye();
      
      System.out.print("Nouveau Matricule de l'employe " + 
                       e2.getMatricule() + " : ");
      matricule = Clavier.readInt();
      e2.modifMatricule(matricule);
      e2.afficheEmploye();
      
      e2.modifMatricule();
      e2.afficheEmploye();
      
      Clavier.readString();
    }
}

