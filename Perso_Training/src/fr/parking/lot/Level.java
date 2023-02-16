package fr.parking.lot;

import java.util.List;

public class Level {
	public int levelNumber;
	public int rows;
	public List<ParkingSlot> takenSlots;
	public int SLOTS_PER_ROW = 2;

	public ParkingSlot findAvailableSpot() {
		int totalNumbSlots = rows * SLOTS_PER_ROW;
		if(takenSlots.size()>=totalNumbSlots) {
			//park full
			return null;
		} else if (takenSlots.isEmpty()) {
			return new ParkingSlot(0,0,levelNumber);
		} else {
			ParkingSlot lastSpaceOccupied = takenSlots.get(takenSlots.size()-1);
			takenSlots.get(takenSlots.size()-1);
			if (lastSpaceOccupied.col<SLOTS_PER_ROW) {
				return new ParkingSlot(lastSpaceOccupied.row,lastSpaceOccupied.col+1,levelNumber);
			} else  {
				return new ParkingSlot(lastSpaceOccupied.row+1,0,levelNumber);
			}
		}
	}

	public boolean park(Car car) {
		ParkingSlot freeSpace = findAvailableSpot();
		if (freeSpace == null) {
			return false;
		} else {
			freeSpace.park(car);
			takenSlots.add(freeSpace);
			return true;
		}
	}
}
