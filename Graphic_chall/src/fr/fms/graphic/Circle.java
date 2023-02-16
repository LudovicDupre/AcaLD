package fr.fms.graphic;


public class Circle extends Shape {
	private double radius;
	private int x;
	private int y;
	
	public Circle(double radius,int x,int y) {
		super(x, y);
		setRadius(radius);
	}
	
	public Circle(double radius, Point center) {
		super(center);
		setRadius(radius);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Circle() {
		super(0, 0);
		setRadius(1);
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		if(radius < 0) radius =1;
		else this.radius = radius;
	}
	
	public double area() {
		return Math.PI * this.radius;
	}
	
	public double perimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public String toString() {
		return "Circle : radius=" + radius + super.toString();
	}
}
