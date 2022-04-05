package sprint2_team35;

public class RasberryPi {


	/**
	 * GPS coordinates based on the preselected location by the user
	 */
	private static String[] GPS1 = {"54.7877N", "6.4923W"};
	private static String[] GPS2 = {"52.3555N", "1.1743W"};
	private static String[] GPS3 = {"56.4907N", "4.2026W"};
	private static String[] GPS4 = {"52.1307N", "3.7837W"};
	
	public RasberryPi() {
	
		/**
		 * RasberryPi method
		 */
	}
	
	/**
	 * GPS module method
	 */
	public static String[] GPSModule() {
		
		String[] currentGPSLocation = new String[2];
		
		GpsLocation location = new GpsLocation();
		
		/**
		 * switch statement to find the correct coordinates based on the current location
		 */
		
		switch(location.currentLocation) {
		case NothernIreland:
			currentGPSLocation = GPS1;
				break;
			
		case England:
			currentGPSLocation = GPS2;
				break;
			
		case Scotland:
			currentGPSLocation = GPS3;
				break;
		
		case Wales:
			currentGPSLocation = GPS4;
				break;
		default:
			System.out.println("Error fetching GPS location");
				break;
		}
		
		/**
		 * @return - the current GPS location
		 */
		return currentGPSLocation;


	}
	
	
}
