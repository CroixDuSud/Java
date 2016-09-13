// ==========================================================================
// APPLICATION TestSynthese
// --------------------------------------------------------------------------
// Interface, classe abstraite...
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestSynthese
{
   public static void main(String argv[]) throws IOException
   {  
      ClasseFille cf = new ClasseFille();
      cf.fumier();
      cf.tordu();
      cf.salopard();
      cf.crevure(); 
      
      ClasseFille2 cf2 = new ClasseFille2();
      cf2.tordu();
      cf2.fumier();
      
      Clavier.readString();
   }
}

// ==========================================================================
// Interface Indemerdable
// ==========================================================================
interface Indemerdable
{
   public void fumier();
}


// ==========================================================================
// Classe ClasseParente
// ==========================================================================
abstract class ClasseParente implements Indemerdable
{
   public void crevure()
   {
      System.out.println("crevure()");
   }
   
   public abstract void tordu();
   

}


// ==========================================================================
// Classe ClasseFille
// ==========================================================================
class ClasseFille extends ClasseParente
{

// --------------------------------------------------------------------------
// La methode fumier() doit etre redefinie a cause du implements Indemerdable
// --------------------------------------------------------------------------
   public void fumier()
   {
      System.out.println("fumier()");
   }
   
// --------------------------------------------------------------------------
// La methode tordu() doit etre redefinie a cause de sa definition en 
// abstract dans ClasseParente
// --------------------------------------------------------------------------
   public void tordu()
   {
      System.out.println("tordu()");
   }
   
// --------------------------------------------------------------------------
// Methode locale a la classe ClasseFille
// --------------------------------------------------------------------------
   public void salopard()
   {
      System.out.println("salopard()");
   }
}

// ==========================================================================
// Classe ClasseFille2
// ==========================================================================
class ClasseFille2 extends ClasseParente
{

// --------------------------------------------------------------------------
// La methode fumier() doit etre redefinie a cause du implements Indemerdable
// --------------------------------------------------------------------------
   public void fumier()
   {
      System.out.println("fumier2()");
   }
   
// --------------------------------------------------------------------------
// La methode tordu() doit etre redefinie a cause de sa definition en 
// abstract dans ClasseParente
// --------------------------------------------------------------------------
   public void tordu()
   {
      System.out.println("tordu2()");
   }
   
// --------------------------------------------------------------------------
// Methode locale a la classe ClasseFille
// --------------------------------------------------------------------------
   public void salopard()
   {
      System.out.println("salopard2()");
   }
}
