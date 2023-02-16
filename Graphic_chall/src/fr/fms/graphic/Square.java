package fr.fms.graphic;

public class Square extends Shape {
	private int side;

	public Square(int side, int x, int y) {
		super(x, y);
		this.setSide(side);
	}
//	public Square(int side1, int side2, int x,int y) {
//		super(x,y);
//		this.setSide(side2);
//	}

//	public Square(int side, Point center) {
//		super(center);
//		this.setSide(side);
//	}


//	public Square() {
//		
//	}

public Square() {
		super();
	}
	//	public Square() {
//		// TODO Auto-generated constructor stub
//	}
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		if(side < 0){
			side = 1;
		}else{
			this.side = side;
		}
	}

	public double area() {
		return this.side * this.side;
	}

	public double perimeter() {
		return 4 * side;
	}

	@Override
	public String toString() {
		return "Square side : " + side + super.toString();
	}
}
