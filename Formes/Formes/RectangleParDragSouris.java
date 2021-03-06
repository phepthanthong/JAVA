import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.event.MouseInputAdapter;

/**
 * @author Hieu
 *
 */
public class RectangleParDragSouris extends MouseInputAdapter {
	
	private Point source;
	private Point dest;
	private Vector<Rectangle> v_rectangle;
	private ZoneDeDessin m_visualiseur;
	
	public RectangleParDragSouris (ZoneDeDessin visu)
	{
		m_visualiseur = visu;
		v_rectangle = new Vector<Rectangle>();
	}
	
	public void mousePressed (MouseEvent e)
	{
		source = e.getPoint();
	}

	public void mouseReleased (MouseEvent e)
	{
		if ( !v_rectangle.isEmpty() )
		{
			Rectangle last_r = v_rectangle.lastElement();
			m_visualiseur.getFormes().add(last_r);
			m_visualiseur.repaint();
		}
	}
	
	public void mouseDragged(MouseEvent e)
	{
		if ( !v_rectangle.isEmpty() )
		{
			m_visualiseur.getFormes().remove(v_rectangle.lastElement());
			v_rectangle.remove(v_rectangle.lastElement());
		}
		
		dest = e.getPoint();
		
		int longueur = (int)dest.getX() - (int)source.getX();
		int hauteur = (int)dest.getY() - (int)source.getY();
		
		int x = 0, y = 0;
		
		x = (longueur > 0) ? (int)source.getX() : (int)dest.getX();
		y = (hauteur > 0) ? (int)source.getY() : (int)dest.getY();
		Rectangle rect = new Rectangle (x,y,Math.abs(longueur), Math.abs(hauteur), Color.blue);
		
		m_visualiseur.getFormes().add(rect);
		v_rectangle.add(rect);
		m_visualiseur.repaint();
	}
}