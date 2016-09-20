/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parissportif;

import java.util.Date;

/**
 *
 * @author afpa1800
 */
public class Pari
{
    private int idPari;
    private float cote;
    private double mise;
    private double gain;
    private Date date;
    private String type;
    private Bookmaker bookmaker;
    
    public Pari ()
    {
    }

    public int getIdPari()
    {
        return idPari;
    }

    public void setIdPari(int idPari)
    {
        this.idPari = idPari;
    }

    public float getCote()
    {
        return cote;
    }

    public void setCote(float cote)
    {
        this.cote = cote;
    }

    public double getMise()
    {
        return mise;
    }

    public void setMise(double mise)
    {
        this.mise = mise;
    }

    public double getGain()
    {
        return gain;
    }

    public void setGain(double gain)
    {
        this.gain = gain;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Bookmaker getBookmaker()
    {
        return bookmaker;
    }

    public void setBookmaker(Bookmaker bookmaker)
    {
        this.bookmaker = bookmaker;
    }

    @Override
    public String toString()
    {
        return "Pari{" + "idPari=" + idPari + ", cote=" + cote + ", mise=" + mise + ", gain=" + gain + ", date=" + date + ", type=" + type + ", bookmaker=" + bookmaker + '}';
    }
    
    
}
