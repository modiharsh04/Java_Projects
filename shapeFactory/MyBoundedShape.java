import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape implements Shape, Printable {		// class for shape that are bounded
	
	//variable declaration
	Color color;
	int x1,y1,x2,y2,width,height;
	
	//constructer
	public MyBoundedShape(int x, int y,int width,int height, Color color) {
		this.x1=x;
		this.y1=y;
		this.x2= x+width;
		this.y2=y+height;
		this.width = width;
		this.height=height;
		this.color=color;
	}
	
	//draw method implemented from interface shape
	@Override
	public void draw(Graphics g) {
		if(this instanceof Rectangle){
			g.fillRect(x1, y1, width, height);
		}else{
			g.fillOval(x1, y1, width, height);
		}
		g.setColor(color);
	}

	//print method implemnted from interface printable
	@Override
	public void print() {
		System.out.printf("x1="+x1+", y1="+y1+", x2="+x2+", y2="+y2+", color="+"<"+color.getRed()+","+color.getGreen()+","+color.getBlue()+">");
	}
}
