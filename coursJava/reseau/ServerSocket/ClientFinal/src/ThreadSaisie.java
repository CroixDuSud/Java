// ==========================================================================
// ThreadSaisie : thread de saisie clavier pour le client ClientFinal
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class ThreadSaisie extends Thread
{
    private PrintWriter sortie;

    public ThreadSaisie(PrintWriter sortie)
    {
        this.sortie = sortie;
    }

    public void run()
    {
        String message;

        try
        {

// --------------------------------------------------------------------------
// Le Thread courant est lance en demon par le programme main() de 
// ClientFinal. Quand le programme main se termine, ce Thread se termine
// automatiquement. La saisie est abandonnee et rien n'est envoye au serveur
// (sortie.prinln(message) ne se fait pas...).
// --------------------------------------------------------------------------
            System.out.print("\n(" + currentThread().getName()
                + ") Message a envoyer : ");
            message = Clavier.readString();
            sortie.println(message);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
