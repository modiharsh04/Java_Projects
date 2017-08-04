import java.awt.Color;
import java.security.SecureRandom;

public class ShapeFactory{			//shapefactory class that notifies which object to be picked
	
	// variable declaration
	private SecureRandom r = new SecureRandom();	
	private Line[] lines;
	private Rectangle[] rects;
	private Oval[] ovals;
	private int[] red = {20,242};
	private int[] green = {120,234};
	private int[] blue = {89,245};
	
	//get shape method to determine which shape object to be create from string input
	Shape[] getShape(String shapeType){
		if(shapeType==null){	//no object is called
				return null;
		} else if(shapeType.equalsIgnoreCase("LINE")){			//if line object is called
			lines = new Line[5 + r.nextInt(5)];
			
			System.out.println("\u001B[1mLines Colors:\033[0m");

			//for loop for creating random number of line objects
			for(int c=0;c<lines.length;c++){
				int x1 = r.nextInt(300);
				int x2 = r.nextInt(300);
				int y1 = r.nextInt(300);
				int y2 = r.nextInt(300);
				Color color = new Color(r.nextInt(red[1]-red[0])+red[0],r.nextInt(green[1]-green[0])+green[0],r.nextInt(blue[1]-blue[0])+blue[0]);
				System.out.println("<"+color.getRed()+","+color.getGreen()+","+color.getBlue()+">");	
				lines[c] = new Line(x1, y1, x2, y2, color);
			}
			return (Shape[]) lines;
		}
		else if(shapeType.equalsIgnoreCase("RECTANGLE")){		//if rectangle object is called
			rects = new Rectangle[5 + r.nextInt(5)];
			System.out.println("\033[1mRect colos:\033[0m");
			//for loop for creating random number of rectangle objects
			for(int c=0;c< rects.length;c++){
				int x1 = r.nextInt(300);
				int y1 = r.nextInt(300);
				int width = r.nextInt(80);
				int height = r.nextInt(80);
				Color color = new Color(r.nextInt(red[1]-red[0])+red[0],r.nextInt(green[1]-green[0])+green[0],r.nextInt(blue[1]-blue[0])+blue[0]);
				System.out.println("<"+color.getRed()+","+color.getGreen()+","+color.getBlue()+">");
				rects[c] = new Rectangle(x1, y1, width, height, color);
			}
			return (Shape[]) rects;
		}
		else if(shapeType.equalsIgnoreCase("Oval")){			//if oval method is called
			ovals = new Oval[5 + r.nextInt(5)];
			System.out.println("\033[1mOval colors\033[0m");
			//for loop for creating random number of oval objects
			for(int c=0;c< ovals.length;c++){
				int x1 = r.nextInt(300);
				int y1 = r.nextInt(300);
				int width = r.nextInt(80);
				int height = r.nextInt(80);
				Color color = new Color(r.nextInt(red[1]-red[0])+red[0],r.nextInt(green[1]-green[0])+green[0],r.nextInt(blue[1]-blue[0])+blue[0]);
				System.out.println("<"+color.getRed()+","+color.getGreen()+","+color.getBlue()+">");
				ovals[c] = new Oval(x1, y1, width, height, color);
			}
			return (Shape[]) ovals;
		}
		
		return null;
	}
}

