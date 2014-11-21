import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * @author Hieu
 *
 */
public class Visualiseur extends JFrame {

	/**
	 * Constructeur par défaut de la classe Visualiseur
	 */
	public Visualiseur() {
		super();
		this.setSize(this.getToolkit().getScreenSize());
		this.setTitle("Traitement des images");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		initComponent();		
	
		
	}
	
	/**
	 * Méthode initComponent():
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
		JMenu outils = new JMenu("Outils");
		JMenu aide = new JMenu("Aide");
		
		JMenuItem ouvrir = new JMenuItem("Ouvrir");
		JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
		JMenuItem quitter = new JMenuItem("Quitter");
		
		JMenuItem copier = new JMenuItem("Copier");
		JMenuItem coller = new JMenuItem("Coller");
		JMenuItem test = new JMenuItem("Test");
		
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
		edition.addSeparator();
		outils = new JMenu("Outils");
		outils.add(choix1);
		outils.add(choix2);
		edition.add(outils);
		
		aide.setMnemonic('A');
		aide.add(apropos);
		apropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane jop = new JOptionPane();
				ImageIcon img = new ImageIcon("C:/Users/Hieu/Desktop/Images/future3.png");
				String mess = "Merci d'avoir utilisé notre application !\n";
				mess += "J'espère que vous avez eu de bons moments ^^ \n";
				jop.showMessageDialog(null, mess, "À Propos", JOptionPane.INFORMATION_MESSAGE, img);
			}
		});		
		
		mb.add(fichier);
		mb.add(edition);
		mb.add(aide);
		
		this.setJMenuBar(mb);
		this.setVisible(true);
		this.add(tb, BorderLayout.NORTH);
		
		ouvrir.addActionListener(new BoutonOuvrirAction());	
		sauvegarder.addActionListener(new BoutonSauvegarderAction());
		

		
	}	
	
	class BoutonOuvrirAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// k cần getDource() (trả về objet của control) 
			JFileChooser file = new JFileChooser();
			int returnVal = file.showOpenDialog(Visualiseur.this);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				File f = file.getSelectedFile();
			}
		}
	}
	
	class BoutonSauvegarderAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			JFileChooser file = new JFileChooser();
			int returnVal = file.showSaveDialog(Visualiseur.this);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Visualiseur visu = new Visualiseur();
		/**
		 * cố gắng mỗi lần thêm  plugin mới thì tự động menu hiện plugin đó lên, k cần vào main chỉnh sửa
		 * => vấn đề thiết kế class
		 */
	}

}
