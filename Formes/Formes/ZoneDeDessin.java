import java.util.Vector;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Created on 6 sept. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author lachaud
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ZoneDeDessin extends JPanel {
	private Vector<FormeColoree> m_formes;
	private RectangleParDragSouris rect_drag;
	public ZoneDeDessin()
	{
		rect_drag = new RectangleParDragSouris(this);
		addMouseMotionListener(rect_drag);
		addMouseListener(rect_drag);
		
	}
	
	public void setFormes( Vector formes )
	{
		m_formes = formes;
	}
	
	public Vector<FormeColoree> getFormes()
	{
		return m_formes;
	}
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		if ( m_formes != null )
		{
			for ( int i = 0; i < m_formes.size(); i++ )
			{
				FormeColoree f = (FormeColoree) m_formes.get( i );
				f.redessiner( g );
			}
		}
	}
}
