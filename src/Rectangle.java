public class Rectangle {

	private int length;
	private int width;

	/**
	 * Create a rectangle with given dimensions
	 * 
	 * @param l
	 *            the length of the rectangle, l > 0
	 * @param w
	 *            the width of the rectangle, w > 0
	 */
	public Rectangle(int l, int w) {
		if (l > 0)
			length = l;
		else
			length = 0;

		if (w > 0)
			width = w;
		else
			width = 0;

	}

	/**
	 * Set the length of the rectangle
	 * 
	 * @param l
	 *            the new length of the rectangle, l > 0
	 */
	public void setLength(int l) {
		if (l > 0)
			length = l;
	}

	/**
	 * Set the width of the rectangle
	 * 
	 * @param w
	 *            the new width of the rectangle, w > 0
	 */
	public void setWidth(int w) {
		if (w > 0)
			width = w;
	}

	/**
	 * Get the area of the rectangle
	 * 
	 * @return the area of the rectangle
	 */
	public int getArea() {
		return length * width;
	}
}
