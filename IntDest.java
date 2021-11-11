
public class IntDest extends Destination {

	private String countryName;
	// Construction of an Array with the Countries available
	public static String countryArray[] = { "USA", "SPAIN", "CANADA", "FRANCE", "GREAT BRITAIN" };

	
	public IntDest(String countryName, String cityName, String cityCode, int flightPrice) {
		super(cityName, cityCode, flightPrice);
		this.countryName = countryName;
	}

	public static IntDest[] getInternationalDestinations() {
		IntDest [] intDestArray = new IntDest[10];
		intDestArray[0]= new IntDest (countryArray[0], "NEW YORK CITY", "NYC", 1257);
		intDestArray[1]= new IntDest (countryArray[0], "LOS ANGELES","LAX",960);
		intDestArray[2]= new IntDest (countryArray[1], "MADRID","MAD",1510);
		intDestArray[3]= new IntDest (countryArray[1], "BARCELONA","BCN",1504);
		intDestArray[4]= new IntDest (countryArray[2], "TORONTO","YTO",1752);
		intDestArray[5]= new IntDest (countryArray[2], "VANCOUVER","YVR",1737);
		intDestArray[6]= new IntDest (countryArray[3], "PARIS","PAR",1521);
		intDestArray[7]= new IntDest (countryArray[3], "MARSEILLE","MRS",2044);
		intDestArray[8]= new IntDest (countryArray[4], "LONDON","LON",1493);
		intDestArray[9]= new IntDest (countryArray[4], "MANCHESTER","MAN",1573);
		return intDestArray;
	}
		
	public String getcountryName() {
		return countryName;
	}
	
	public String toString() {
		return "Country: "+ countryName+"\t"+"City: "+ getcityName()+"("+getcityCode()+")\t "+"Price: $" + getflightPrice();
	}

}
