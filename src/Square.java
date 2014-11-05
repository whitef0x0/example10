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


}
