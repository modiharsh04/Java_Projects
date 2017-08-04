public class FactoryPatternDemo {
	//main method
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		FactoryPattern f = new FactoryPattern(factory.getShape("Line"),factory.getShape("Rectangle"), factory.getShape("Oval"));
		f.startApp();
	}
}