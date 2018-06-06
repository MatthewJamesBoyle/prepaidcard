package boylem.matt.account.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@SequenceGenerator(name = "card_number_generator", sequenceName = "card_number_generator", initialValue = 64)
	@GeneratedValue(generator = "card_number_generator")
	private Long cardNumber;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private CardStatus cardStatus;

	protected Card() {
	}

	public Card(Date startDate, Date expiryDate, Long cardNumber, Account account, CardStatus cardStatus) {
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
		this.account = account;
		this.cardStatus = cardStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public CardStatus getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(CardStatus cardStatus) {
		this.cardStatus = cardStatus;
	}

}
