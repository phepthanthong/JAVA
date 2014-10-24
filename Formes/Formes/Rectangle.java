import java.awt.Graphics;


public class Rectangle implements Forme{

	protected int m_x;
	protected int m_y;
	protected int m_d;
	protected int m_r;
	
	public Rectangle( int x, int y, int d, int r )
	{
		m_x = x;
		m_y = y;
		m_r = r;
		m_d = d;
	}
	
	public void redessiner(Graphics g) {
		g.drawRect(m_x, m_y, m_d, m_r);
	}
}
