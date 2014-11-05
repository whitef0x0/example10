public class SquareVsRectangle {

	/**
	 * Test the Square and Rectangle classes for correctness. Is Square a
	 * subtype of Rectangle?
	 * 
	 * @param args
	 *            (no arguments needed by main)
	 */
	public static void main(String[] args) {
		
		// let us create a square
		Square s = new Square( 10 );
		
		// let us test the area method
		System.out.println( "The area of the square is " + s.getArea( ) ); // we should see 100
		
		// Square is a subclass of Rectangle, so Java permits the following:
		Rectangle r = new Rectangle(12, 15);
		
		// let us test the area method
		// If r were a rectangle then we should get 180
		// but r is a square and so we will get 225!
		// Our Square class does not behave like a Rectangle!
		System.out.println( "The area of the rectangle is " + r.getArea( ) ); 

	}

}
