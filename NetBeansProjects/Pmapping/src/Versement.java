
import java.math.BigDecimal;
import java.util.Date;
import utilitairesMG.divers.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author afpa1800
 */
public class Versement {

    private Integer numero;
    private Date date;
    private BigDecimal montant;
    private Integer numeroContact;


// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEURS
// --------------------------------------------------------------------------
    public Versement() {
    }
    
    public Versement(Integer numero, Date date, BigDecimal montant,
            Integer numeroContact)
    {
        this.numero = numero;
        this.date = date;
        this.montant = montant;
        this.numeroContact = numeroContact;
    }

// --------------------------------------------------------------------------
// SETERS
// --------------------------------------------------------------------------
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
    
    public void setNumeroContact(Integer numeroContact)
    {
        this.numeroContact = numeroContact;
    }


// --------------------------------------------------------------------------
// GETERS
// --------------------------------------------------------------------------
    public Integer getNumero() {
        return numero;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getMontant() {
        return montant;
    }
    
    public Integer getNumeroContact()
    {
        return numeroContact;
    }


// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString() {
        String retour;

        retour = "Numero              : " + numero + "\n";
        retour += "Date                 : " + date + "\n";
        retour += "Montant             : " + montant + "\n";
        retour += "numeroContact       : " + numeroContact + "\n\n";

        return retour;
    }
}