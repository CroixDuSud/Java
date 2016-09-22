package sourcesJspUtilisateur;



// ----------------------------------------------------------------------- //
// Utilisateur.java : JavaBean                                             //
// ----------------------------------------------------------------------- //

import java.io.Serializable;

// ----------------------------------------------------------------------- //
// L'implementation de Serializable est obligatoire pour que la classe     //
// Utilisateur soit un bean.                                               //
// ----------------------------------------------------------------------- //

public class Utilisateur implements Serializable
{
   private String nom;
   private String prenom;
   private String login;
   private Integer age;

   public String getNom()
   {
      return nom;
   }

   public void setNom(String nom)
   {
      this.nom = nom;
   }

   public String getPrenom()
   {
      return prenom;
   }

   public void setPrenom(String prenom)
   {
      this.prenom = prenom;
   }

   public String getLogin()
   {
      return login;
   }

   public void setLogin(String login)
   {
      this.login = login;
   }

   public Integer getAge()
   {
      return age;
   }

   public void setAge(Integer age)
   {
      this.age = age;
   }
}
