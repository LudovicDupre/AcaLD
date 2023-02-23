package fr.bankSyst;

public class Current extends Account {
	private int overdraft;

	public Current(String accountId, String creationDate, double balance, int overdraft, Client client) {
		super(accountId, balance, creationDate, client);
		this.overdraft = overdraft;
	}

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "Current Account " + super.toString() +  ",\n\t\t overdraft=" + overdraft + "]";
	}
}
