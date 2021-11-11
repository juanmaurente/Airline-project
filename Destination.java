public class Destination {
	
	private String cityName;
	private String cityCode;
	private int flightPrice;
	
	public Destination (String cityName, String cityCode, int flightPrice) {
		this.cityName = cityName;
		this.cityCode = cityCode;
		this.flightPrice = flightPrice;
	}

	public String getcityName() {
		return cityName;
	}
	
	public String getcityCode() {
		return cityCode;
	}

	public int getflightPrice() {
		return flightPrice;
	}

	public String toString() {
		return cityName+cityCode+flightPrice;
		
				
	}
}