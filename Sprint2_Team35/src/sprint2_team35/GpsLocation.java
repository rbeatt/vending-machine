package sprint2_team35;

public class GpsLocation {



	public Location currentLocation;
	
	/**
	 * Enumeration for the 4 possible locations
	 */
	public enum Location {
		NothernIreland(1),England(2),Scotland(3),Wales(4);
		
		/**
		 * String array containing the strings for the Enumeration
		 */
		private String locations[] = {"NothernIreland","England","Scotland","Wales"};
		
		private int locationValue;
		Location(int value) {
			locationValue = value;
		}
		public int getValue() {
			return locationValue;
		}
		public String getLocation() {
			return locations[locationValue--];
		}
	}
}
						
