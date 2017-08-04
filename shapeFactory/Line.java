import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape, Printable{   //Line class implementing two interfaces shape and printable
	
	//variable declaration
	int x1,x2,y1,y2,length,slope;
	private Color color;
	
	//Line constructor
	public Line(int x1,int y1,int x2, int y2,Color color) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.color = color;
		this.length = (int) Math.sqrt((Math.pow(x2-x1, 2))+(Math.pow(y2-y1, 2))); 
		this.slope = (int) ((y2-y1)/(x2-x1));
	}
	
	//Overridden method from interface Printable that prints the information about object
	@Override
	public void print() {
		System.out.println("\033[1mLINE :\033[0m x1="+x1+", y1="+y1+", x2="+x2+", y2="+",\033[31m length\033[0m="+length+", slope="+slope+", color = "+"<"+color.getRed()+","+color.getGreen()+","+color.getBlue()+">");
	}
	
	//overridden method from interface Printable that returns the value of Line length
	@Override
	public float getArea(){
		return this.length;
			
	}
		
	//overridden method from interface Shape that draw the object
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}
}