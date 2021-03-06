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
		 * Cr�e un nouveau cercle de coordonn�es et rayon al�atoire.
		 * suite � l'action [e].
		 * 
		 * @param e l'action qui a d�clench�e l'appel � cette m�thode.
		 */
		public void actionPerformed( ActionEvent e)
		{
			Random r = getRandom();
			Cercle c = new Cercle(
				r.nextInt( 200 ),
				r.nextInt( 200 ),
			    r.nextInt( 40 )+ 20, Color.pink);
			getFormes().add( c );
			repaint();
		}
	}
	
	class BoutonRectangleAction implements ActionListener
	{
		/**
		 * Cr�e un nouveau rectangle de coordonn�es et rayon al�atoire.
		 * suite � l'action [e].
		 * 
		 * @param e l'action qui a d�clench�e l'appel � cette m�thode.
		 */
		public void actionPerformed( ActionEvent e)
		{
			Random r = getRandom();
			Rectangle o = new Rectangle(r.nextInt(300),r.nextInt(300),r.nextInt(100)+20,r.nextInt(100)+20, Color.yellow);
			getFormes().add(o);
			repaint();			
		}
	}
	
	class BoutonResetAction implements ActionListener
	{
		/**
		 * R�f�rence l'application qui a cr�� ce bouton.
		 */
		private VisualiseurDeFormes m_visualiseur;
		
		/**
		 * Constructeur.
		 * @param visu est l'application reli� � ce bouton.
		 */
		BoutonResetAction( VisualiseurDeFormes visu )
		{
			m_visualiseur = visu;
		 }
		 
		/**
		 * Faire un bouton qui efface toutes les formes lorsqu�on appuie dessus.
		 * 
		 * @param e l'action qui a d�clench�e l'appel � cette m�thode.
		 */
		public void actionPerformed( ActionEvent e)
		{
			m_formes.clear();		
			m_visualiseur.repaint();			
		}
	}
	
	class BoutonAleatoireAction implements ActionListener
	{
		private BoutonRectangleAction br;
		private BoutonCercleAction bc;
		
		 
		/**
		 * Faire un bouton qui efface toutes les formes lorsqu�on appuie dessus.
		 * 
		 * @param e l'action qui a d�clench�e l'appel � cette m�thode.
		 * @param br l'action de dessiner aleatoirement un rectangle
		 * @param bc l'action de dessiner aleatoirement un cercle
		 */
		public void actionPerformed( ActionEvent e )
		{
			Random r = getRandom();
			int alea = r.nextInt(2);
			if (alea == 0)
			{
				br = new BoutonRectangleAction();
				br.actionPerformed(e);
			}
			else 
			{
				bc = new BoutonCercleAction();
				bc.actionPerformed(e);
			}
		}
	}
	
	class BoutonChangerCouleurAction implements ActionListener
	{
		
		public void actionPerformed( ActionEvent e )
		{
			/*Vector <Color> couleur = new Vector<Color>();
			couleur.add(Color.blue);
			couleur.add(Color.green);
			couleur.add(Color.orange);
			couleur.add(Color.pink);
			couleur.add(Color.red);
			
			Random r = getRandom();
			int pos = r.nextInt( couleur.size() ); zAZE
			
			if( !m_formes.isEmpty() )	
				getLastForme().setColour( couleur.elementAt(pos) );
			
			repaint(); */
			if (!m_formes.isEmpty())
			{
				Color col = JColorChooser.showDialog(null,"Choisir une couleur",Color.black);
				if (col != null)
				{
					((Forme)m_formes.lastElement()).setCouleur(col);
				}
			}
			repaint();
			
			
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
		
		m_formes = new Vector<FormeColoree>();
		m_random = new Random();
		setPreferredSize( new Dimension( 700, 500 ) );
		setLayout( new BorderLayout() );
		m_panneau_dessin = new ZoneDeDessin();
		m_panneau_dessin.setFormes( m_formes );
		m_panneau_boutons = new JPanel();
		JLabel label = new JLabel("Visualiseur de Formes");
		getContentPane().add( label, BorderLayout.NORTH );
		getContentPane().add( m_panneau_boutons, BorderLayout.SOUTH );
		getContentPane().add( m_panneau_dessin, BorderLayout.CENTER );
		
		BoutonCercleAction action_cercle = new BoutonCercleAction();
		JButton b1 = new JButton( "Cercle" );
		b1.addActionListener( action_cercle );
		m_panneau_boutons.add( b1 );
		
		BoutonRectangleAction action_rectangle = new BoutonRectangleAction();
		JButton b2 = new JButton("Rectangle");
		b2.addActionListener(action_rectangle);
		m_panneau_boutons.add( b2 );
		
		BoutonResetAction action_reset = new BoutonResetAction(this);
		JButton b3 = new JButton("Reset");
		b3.addActionListener(action_reset);
		m_panneau_boutons.add( b3 );
		
		BoutonAleatoireAction action_alea = new BoutonAleatoireAction();
		JButton b4 = new JButton("Aleatoire");
		b4.addActionListener(action_alea);
		m_panneau_boutons.add( b4 );
		
		BoutonChangerCouleurAction action_changeCouleur = new BoutonChangerCouleurAction();
		JButton b5 = new JButton( "Couleur" );
		b5.addActionListener( action_changeCouleur );
		m_panneau_boutons.add( b5 );
		
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
			= new BoutonCercleAction();
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
	public Vector<FormeColoree> getFormes() {
		return m_formes;
	}

	/**
	 * @return l'objet permettant de g�n�rer des nombres al�artoires.
	 */
	public Random getRandom() {
		return m_random;
	}
	
	public FormeColoree getLastForme()
	{
		if ( !m_formes.isEmpty() )
			return (FormeColoree) m_formes.lastElement();
		else 
			return null;
	}

}
