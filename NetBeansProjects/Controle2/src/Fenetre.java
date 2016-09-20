import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;


/**
 *
 * @author afpa1800
 */
public class Fenetre extends JFrame implements ActionListener
{
    private JPanel mPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane;
    private JSpinner spinner;
    private SpinnerNumberModel snm;
    private JLabel spinnerLabel;

    public Fenetre(String s)
    {
    	super(s);
    	addWindowListener(new EcouteFenetre());
    	

    	// MAIN PANEL

    	mPanel = new JPanel();
    	mPanel.setBackground(Color.CYAN);
    	mPanel.setLayout(new GridLayout(4,1));
        mPanel.setPreferredSize(new Dimension(400,300));

    	// PANEL 1

    	panel1 = new JPanel();
    	panel1.setLayout(new FlowLayoutMG());
    	panel1.setBackground(Color.WHITE);
        //panel1.setSize(600,600);
    	snm = new SpinnerNumberModel(
                new Integer(5),
                new Integer(1),
                new Integer(10),
                new Integer(1));
        
        spinner = new JSpinner(snm);
        
    	spinner.addChangeListener(new SpinnerListener());
    	spinnerLabel = new JLabel("Nombre de JCheckBox a creer : ");
    	spinnerLabel.setForeground(Color.BLACK);

    	panel1.add(spinner);
    	panel1.add(spinnerLabel);

    	// PANEL 2

    	panel2 = new JPanel();
    	panel2.setLayout(new FlowLayoutMG());
    	panel2.setBackground(Color.WHITE);
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	button1 = new JButton("EXECUTER");
    	button1.addActionListener(this);

    	panel2.add(button1);

    	// PANEL 3

    	panel3 = new JPanel();
    	panel3.setLayout(new FlowLayoutMG());
    	panel3.setBackground(Color.WHITE);
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	// gestion checkBox

    	// PANEL 4

    	panel4 = new JPanel();
    	panel4.setLayout(new FlowLayoutMG());
    	panel4.setBackground(Color.WHITE);
        panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	button2 = new JButton("ETAT");
    	button2.addActionListener(this);

    	panel4.add(button2);

    	// Finalisation de la fenetre principale

    	mPanel.add(panel1);
    	mPanel.add(panel2);
    	mPanel.add(panel3);
    	mPanel.add(panel4);

    	// Placement du panneau principal dans la zone de contenu de la fenetre

    	getContentPane().add(mPanel);

    	setVisible(true);
        setLocationRelativeTo(null);
    	pack();


    }
    
    public void actionPerformed(ActionEvent e)
    {
    	// Action du bouton 1

    	JButton source = (JButton)e.getSource();

    	JSpinner source2 = (JSpinner)e.getSource();

    	Integer currentSpinnerValue = (Integer)source2.getValue();

    	JCheckBox cb;

    	if(source == button1)
    	{
    		// TODO code bouton 1
    	}

    	if(source == button2)
    	{
    		// TODO code bouton 2
    	}

    	if(source2 == spinner)
    	{
    		for(int i = 0; i <= currentSpinnerValue; i++)
    		{
                    cb = new JCheckBox("Case " + i);
    		}
    	}
    }
}
