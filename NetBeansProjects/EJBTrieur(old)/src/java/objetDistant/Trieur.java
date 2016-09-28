/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetDistant;

import javax.ejb.Stateless;

/**
 *
 * @author afpa1800
 */
@Stateless
public class Trieur  implements TrieurRemote
{
// --------------------------------------------------------------------------
// Constructeur : construit une implementation de Trieur
// --------------------------------------------------------------------------
// Remarque : le constructeur de UnicastRemoteObject peut declencher une
// RemoteException... Il faut la traiter...  Ce constructeur est donc
// obligatoire, meme si c'est celui par defaut.
// --------------------------------------------------------------------------

    public Trieur()
    {
    }

// --------------------------------------------------------------------------
// Implementation de la methode trier exposee par l'interface Trieur
// --------------------------------------------------------------------------
    @Override
    public Comparable[] trier(Comparable tableau[])
    {
        boolean permut;
        int n;
        Comparable x;

        do
        {
            permut = false;
            for (n = 0; n < tableau.length - 1; n++)
            {
                if (tableau[n].compareTo(tableau[n + 1]) > 0)
                {
                    x = tableau[n];
                    tableau[n] = tableau[n + 1];
                    tableau[n + 1] = x;
                    permut = true;
                }
            }
        }
        while (permut == true);

        return tableau;
    }
}
