package fr.fms.graphic;
//import java.awt.Point;


public class Shape extends Point{
	private Point center;
	
	public Shape(int x, int y) {
		this.center = new Point(x, y);
	}
	
	public Shape(Point center) {
		this.center = new Point();
	}
	public Shape() {
	}

	@Override
	public String toString() {
		return "Shape [center = " + center + "]";
	}
}
