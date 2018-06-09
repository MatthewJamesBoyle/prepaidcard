package boylem.matt.transaction.domain;

/**
 * Accoount bean. Maps from account service entity.
 * 
 * @author Matt Boyle
 *
 */
public class Account {

	/**
	 * Account id.
	 */
	Long id;

	/**
	 * first name of account holder.
	 */
	String firstName;

	/**
	 * Last name of account holder.
	 */
	String lastName;

	/**
	 * Account balance.
	 */
	Long balance;

	/**
	 * Available balance for account.
	 */
	Long availableBalance;

	/**
	 * Empty contrcutor for Account.
	 */
	protected Account() {

	}

	/**
	 * Constructor for Account.
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param balance
	 * @param availableBalance
	 */
	public Account(Long id, String firstName, String lastName, Long balance, Long availableBalance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.availableBalance = 0L;
	}

	/**
	 * get id
	 * 
	 * @return Long id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * set id
	 * 
	 * @param id
	 *            Long id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get firstName
	 * 
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set firstName
	 * 
	 * @param firstName
	 *            String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get lastName
	 * 
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set lastName.
	 * 
	 * @param lastName
	 *            Strings
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * get balance
	 * 
	 * @return Long
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * set balance
	 * 
	 * @param balance
	 *            Long
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	/**
	 * get availableBalance
	 * 
	 * @return Long
	 */
	public Long getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * set availableBalance
	 * 
	 * @param availableBalance
	 *            Long
	 */
	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * @override toString method.
	 */
	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", balance=" + balance
				+ ", availableBalance=" + availableBalance + "]";
	}

}
