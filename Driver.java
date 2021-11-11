import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Local Variables
		int destinationChoice, countrySelect, citySelect = 0, Total = 0;

		// Array list containing order items the user will be adding
		ArrayList<String> Order = new ArrayList<String>();

		// Construction of our International Destinations within an Array
		IntDest[] intDestArray = IntDest.getInternationalDestinations();

		// Construction of our Domestic Destinations within an Array
		Domestic[] domDestArray = Domestic.getDomesticDestinations();

		// Main menu display case 1 International flights, case 2 Domestic flights, case
		// 3 - exit and print invoice,
		do {
			System.out.println("-------  Home Menu ------");
			System.out.println("1. International Destinations");
			System.out.println("2. Domestic Destinations");
			System.out.println("3. Exit");
			System.out.println("--------------------------");
			System.out.print("Select one option: ");
			destinationChoice = sc.nextInt();
			System.out.println("\n\n\n");

			switch (destinationChoice) {

			case 1: { // SELECTION OF INTERNATIONAL DESTINATIONS
				// COUNTRY SELECTION DISPLAY
				System.out.println(" ------- INTERNATIONAL DESTINATIONS ---------------");
				for (int i = 0; i < (IntDest.countryArray.length); i++) {
					System.out.println(i + 1 + ". " + IntDest.countryArray[i]);
				}
				System.out.println("-----------------------");
				System.out.print("Please, Select Country: ");
				countrySelect = sc.nextInt();

				
			// Display of international flights and Choose cities
				if (countrySelect>0 && countrySelect<=IntDest.countryArray.length)
				{
					String countrySelected = IntDest.countryArray[countrySelect-1];			 /// DISPLAY OF COUNTRIES
					System.out.println("\n\n========="+ countrySelected + "========");		 /// DISPLAY OF COUNTRIES
				
				System.out.println("\tCITY \t\t\t PRICE"); 									
				
					for (int i = 0; i < intDestArray.length ; i++) 									///DISPLAY OF CITIES
					{ 
						if (countrySelected == intDestArray[i].getcountryName()) {
							System.out.println(i+1+". " + intDestArray[i].getcityName() + "(" + intDestArray[i].getcityCode()
									+ ")\t\t$" + intDestArray[i].getflightPrice());
						} else  ;
						
				}
					System.out.println("-----------------------");
					System.out.print("Select the City you want to flight: ");
					citySelect = sc.nextInt();
				}
				
					Total += addInternationalFlightOrder(citySelect, intDestArray, Order); 		//Selection of International flights to the order
				}
			
				break;
			

			case 2: { // SELECTION OF DOMESTIC DESTINATIONS
						// CITY SELECTION DISPLAY
				System.out.println(" ------- DOMESTIC DESTINATIONS ---------------");
				System.out.println("\tCITY \t\t\t PRICE");
				for (int i = 0; i < 5; i++) {
					System.out.println(i + 1 + ". " + domDestArray[i].getcityName() + "\t\t\t$"
							+ domDestArray[i].getflightPrice());
				}
				System.out.println("-----------------------");
				System.out.print("Please, Select City: ");
				citySelect = sc.nextInt();

				// #######################################################################
				// SELECTION OF DOMESTIC DESTINATION

				// 1st City -- MELBOURNE
				if (citySelect == 1) {
					System.out.println("\n\n\n");
					System.out.println("------------ MELBOURNE HAS BEEN SELECTED -----------");
					Total += domDestArray[0].getflightPrice(); // Addition price of the flight to TOTAL ORDER

					// CAR SELECTION method
					Total += getcarSelection(Total, domDestArray, Order, citySelect);

				}

				// 2nd City --- BRISBANE
				else if (citySelect == 2) {
					System.out.println("\n\n\n");
					System.out.println("------------ BRISBANE HAS BEEN SELECTED -----------");
					Total += domDestArray[1].getflightPrice(); // Addition price of the flight to TOTAL ORDER

					Total += getcarSelection(Total, domDestArray, Order, citySelect);
				}

				// 3rd City --- CAIRNS
				else if (citySelect == 3) {
					System.out.println("\n\n\n");
					System.out.println("------------ CAIRNS HAS BEEN SELECTED -----------");
					Total += domDestArray[2].getflightPrice(); // Addition price of the flight to TOTAL ORDER

					Total += getcarSelection(Total, domDestArray, Order, citySelect);
				}

				// 4th City --- PERTH
				else if (citySelect == 4) {
					System.out.println("\n\n\n");
					System.out.println("------------ PERTH HAS BEEN SELECTED -----------");
					Total += domDestArray[3].getflightPrice(); // Addition price of the flight to TOTAL ORDER
					Total += getcarSelection(Total, domDestArray, Order, citySelect);
				}

				// 5th City --- HOBART
				else if (citySelect == 5) {
					System.out.println("\n\n\n");
					System.out.println("------------ HOBART HAS BEEN SELECTED -----------");
					Total += domDestArray[4].getflightPrice(); // Addition price of the flight to TOTAL ORDER

					Total += getcarSelection(Total, domDestArray, Order, citySelect);
				} else {
					System.out.println(
							"***********Wrong Selection. Please Select one Option********************" + "\n\n\n");
				}
				break;
			}

			// finishing application and PRINTING INVOICE
			case 3: {
				System.out.println("Processing your invoice...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n########## INVOICE #########");
				System.out.println("----- BUDGET AIRLINES-----------");
				for (String i : Order)
					System.out.println(i);

				System.out.println("\n-------------------------------");
				System.out.println("Total Due Amount: $" + Total);
				System.out.println("\n-------------------------------");
				System.out.println("\nTHANK YOU FOR CONSIDER US - WITH YOU BUDGET AIRLINES WILL FLY FURTHER");
				break;
			}
			default:
				System.out.println("Wrong Choice");
				break;
			}

		} while (destinationChoice != 3);
		sc.close();
	}

	/// adding selection of international flights to an order
	public static int addInternationalFlightOrder(int citySelect, IntDest[] intDestArray, ArrayList<String> order) {
		
		if (citySelect > 0 && citySelect <= intDestArray.length) {
		
			System.out.println("\n\n\n");
			System.out.println("------------ " + intDestArray[citySelect - 1].getcityName() + " HAS BEEN SELECTED -----------");
			order.add(intDestArray[citySelect - 1].toString());
			System.out.println("\n\n\n");
			return intDestArray[citySelect - 1].getflightPrice();
		} else {
			System.out.println("***********Wrong Selection. Please Insert Correct INPUT" + "\n\n\n");
			return 0;
		}
	}

	private static int getcarSelection(int carSelection, Domestic[] domDestArray, ArrayList<String> order,
			int citySelect) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Would you like to RENT A " + Domestic.getcarSelection() + " FOR JUST $" 
				+ Domestic.getcarHirePrice() + "?\n\nSelect\n0 TO HIRE\n1 to finish: ");
		carSelection = sc.nextInt();

		if (carSelection == 0) {
			System.out.println("Your " + Domestic.getcarSelection() + " has been added to your order");
			order.add(domDestArray[citySelect - 1].toStringWithCAR()); // Addition to Total Order Array 
			return Domestic.getcarHirePrice();

		} else if (carSelection == 1) {
			System.out.println("You did not hire any car");
			order.add(domDestArray[citySelect - 1].toStringWithoutCAR()); // Addition to Total Order Array 

		} else
			System.out.println("*****Wrong Selection. Please Insert Correct INPUT" + "\n\n\n");
		System.out.println("\n\n\n");

		return 0;

	}
}