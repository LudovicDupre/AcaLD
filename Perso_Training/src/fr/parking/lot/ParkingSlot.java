package fr.parking.lot;

public class ParkingSlot {

	public int row;
	public int col;
	public int level;
	public Car carOccupySlot;

	public ParkingSlot( int row, int col, int level ) {
		this.row = row;
		this.col = col;
		this.level = level;
	}
	public void park(Car car) {
		this.carOccupySlot = car;
	}
}
