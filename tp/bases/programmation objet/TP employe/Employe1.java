// ======================================================================
// Classe Employe
// ======================================================================

import java.io.*;
import utilitairesMG.divers.*;


class Employe1
{
// ----------------------------------------------------------------------
// Proprietes
// ----------------------------------------------------------------------
   private int matricule;
   private String nom;

// ----------------------------------------------------------------------
// Methodes
// ----------------------------------------------------------------------
   public void afficheEmploye()
   {
      System.out.println("\nNom : " + nom + 
                         " Matricule : "  + matricule + "\n");
   }

   public void saisieNom() throws IOException
   {
      System.out.print("Nouveau Nom : ");
      nom = Clavier.readString();
   }

   public void saisieMatricule() throws IOException
   {
      System.out.print("Nouveau Matricule : ");
      matricule = Clavier.readInt();
   }
}