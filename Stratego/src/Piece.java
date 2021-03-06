import java.io.*;
/**
 * @author Hieu
 *
 */
public abstract class Piece {
	
	public int _x, _y;
	
	public boolean estRouge;
	
	/**
	 * @return the _x
	 */
	protected final int get_x() {
		return _x;
	}

	/**
	 * @param _x the x to set
	 */
	protected final void set_x(int x) {
		this._x = _x;
	}

	/**
	 * @return the _y
	 */
	protected final int get_y() {
		return _y;
	}

	/**
	 * @param _y the y to set
	 */
	protected final void set_y(int y) {
		this._y = _y;
	}

	/**
	 * @return the estRouge
	 */
	protected final boolean isEstRouge() {
		return estRouge;
	}

	/**
	 * @param estRouge the estRouge to set
	 */
	protected final void setEstRouge(boolean estRouge) {
		this.estRouge = estRouge;
	}

	/**
	 * Constructeur avec parametres de Piece
	 * @param _x
	 * @param _y
	 * @param estRouge
	 */
	public Piece(int _x, int _y, boolean estRouge) {
		super();
		this._x = _x;
		this._y = _y;
		this.estRouge = estRouge;
	}
	
	public final void setPosition(int x, int y)
	{
		this._x = x;
		this._y = y;
	}
	
	public void setCouleur(boolean rouge)
	{
		estRouge = rouge;
	}
}
