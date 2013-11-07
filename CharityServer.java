import Fundraising.*;
import org.omg.CORBA.*;
import java.io.*;


public class CharityServer {
	public static void main(String args[]) {

		try {
			//Initialize the ORB
			ORB orb = ORB.init(args, null);
			//Instantiate the CharityServant on the server
			CharityServant charityRef = new CharityServant();
			//Connect the CharityServant to the orb
			orb.connect(charityRef);
			//Store an object Reference to the CharityServant in a String format
			String ior = orb.object_to_string(charityRef);
			//Write the object reference to the CharityServant to a file called CharityIOR
			FileOutputStream fos = new FileOutputStream("CharityIOR");
			PrintStream ps = new PrintStream(fos);
			ps.print(ior);
			ps.close();

			//Run the orb so that it waits for requests from the client
			orb.run();

		}
		catch(Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}
}
