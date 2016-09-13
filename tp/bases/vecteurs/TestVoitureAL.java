// ==========================================================================
// APPLICATION TestVoiture : TestVoiture avec vecteurs
// ==========================================================================

import java.util.*;               // Classe Vector
import java.io.*;                 // IOException
import utilitairesMG.divers.*;    // Clavier

public class TestVoitureAL
{
   public static void main(String argv[]) throws IOException
   {
      Garage g1, g2;
      ArrayList<Vendeur> vVendeur;   // VeArrayList des vendeurs
      ArrayList<Voiture> vVoiture;   // ArrayList des voitures
      int iVoiture;               // Indices
      int iVendeur;
      
      int nombreVoitures;         // Nombre de voitures a creer
      
      String nomVendeur;          // Nom du vendeur de la voiture
      int numeroMoteur;           // Numero de moteur de la voiture

// --------------------------------------------------------------------------
// Creation des garages
// --------------------------------------------------------------------------
      g1 = new Garage("10, avenue des Champs Elysees 75008 PARIS");
      g2 = new Garage();

// --------------------------------------------------------------------------
// Creation du vecteur des vendeurs
// --------------------------------------------------------------------------
      vVendeur = new ArrayList<Vendeur>();
      vVendeur.add(new Vendeur("Michel", "GIROUD", g1));
      vVendeur.add(new Vendeur("Michel", "GINESTE", g2));
      vVendeur.add(new Vendeur("Jean Pierre", "SIMARD", g1));

// --------------------------------------------------------------------------
// Creation du vecteur des voitures 
// --------------------------------------------------------------------------
      vVoiture = new ArrayList<Voiture>();
      System.out.print("Entrer le nombre de voitures a creer : ");
      nombreVoitures = Clavier.readInt();

// --------------------------------------------------------------------------
// Boucle de saisie des caracteristiques des voitures
// --------------------------------------------------------------------------
      for (iVoiture = 0; iVoiture < nombreVoitures; iVoiture++)
      {
         System.out.println("\n\nVoiture numero " + (iVoiture + 1) + " :");
         
         System.out.print("Numero de moteur (ou 0) : ");
         numeroMoteur = Clavier.readInt();
         
         System.out.print("Nom du vendeur : ");
         nomVendeur = Clavier.readString();
         
// --------------------------------------------------------------------------
// Boucle de recherche du nom de vendeur dans les objets de tabVendeur
// --------------------------------------------------------------------------
         iVendeur = 0;
         while ((iVendeur < vVendeur.size()) &&
                (vVendeur.get(iVendeur).getNomVendeur().
                 compareTo(nomVendeur)!= 0))
         {
            iVendeur++;
         }
         
// --------------------------------------------------------------------------
// Vendeur non trouve
// --------------------------------------------------------------------------
         if (iVendeur >= vVendeur.size())
         {
            if (numeroMoteur == 0)
            {
               vVoiture.add(new Voiture());
            }
            else
            {
               vVoiture.add(new Voiture(numeroMoteur));
            }
         }
         
// --------------------------------------------------------------------------
// Vendeur trouve
// --------------------------------------------------------------------------
         else
         {
            if (numeroMoteur == 0)
            {
               vVoiture.add(
                  new Voiture(vVendeur.get(iVendeur)));
            }
            else
            {
               vVoiture.add(
                  new Voiture(numeroMoteur, vVendeur.get(iVendeur)));
            }
         }
      }
         
// --------------------------------------------------------------------------
// Boucle d'impression des voitures
// --------------------------------------------------------------------------
      System.out.println("\n\nListe des voitures :\n");

      for (iVoiture = 0; iVoiture < vVoiture.size(); iVoiture++)
      {
         System.out.println(vVoiture.get(iVoiture));
      }
      
      Clavier.readString();
   }
}