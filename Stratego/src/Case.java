
/**
 * @author Hieu
 *
 */
public abstract class Case {
	
	protected int _x, _y;
	
	protected boolean bonEndroit;

	/**
	 * @return the _x
	 */
	protected final int get_x() {
		return _x;
	}
	
	/**
	 * @return the _y
	 */
	protected final int get_y() {
		return _y;
	}

	/**
	 * @return the bonEndroit
	 */
	protected final boolean isBonEndroit() {
		return bonEndroit;
	}

	/**
	 * @param bonEndroit the bonEndroit to set
	 */
	protected final void setBonEndroit(boolean bonEndroit) {
		this.bonEndroit = bonEndroit;
	}

	/**
	 * Constructeur avec parametres de Case
	 * @param _x
	 * @param _y
	 */
	public Case(int _x, int _y) {
		super();
		this._x = _x;
		this._y = _y;
	}
	
	public void setPiece(Piece p, Plateau pla)
	{
		
	}
	
	
	
}
