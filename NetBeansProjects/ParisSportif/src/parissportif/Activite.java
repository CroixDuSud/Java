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
public class Activite
{
    private int idActivite;
    private String nom;
    private String type;
    
    public Activite()
    {
        
    }

    public int getIdActivite()
    {
        return idActivite;
    }

    public void setIdActivite(int idActivite)
    {
        this.idActivite = idActivite;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "Activite{" + "idActivite=" + idActivite + ", nom=" + nom + ", type=" + type + '}';
    }
    
    
}
