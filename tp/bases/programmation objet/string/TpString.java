// ==========================================================================
// APPLICATION TpString : exercices sur les chaines de caracteres
// --------------------------------------------------------------------------
// A partir de la chaîne : "J'utilise JAVA avec brio !"
//
// 1) Transformez les minuscules en majuscules et reciproquement.
// 2) Donnez la longueur de la chaîne.
// 3)	Remplacez les espaces par des _  (underscore).					 
// 4)	Ecrivez la chaîne en inversé (ex . ABC --> CBA ) . 
// 5)	Remplacez JAVA par C++.
// 6)	Comptez combien de fois chaque lettre est utilisée.
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;


public class TpString
{ 
    public static void main (String arg [] ) throws IOException
    { 
        String chaine;                // Chaine a traiter
        int longueur;                 // Longueur de la chaine
        String chaineTravail;         // Chaine de travail
        char c;                       // Caractere examine
        int i;                        // Indice du caractere examine
        int compteurC;                // Compteur de caracteres
	
        chaine = "J'utilise JAVA avec brio !";
        System.out.println("AU DEPART  - " + chaine + "\n");

// --------------------------------------------------------------------------
// Inversion des minuscules et des majuscules
// --------------------------------------------------------------------------
    chaineTravail ="";
		
    for (i = 0; i < chaine.length(); i++)
    {
        c = chaine.charAt(i);

        if ((c >= 'a') && (c <= 'z'))
        {
            c -= 'a' - 'A';
        }
        else
        {
            if ((c >= 'A') && (c <= 'Z')) c += 'a' - 'A';
        }
        chaineTravail += c;
    }
		
    chaine = chaineTravail;
    System.out.println("EXERCICE 1 - " + chaine);

// --------------------------------------------------------------------------
// Longueur de la chaine
// --------------------------------------------------------------------------
    System.out.println("EXERCICE 2 - LONGUEUR DE LA CHAINE : " + 
              chaine.length());

// --------------------------------------------------------------------------
// Remplacement des espaces par _ (underscore)
// --------------------------------------------------------------------------
    chaine = chaine.replace(' ', '_');  // La reaffectation de chaine est
                                        // necessaire car replace() renvoie
                                        // une NOUVELLE chaine
    System.out.println("EXERCICE 3 - " + chaine);
		
// --------------------------------------------------------------------------
// Affichage de la chaine a l'envers
// --------------------------------------------------------------------------
    System.out.println("EXERCICE 4 - " + 
                new StringBuffer(chaine).reverse());

// --------------------------------------------------------------------------
// Remplacement de java par c++
// --------------------------------------------------------------------------
    chaine = chaine.replace("java", "C++");
    System.out.println("EXERCICE 5 - " + chaine);
    Clavier.readString();

// --------------------------------------------------------------------------
// Comptage des lettres
// --------------------------------------------------------------------------
// Principe : On regarde combien de fois la premiere lettre de la chaine
//            figure dans la chaine. Au fur et a mesure de l'examen on
//            cree une nouvelle chaine en eliminant le caractere. Cela 
//            diminue la longueur de la chaine (au moins de 1). On
//            recommence jusqu'a ce que la chaine obtenue soit vide.
// --------------------------------------------------------------------------
    System.out.println("\nEXERCICE 6 - LISTE DES CARACTERES\n");
    longueur = chaine.length();
      
    while (longueur != 0)
    {
        c = chaine.charAt(0);           // Premier caractere de la chaine
        compteurC = 1;                  // Nombre de fois ou c est utilisee
        chaineTravail = "";             // Chaine debarassee des c
         
        i = 1;                          // Debut de la zone a recopier
         
        while(i < longueur)
        {
            if (chaine.charAt(i) == c)
            {
               compteurC++;
            }
            else
            {
                chaineTravail += chaine.charAt(i);
            }
            i++;
        }
         
        System.out.println("Il y a " + compteurC + 
                            " fois le caractere " + c);
                            
        chaine = chaineTravail;
        longueur = chaine.length();
    }
    Clavier.readString();
    }
}