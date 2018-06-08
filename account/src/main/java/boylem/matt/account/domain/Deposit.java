package boylem.matt.account.domain;

/**
 * Depoit bean.
 * 
 * @author Matt Boyle
 *
 */
public class Deposit {

	/**
	 * id of account.
	 */
	private long accountId;

	/**
	 * amount to deposit.
	 */
	private long depositAmount;

	/**
	 * Empty constructor. Leave for Spring.
	 */
	public Deposit() {

	}

	/**
	 * Constructor for Deposit.
	 * 
	 * @param accountId
	 *            id of account to deposit into.
	 * @param depositAmount
	 *            the amount to deposit.
	 */
	public Deposit(long accountId, long depositAmount) {
		this.accountId = accountId;
		this.depositAmount = depositAmount;
	}

	/**
	 * get accountId
	 * 
	 * @return Long accountId.
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * set AccountId
	 * 
	 * @param accountId
	 */
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	/**
	 * get deposit amount.
	 * 
	 * @return long depositAmount
	 */
	public long getDepositAmount() {
		return depositAmount;
	}

	/**
	 * set the deposit amount.
	 * 
	 * @param depositAmount
	 *            long amount to deposit.
	 */
	public void setDepositAmount(long depositAmount) {
		this.depositAmount = depositAmount;
	}

	/**
	 * @override toString method.
	 */
	public String toString() {
		return "Deposit [accountId=" + accountId + ", depositAmount=" + depositAmount + "]";
	}

}
