import java.awt.*;

/**
 * @author Hieu
 *
 */
public abstract class FormeColoree implements Forme {
	protected Color c;
	
	public abstract void redessiner (Graphics g);

	public void setCouleur (Color co)
	{
		c = co;
	}
}
