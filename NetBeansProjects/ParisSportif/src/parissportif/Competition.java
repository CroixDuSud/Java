/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parissportif;

/**
 *
 * @author afpa1800
 */
public class Competition
{
    private int idCompetition;
    private String nom;
    private String libelle;
    private int idActivite;
    private Activite activite;
    
    public Competition()
    {
        
    }

    public int getIdCompetition()
    {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition)
    {
        this.idCompetition = idCompetition;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public int getIdActivite()
    {
        return idActivite;
    }

    public void setIdActivite(int idActivite)
    {
        this.idActivite = idActivite;
    }

    public Activite getActivite()
    {
        return activite;
    }

    public void setActivite(Activite activite)
    {
        this.activite = activite;
    }

    @Override
    public String toString()
    {
        return "Competition{" + "idCompetition=" + idCompetition + ", nom=" + nom + ", libelle=" + libelle + ", idActivite=" + idActivite + ", activite=" + activite + '}';
    }
    
    
}
