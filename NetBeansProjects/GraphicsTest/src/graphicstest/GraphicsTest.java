package graphicstest;

import javax.swing.*;
import java.awt.*;
        


/**
 *
 * @author afpa1800
 */
//imports



public class GraphicsTest
{
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
    		
    		public void run() {
        
        		MyGUI gInterface = new MyGUI();
    		}
		});
	}
}
