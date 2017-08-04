import java.awt.Color;

public class Oval extends MyBoundedShape{		//Oval class implementing two interfaces shape and printable
	
	//variable declaration
	float perimeter, area;
	
	//Oval constructor
	public Oval(int x, int y,int width,int height, Color color) {
		super(x, y, width, height, color);			//calling super constructer
		this.perimeter = (float) (2*Math.PI*Math.sqrt((Math.pow(width, 2)+Math.pow(height, 2))/2));
		this.area = (float) Math.PI*super.x1*super.x2;
	}
	
	//overridden method from interface Printable that returns the value of Oval area
	@Override
	public float getArea(){
		return this.area;
	}
	
	//overridden method from interface Shape that draw the object
	@Override
	public void print() {
		System.out.printf("\033[1mOVAL : \033[0m");
		super.print();
		System.out.println(", perimeter="+perimeter+", \033[31marea\033[0m="+area);
	}
}
