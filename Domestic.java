
public class Domestic extends IntDest{

	private static String carSelection = "TOYOTA RAV4";
	private static int carHirePrice = 100;
	
	public Domestic(String cityName, String cityCode, int flightPrice) {
		super("Australia", cityName, cityCode, flightPrice); // As "child" our constructor is asking me for a Country. As this is domestic I set "Australia" as country but I wont use this/
	}
	
	public static Domestic[] getDomesticDestinations() {
		Domestic[] domDestArray = new Domestic[5];
		domDestArray[0] = new Domestic("MELBOURNE", "MEL", 330);
		domDestArray[1] = new Domestic("BRISBANE", "BNE", 202);
		domDestArray[2] = new Domestic("CAIRNS", "CNS", 283);
		domDestArray[3] = new Domestic("PERTH", "PER", 451);
		domDestArray[4] = new Domestic("HOBART", "HBA", 502);
		return domDestArray;
	}
		
	public static String getcarSelection() {
		return carSelection;
	}
	public static int getcarHirePrice() {
		return carHirePrice;
	}
	
		public String toStringWithCAR() {
			return "City: "+ getcityName()+"("+getcityCode()+")\t"+"Price: $" + getflightPrice() + "\n" + "Car Hired: "+ carSelection + "\t" + "Price Car: $" + carHirePrice;
	}
		public String toStringWithoutCAR() {
			return "City: "+ getcityName()+"("+getcityCode()+")\t"+"Price: $" + getflightPrice() + "\n";
	}
}
