public class Square extends Rectangle {

	/**
	 * Create a square given the side
	 * 
	 * @param side
	 *            (side > 0)
	 */
	public Square(int side) {
		// call the constructor for the superclass
		// create a rectangle with all sides of equal dimension
		super(side, side);
	}

	/**
	 * Set the length of the square. This method overrides the setLength( int )
	 * method in the superclass. Because this method is for a Square, it also
	 * sets the width appropriately.
	 * 
	 * @param l
	 *            the new length of the square, l > 0
	 */
	public void setLength(int l) {
		setSide( l );
	}

	/**
	 * Set the width of the square. This method overrides the setWidth( int )
	 * method in the superclass. Because this method is for a Square, it also
	 * sets the length appropriately.
	 * 
	 * @param w
	 *            the new width of the square, w > 0
	 */
	public void setWidth(int w) {
		setSide( w );
	}

	// let us add a new method to set the side of the square
	// a subclass can contain more methods than the superclass
	/**
	 * Set the side of the square
	 * 
	 * @param s
	 *            the new side of the square, s > 0
	 */
	public void setSide(int s) {
		if (s > 0) {
			super.setLength(s);
			super.setWidth(s);
		}
	}
}
