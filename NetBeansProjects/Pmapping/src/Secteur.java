

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afpa1800
 */
public class Secteur {
    
    private int code;
    private String libelle;
    
    
// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEURS
// --------------------------------------------------------------------------
    public Secteur() {
    }
    
    public Secteur(int code, String libelle)
    {
        this.code = code;
        this.libelle = libelle;
    }

// --------------------------------------------------------------------------
// SETERS
// --------------------------------------------------------------------------
    public void setCode(Integer code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



// --------------------------------------------------------------------------
// GETERS
// --------------------------------------------------------------------------
    public Integer getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }


// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString() {
        String retour;

        retour = "Code              : " + code + "\n";
        retour += "Libelle                 : " + libelle + "\n\n";

        return retour;
    }
}


