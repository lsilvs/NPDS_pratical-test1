// Required imports
import Fundraising.*;
import org.omg.CORBA.*;
import java.io.*;

public class CharityClient {
	public static void main(String args[]) {
		try {

			//Initialize the ORB
			ORB orb = ORB.init(args, null);
			//Read the object Reference for the CharityServant
			BufferedReader br = new BufferedReader(new FileReader("CharityIOR"));
			String ior = br.readLine();
			//Convert the string object reference to an object
			org.omg.CORBA.Object obj = orb.string_to_object(ior);
			//Convert the object to the correct type i.e. Charity
			Charity charityRef = CharityHelper.narrow(obj);

			//Shows options to user
			System.out.println("Choose one of the following options:");
			System.out.println("1 for Donate money");
			System.out.println("2 for Get total amount raised");
			System.out.println("3 for Get number of donors");
			System.out.println("4 for Returns average amount of money per donor");
			System.out.println("9 for Exit");

			Console console = System.console(); // Initialize console to get user option
			int input = 0; // Initialize var
			String inputStr; // Initialize var

			// Iterate while user do not select exit option (9)
			while	(input != 9) {
				// Ask user for option
				inputStr = console.readLine("Enter input:");
				input = Integer.parseInt(inputStr.trim());

				switch (input){
	        case 1: // Option for donate
	        	String strAmount = console.readLine("Amount:");
	        	float amount = Float.parseFloat(strAmount);
	        	charityRef.donateMoney(amount);
	        	break;
	        case 2: // Option for get total amount
	        	float totalAmount = charityRef.getTotalAmountRaised();
	        	System.out.println("Total amount: " + totalAmount);
	        	break;
	        case 3:  // Option for get number of donors
	        	int numberOfDonors = charityRef.getNumberOfDonors();
	        	System.out.println("Total of donors: " + numberOfDonors);
	        	break;
	        case 4:  // Option for get avarage
	        	float average = charityRef.averageAmountOfMoneyPerDonor();
	        	System.out.println("Average Amount Of Money Per Donor: " + average);
	        	break;
	        case 9:  // Option to exit
	        	break;
	        default: 
	        	System.out.println("your input is invalid!");
	        	break;
	    	}
			}
		// exit message
		System.out.println("bye!");
		}
		catch(Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}
}