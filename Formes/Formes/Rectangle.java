import java.awt.*;


public class Rectangle extends FormeColoree {

	protected int m_x;
	protected int m_y;
	protected int m_d;
	protected int m_r;
	
	public Rectangle( int x, int y, int d, int r, Color col )
	{
		m_x = x;
		m_y = y;
		m_r = r;
		m_d = d;
		c = col;
	}
	
	public void redessiner(Graphics g) {
		g.setColor(c);
		g.fillRect(m_x, m_y, m_d, m_r);
	}
}
