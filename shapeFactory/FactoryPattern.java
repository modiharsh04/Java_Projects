import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FactoryPattern extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Set<Shape> shapeSet;
	
	FactoryPattern(Shape[]... shapes){
		shapeSet = new TreeSet<>(new ShapeComparator());
		for (Shape[] s : shapes){
			for (Shape s1 : s){
				shapeSet.add(s1);
			}
		}
		setBackground(Color.WHITE);
	}
	
	protected void startApp() {
		Iterator<Shape> it = shapeSet.iterator();
		while (it.hasNext()){
			Printable p = (Printable) it.next();
			p.print();
		}
		JFrame app = new JFrame("CPSM ASSIGNMENT #3");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(400,400);
		app.add(this);
		app.setVisible(true);
	}

	//default method of Jpanel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapeSet){
			s.draw(g);
		}
	}
}

class ShapeComparator implements Comparator<Shape> {
	public int compare(Shape s1 , Shape s2){
		
		return Math.round(((Printable)s1).getArea() - ((Printable)s2).getArea());
	}
}