// ======================================================================
// TestEmploye1 : classes, objets, proprietes, methodes, 
//                constructeur par defaut.
// ======================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestEmploye1
{
   public static void main(String argv[]) throws IOException
   {
      Employe1 e;

      e = new Employe1();
      e.afficheEmploye();
      
      e.saisieNom();
      e.afficheEmploye();
      
      e.saisieMatricule();
      e.afficheEmploye();
      
      Clavier.readString();
    }
}

