// ======================================================================
// Classe Employe2
// ======================================================================

import java.io.*;
import utilitairesMG.divers.*;


class Employe2
{
// ----------------------------------------------------------------------
// Proprietes
// ----------------------------------------------------------------------
   private int matricule;
   private String nom;

// --------------------------------------------------------------------------
// Constructeurs
// --------------------------------------------------------------------------
   public Employe2(int matricule, String nom)
   {
      this.matricule = matricule;
      this.nom = nom;
   }
   
   public Employe2() throws IOException
   {
      System.out.print("Nom : ");
      nom = Clavier.readString();
      System.out.print("Matricule : ");
      matricule = Clavier.readInt();
   }

// --------------------------------------------------------------------------
// Methodes
// --------------------------------------------------------------------------
   public void afficheEmploye()
   {
      System.out.println("\nNom : " + nom + 
                         "\t\tMatricule : "  + matricule + "\n");
   }

   public void modifNom(String nom)
   {
      this.nom = nom;
   }

   public void modifMatricule() throws IOException
   {
      System.out.print("Nouveau Matricule de l'employe " + matricule + " : ");
      matricule = Clavier.readInt();
   }

   public void modifMatricule(int matricule)
   {
      this.matricule = matricule;
   }
   
   public String getNom()
   {
      return nom;
   }

   public int getMatricule()
   {
      return matricule;
   }
}