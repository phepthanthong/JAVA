import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Created on 6 sept. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * Cette classe mod�lise une application graphique de visualisation
 * de formes. Elle d�rive de JFrame, qui est une fen�tre SWING "light".
 * 
 * @author lachaud
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class VisualiseurDeFormes extends JFrame 
{
	/**
	 * R�f�rence l'objet servant � g�n�rer des nombres al�atoires.
	 */
	private Random m_random;
	
	/**
	 * R�f�rence la liste des formes � dessiner.
	 */
	private Vector m_formes;
	
	/**
	 * R�f�rence l'objet o� les formes se dessinent.
	 */
	private ZoneDeDessin m_panneau_dessin;
	
	/**
	 * R�f�rence l'objet o� sont plac�s les boutons.
	 */
	private JPanel m_panneau_boutons;
	
	/**
	 * Cette classe mod�lise la r�action de cr�ation d'un cercle suite
	 * � un clic sur un bouton. C'est une classe interne � 
	 * VisualiseurDeFormes.
	 * 
	 * @author lachaud
	 *
	 * To change the template for this generated type comment go to
	 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
	 */
	class BoutonCercleAction implements ActionListener
	{
		/**
		 * R�f�rence l'application qui a cr�� ce bouton.
		 */
		private VisualiseurDeFormes m_visualiseur;
		
		/**
		 * Constructeur.
		 * @param visu est l'application reli� � ce bouton.
		 */
		BoutonCercleAction( VisualiseurDeFormes visu )
		{
			m_visualiseur = visu;
		 }
		 
		/**
		 * Cr�e un nouveau cercle de coordonn�es et rayon al�atoire.
		 * suite � l'action [e].
		 * 
		 * @param e l'action qui a d�clench�e l'appel � cette m�thode.
		 */
		public void actionPerformed( ActionEvent e)
		{
			Random r = m_visualiseur.getRandom();
			Cercle c = new Cercle(
				r.nextInt( 200 ),
				r.nextInt( 200 ),
			    r.nextInt( 40 )+ 20 );
			m_visualiseur.getFormes().add( c );
			m_visualiseur.repaint();
		}
	}
	
	class BoutonRectangleAction implements ActionListener
	{
		/**
		 * R�f�rence l'application qui a cr�� ce bouton.
		 */
		private VisualiseurDeFormes m_visualiseur;
		
		/**
		 * Constructeur.
		 * @param visu est l'application reli� � ce bouton.
		 */
		BoutonRectangleAction( VisualiseurDeFormes visu )
		{
			m_visualiseur = visu;
		 }
		 
		/**
		 * Cr�e un nouveau cercle de coordonn�es et rayon al�atoire.
		 * suite � l'action [e].
		 * 
		 * @param e l'action qui a d�clench�e l'appel � cette m�thode.
		 */
		public void actionPerformed( ActionEvent e)
		{
			Random r = m_visualiseur.getRandom();
			Rectangle o = new Rectangle(r.nextInt(300),r.nextInt(300),r.nextInt(100)+20,r.nextInt(100)+20);
						
			m_visualiseur.getFormes().add(o);
			m_visualiseur.repaint();
			
			//m_formes.clear();
		}
	}
	public static String str= "prem";
	/**
	 * Constructeur par d�faut. 
	 * Cr�e une fen�tre avec un nom, une zone de dessin 
	 * et une zone pour placer des boutons.
	 */
	public VisualiseurDeFormes()
	{
		super( str );
		//nbrFenetre++;
		//String str;
		switch (str){
		case ("prem"):
		str = "deux";	
		break;
		case ("deux"):
			str = "trois";
		break;
		default:
			str = " mmm";
			break;
		}
		
		m_formes = new Vector();
		m_random = new Random();
		setPreferredSize( new Dimension( 400, 300 ) );
		setLayout( new BorderLayout() );
		m_panneau_dessin = new ZoneDeDessin();
		m_panneau_dessin.setFormes( m_formes );
		m_panneau_boutons = new JPanel();
		JLabel label = new JLabel("Visualiseur de Formes");
		getContentPane().add( label, BorderLayout.NORTH );
		getContentPane().add( m_panneau_boutons, BorderLayout.SOUTH );
		getContentPane().add( m_panneau_dessin, BorderLayout.CENTER );
		
		BoutonCercleAction action_cercle = new BoutonCercleAction( this );
		JButton b1 = new JButton( "Cercle" );
		b1.addActionListener( action_cercle );
		m_panneau_boutons.add( b1 );
		
		BoutonRectangleAction action_rectangle = new BoutonRectangleAction(this);
		JButton b2 = new JButton("Rectangle");
		b2.addActionListener(action_rectangle);
		m_panneau_boutons.add( b2 );
		
		JButton b3 = new JButton("Reset");
		
		// Indique ce qu'il faut faire si on clic sur "fermer la fenetre".
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public VisualiseurDeFormes(String str)
	{
		super();
		m_formes = new Vector();
		m_random = new Random();
		setPreferredSize( new Dimension( 400, 300 ) );
		setLayout( new BorderLayout() );
		m_panneau_dessin = new ZoneDeDessin();
		m_panneau_dessin.setFormes( m_formes );
		m_panneau_boutons = new JPanel();
		JLabel label = new JLabel("Visualiseur de Formes");
		getContentPane().add( label, BorderLayout.NORTH );
		getContentPane().add( m_panneau_boutons, BorderLayout.SOUTH );
		getContentPane().add( m_panneau_dessin, BorderLayout.CENTER );
		BoutonCercleAction action_cercle 
			= new BoutonCercleAction( this );
		JButton b1 = new JButton( "Cercle" );
		b1.addActionListener( action_cercle );
		m_panneau_boutons.add( b1 );
		
		// Indique ce qu'il faut faire si on clic sur "fermer la fenetre".
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Cr�e une application "Visualiseur de Formes".
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VisualiseurDeFormes visu = new VisualiseurDeFormes();
		
		//Display the window.
		visu.pack();
		visu.setVisible(true);
		
				
	}
	
	/**
	 * @return le vecteur des formes
	 */
	public Vector getFormes() {
		return m_formes;
	}

	/**
	 * @return l'objet permettant de g�n�rer des nombres al�artoires.
	 */
	public Random getRandom() {
		return m_random;
	}

}
