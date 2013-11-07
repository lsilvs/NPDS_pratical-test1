// Required import
import Fundraising.*;

class CharityServant extends _CharityImplBase {
	
	private float totalAmount;
	private int numberOfDonors;

	// Constructor to set initial values
	public CharityServant() {
		this.totalAmount = 0;
		this.numberOfDonors = 0;
	}

	public void donateMoney(float amount) {
		this.totalAmount = this.totalAmount + amount; // add amount to totalAmount
		this.numberOfDonors++; // increment number of donors
	}

	public float getTotalAmountRaised() {
		return this.totalAmount;
	}

	public int getNumberOfDonors() {
		return this.numberOfDonors;
	}

	public float averageAmountOfMoneyPerDonor() {
		return (this.totalAmount/this.numberOfDonors);
	}
}
