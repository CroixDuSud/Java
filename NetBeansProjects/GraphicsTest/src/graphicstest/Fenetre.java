/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicstest;

//Les imports habituels
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame{
  //Nos variables habituelles

  //La déclaration pour le menu contextuel 
  private JPopupMenu jpm = new JPopupMenu();
  private JMenu background = new JMenu("Couleur de fond");
  private JMenu couleur = new JMenu("Couleur de la forme");

  private JMenuItem launch = new JMenuItem("Lancer l'animation");      
  private JMenuItem stop = new JMenuItem("Arrêter l'animation");
  private JMenuItem  rouge = new JMenuItem("Rouge"),
    bleu = new JMenuItem("Bleu"),
    vert = new JMenuItem("Vert"),
    rougeBack = new JMenuItem("Rouge"),
    bleuBack = new JMenuItem("Bleu"),
    vertBack = new JMenuItem("Vert");

  //On crée des listeners globaux
  private StopAnimationListener stopAnimation=new StopAnimationListener();
  private StartAnimationListener startAnimation=new StartAnimationListener();
  
  public Fenetre(){
    this.setTitle("Animation");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    container.setBackground(Color.white);
    Container.setLayout(new BorderLayout());

    //On initialise le menu stop
    stop.setEnabled(false);
    //On affecte les écouteurs
    stop.addActionListener(stopAnimation);
    launch.addActionListener(startAnimation);

    //On crée et on passe l'écouteur pour afficher le menu contextuel
    //Création d'une implémentation de MouseAdapter
    //avec redéfinition de la méthode adéquate
    pan.addMouseListener(new MouseAdapter(){
      public void mouseReleased(MouseEvent event){
        //Seulement s'il s'agit d'un clic droit
        //if(event.getButton() == MouseEvent.BUTTON3)
        if(event.isPopupTrigger()){       
          background.add(rougeBack);
          background.add(bleuBack);
          background.add(vertBack);

          couleur.add(rouge);
          couleur.add(bleu);
          couleur.add(vert);

          jpm.add(launch);
          jpm.add(stop);
          jpm.add(couleur);
          jpm.add(background);
          //La méthode qui va afficher le menu
          jpm.show(pan, event.getX(), event.getY());
        }
      }
    });

    container.add(pan, BorderLayout.CENTER);

    this.setContentPane(container);
    this.initMenu();
    this.setVisible(true);    

  }

  private void initMenu(){
    //Ajout du listener pour lancer l'animation
    //ATTENTION, LE LISTENER EST GLOBAL !!! 
    lancer.addActionListener(startAnimation);
    //On attribue l'accélerateur c
    lancer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
    animation.add(lancer);

    //Ajout du listener pour arrêter l'animation
    //LISTENER A CHANGER ICI AUSSI
    arreter.addActionListener(stopAnimation);
    arreter.setEnabled(false);
    arreter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
    animation.add(arreter);

    //Le reste est inchangé
  }

  private void go(){
    //La méthode n'a pas changé    
  }

  public class StartAnimationListener implements ActionListener{
    public void actionPerformed(ActionEvent arg0) {
      JOptionPane jop = new JOptionPane();     
      int option = jop.showConfirmDialog(null, 
        "Voulez-vous lancer l'animation ?", 
        "Lancement de l'animation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);

      if(option == JOptionPane.OK_OPTION){
        lancer.setEnabled(false);
        arreter.setEnabled(true);

        //On ajoute l'instruction pour le menu contextuel
        launch.setEnabled(false);
        stop.setEnabled(true);

        animated = true;
        t = new Thread(new PlayAnimation());
        t.start();     
      }
    }    
  }

  /**
  * Écouteur du menu Quitter
  * @author CHerby
  */
  class StopAnimationListener  implements ActionListener{

    public void actionPerformed(ActionEvent e) {
      JOptionPane jop = new JOptionPane();     
      int option = jop.showConfirmDialog(null, 
        "Voulez-vous arrêter l'animation ?",
        "Arrêt de l'animation", 
        JOptionPane.YES_NO_CANCEL_OPTION, 
        JOptionPane.QUESTION_MESSAGE);

      if(option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION){
        animated = false;
        //On remplace nos boutons par nos JMenuItem
        lancer.setEnabled(true);
        arreter.setEnabled(false);

        //On ajoute l'instruction pour le menu contextuel
        launch.setEnabled(true);
        stop.setEnabled(false);
      }
    }    
  }  

  class PlayAnimation implements Runnable{
    //Inchangé
  }  

  class FormeListener implements ActionListener{
    //Inchangé    
  }

  class MorphListener implements ActionListener{
    //Inchangé    
  }  
}
