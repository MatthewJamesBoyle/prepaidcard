package boylem.matt.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
/**
 * Account entity.
 * 
 * @author Matt Boyle.
 *
 */
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * id of Account.
	 */
	Long id;

	@Column
	@NotNull(message = "You must provide your first name")
	/**
	 * Customer first name. cannot be null.
	 */
	String firstName;

	@NotNull(message = "You must provide your last name")
	/**
	 * Customer last name. Cannot be null.
	 */
	String lastName;

	@Column
	@NotNull(message = "You must provide an opening balance")
	/**
	 * Balance of account. Cannot be null.
	 */
	Long balance;

	@Column
	/**
	 * Available balance.
	 */
	Long availableBalance;

	/**
	 * Empty constructor. Keep for Spring.
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
	 * get id.
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
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get first name;
	 * 
	 * @return String firstName;
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set first name
	 * 
	 * @param firstName.
	 *            String firstNames
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get lastName;
	 * 
	 * @return String lastName;
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set lastName
	 * 
	 * @param lastName.
	 *            String lastName;
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getBalance.
	 * 
	 * @return Long balance.
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * set balance.
	 * 
	 * @param balance.
	 *            Long balance.
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	/**
	 * get availableBalance.
	 * 
	 * @return Long availableBalance.
	 */
	public Long getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * set availableBalance.
	 * 
	 * @param availableBalance.
	 *            Long availableBalance.
	 */
	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * @override. toString method.
	 */
	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", balance=" + balance
				+ ", availableBalance=" + availableBalance + "]";
	}

}
