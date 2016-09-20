//import java.awt.*;
import java.awt.event.MouseEvent;


/**
 *
 * @author afpa1800
 */
public class EcouteSouris extends MouseEvent implements MouseListener, MouseMotionListener
{
    public EcouteSouris()
    {
        // ?
    }
    
        
    public void mouseDragged(MouseEvent e)
    {
	System.out.println("mouse dragged");
    }

	
    public void mouseMoved(MouseEvent e)
    {
	System.out.println("mouse moved");

    }

	
    public void mouseClicked(MouseEvent e)
    {
	System.out.println("mouse moved");
    }

	
    public void mouseEntered(MouseEvent e)
    {
	System.out.println(e);
    }

	
    public void mouseExited(MouseEvent e)
    {
	System.out.println(e);
    }

	
    public void mousePressed(MouseEvent e)
    {
	System.out.println("mouse pressed");
    }

	
    public void mouseReleased(MouseEvent e)
    {
	System.out.println("mouse released");
    }

}


