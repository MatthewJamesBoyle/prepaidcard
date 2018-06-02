package boylem.matt.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	@NotNull(message = "You must provide your first name")
	String firstName;

	@NotNull(message = "You must provide your last name")
	String lastName;

	@Column
	@NotNull(message = "You must provide an opening balance")
	Long balance;

	@Column
	Long availableBalance = 0L;

	protected Account() {

	}

	public Account(Long id, String firstName, String lastName, Long balance, Long availableBalance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.availableBalance = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", balance=" + balance
				+ ", availableBalance=" + availableBalance + "]";
	}

}
