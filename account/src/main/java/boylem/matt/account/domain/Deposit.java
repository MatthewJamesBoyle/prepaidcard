package boylem.matt.account.domain;

public class Deposit {

	private long accountId;
	private long depositAmount;

	public Deposit() {

	}

	public Deposit(long accountId, long depositAmount) {
		this.accountId = accountId;
		this.depositAmount = depositAmount;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(long depositAmount) {
		this.depositAmount = depositAmount;
	}

	@Override
	public String toString() {
		return "Deposit [accountId=" + accountId + ", depositAmount=" + depositAmount + "]";
	}

}
