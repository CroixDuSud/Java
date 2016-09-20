/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicstest;

/**
 *
 * @author afpa1800
 */
import javax.swing.*;
import java.awt.*;

public class MyGUI extends JFrame
{
	public MyGUI()
	{
		createGUI();
	}

	public void createGUI()
	{
		this.setTitle("Super interface");
		this.setSize(600,300);
		this.setLocationRelativeTo(null);

		JPanel panel0 = new JPanel();
		panel0.setBackground(Color.ORANGE);

		this.setContentPane(panel0);
		this.setVisible(true);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
}
