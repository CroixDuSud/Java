import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel
{
	public void paintComponent(Graphics g)
	{
		//super.paintComponent(g);
		g.drawLine(15,10,100,50);
                g.drawString("Super texte ici",150,150);
	}	
}