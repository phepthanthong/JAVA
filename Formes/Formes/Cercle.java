import java.awt.Graphics;

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
public class Cercle implements Forme {
	protected int m_x;
	protected int m_y;
	protected int m_r;
	
	public Cercle( int x, int y, int r )
	{
		m_x = x;
		m_y = y;
		m_r = r;
	}
	
	/* (non-Javadoc)
	 * @see Forme#redessiner(java.awt.Graphics)
	 */
	public void redessiner(Graphics g) {
		g.drawOval( m_x - m_r , m_y - m_r,
			2 * m_r, 2 * m_r );
	}

}
