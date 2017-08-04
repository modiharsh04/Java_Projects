import java.awt.Color;

public class Rectangle extends MyBoundedShape {				//Rectangle class implementing two interfaces shape and printable
	
	//variable declaration
	float area,perimeter;
	
	//Oval constructor
	public Rectangle(int x, int y,int width,int height, Color color) {
		super(x, y, width, height, color);
		this.area= width*height;
		perimeter = 2*(width+height);
	}
	
	//overridden method from interface Printable that returns the value of Rectangle's area
	@Override 
	public float getArea(){
		return this.area;
	}

	//Overridden method from interface Printable that prints the information about object
	@Override
	public void print() {
		System.out.printf("\033[1mRECTANGLE : \033[0m");
		super.print();
		System.out.println(", perimeter="+perimeter+", \033[31marea\033[0m="+area);
	}
}
