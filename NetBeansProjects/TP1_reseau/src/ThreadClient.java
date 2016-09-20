
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import javafx.beans.value.WritableObjectValue;
import utilitairesMG.jdbc.BaseDeDonnees;
import utilitairesMG.jdbc.JeuResultat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author afpa1800
 */
public class ThreadClient extends Thread
{

    private Socket socketClient;
    private BaseDeDonnees base;

    int nbLignes;

    //private Integer typeReponse;
    private String messageErreur;
    private JeuResultat resultatRequete;
    private Integer nbLignesModifiees;

    public ThreadClient(Socket socketClient, BaseDeDonnees base)
    {
        this.socketClient = socketClient;
        this.base = base;
    }

    public void run()
    {
        ObjectInputStream entree;
        ObjectOutputStream sortie;
        boolean requeteValide;
        String requete;
        String typeRequete;

        //System.out.println("Thread client : " + currentThread());
        //System.out.println("Client " + socketClient.getInetAddress());
        try
        {
            base.getConnection();

            sortie = new ObjectOutputStream(socketClient.getOutputStream());
            entree = new ObjectInputStream(socketClient.getInputStream());

            //sortie.writeObject("Lecture de la requete...");
            requete = (String) entree.readObject();
            //System.out.println(requete);
            ControleurServeur.afficheRequeteClient(socketClient.getInetAddress(),
                    requete);

            if (requete.substring(0, 6).equalsIgnoreCase("SELECT"))

            {

                try
                {
                    resultatRequete = base.executeQuery(requete);
                    //nbLignes = (resultatRequete.getLignes()).size();

                    sortie.writeObject(1);
                    sortie.writeObject(resultatRequete);

                } catch (SQLException e)
                {
                    sortie.writeObject(0);
                    sortie.writeObject("Requete invalide");
                }
            }

            if (requete.substring(0, 6).equalsIgnoreCase("UPDATE")
                    || requete.substring(0, 6).equalsIgnoreCase("INSERT")
                    || requete.substring(0, 6).equalsIgnoreCase("DELETE"))
            {
                try
                {
                    resultatRequete = base.executeQuery(requete);
                    nbLignes = base.executeUpdate(requete);
                    sortie.writeObject(2);
                    sortie.writeObject(nbLignes);
                } catch (Exception e)
                {
                    sortie.writeObject(0);
                    sortie.writeObject("Requete invalide");
                }
            }
            entree.close();
            sortie.close();
            socketClient.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
