Example 10: Squares and Rectangles (or, Why Subclassing is not Subtyping)
=========


In Java, we can create a new class by `extend`ing an existing class. The new class is called a subclass of the original class (which is then called the superclass).

This is one mechanism in Java to create subtypes but subclassing does not ensure that the new class is a subtype of the original class. This example demonstrates how this can happen.

The first class is a `Rectangle`:

```java
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
```

We would now like to create squares and to do so we create the `Square` class as a subclass of `Rectangle` as follows using the `extends` keyword. Notice also that methods in the superclass are called by using the keyword `super`. Similarly the constructor for the superclass is called using `super( … )`. In Java (and other such languages), the constructor for a subclass should begin with a call to the constructor of the superclass and there are some good reasons for this requirement.

```java
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
```

Our mathematical intuition would lead us to believe that all squares are rectangles and therefore `Square` is a subtype of `Rectangle`. However, objects of the class `Square` do not behave like objects of the class `Rectangle`. The ability to substitute a `Square` in the place of a `Rectangle` is requirement for correct subtyping (this is known as the *Liskov Substitution Principle*). 

Our intuition about the mathematical objects Square and Rectangle goes wrong in the example below because the objects are mutable.

```java
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
		Rectangle r = s;
		
		r.setLength( 12 );
		r.setWidth( 15 );
		
		// let us test the area method
		// If r were a rectangle then we should get 180
		// but r is a square and so we will get 225!
		// Our Square class does not behave like a Rectangle!
		System.out.println( "The area of the rectangle is " + r.getArea( ) ); 

	}

}
``` 