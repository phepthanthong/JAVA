import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Hieu
 *
 */
public class Visualiseur extends JFrame {

	/**
	 * Constructeur par d�faut de la classe Visualiseur
	 */
	public Visualiseur() {
		
		this.setSize(800,500);
		this.setTitle("Traitement des images");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		initComponent();
	}
	
	/**
	 * M�thode initComponent():
	 * Assume la fonction de charger la barre de menu et la barre d'outils
	 */
	public void initComponent()
	{		
		JToolBar tb = new JToolBar();
		
		JButton b1 = new JButton(new ImageIcon("images/Select.png"));
		JButton b2 = new JButton(new ImageIcon("images/Zoom_5442.png"));
		
		tb.add(b1);
		tb.add(b2);
		
		JMenuBar mb = new JMenuBar();	
				
		JMenu fichier = new JMenu("Fichier");
		JMenu edition = new JMenu("Edition");
		JMenu aide = new JMenu("Aide");
		
		JMenuItem ouvrir = new JMenuItem("Ouvrir");
		JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
		JMenuItem quitter = new JMenuItem("Quitter");
		
		JMenuItem copier = new JMenuItem("Copier");
		JMenuItem coller = new JMenuItem("Coller");
		JMenuItem outils = new JMenuItem("Outils");
		
		JMenuItem choix1 = new JMenuItem("Choix 1");
		JMenuItem choix2 = new JMenuItem("Choix 2");
		
		JMenuItem apropos = new JMenuItem("A Propos");
		
		fichier.setMnemonic('F');
		fichier.add(ouvrir);
		fichier.add(sauvegarder);
		fichier.add(quitter);
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		edition.setMnemonic('E');
		edition.add(copier);
		edition.add(coller);
		edition.add(outils);
		
		aide.setMnemonic('A');
		aide.add(apropos);
		apropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane jop = new JOptionPane();
				ImageIcon img = new ImageIcon("C:/Users/Hieu/Desktop/Images/future3.png");
				String mess = "Merci d'avoir utilis� notre application !\n";
				mess += "J'esp�re que vous avez eu de bons moments ^^ \n";
				jop.showMessageDialog(null, mess, "� Propos", JOptionPane.INFORMATION_MESSAGE, img);
			}
		});		
		
		mb.add(fichier);
		mb.add(edition);
		mb.add(aide);
		
		this.setJMenuBar(mb);
		this.setVisible(true);
		this.add(tb, BorderLayout.NORTH);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Visualiseur visu = new Visualiseur();
		
	}

}