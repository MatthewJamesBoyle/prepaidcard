package boylem.matt.account.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
/**
 * Card Entity
 * 
 * @author Matt Boyle
 *
 */
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * id for card.
	 */
	private Long id;

	@Column
	@NotNull(message = "You must provide a start date")
	@Temporal(TemporalType.DATE)
	/**
	 * cards start date.
	 */
	private Date startDate;

	@Column
	@NotNull(message = "You must provide a expiry date")
	@Temporal(TemporalType.DATE)
	/**
	 * Card end date.
	 */
	private Date expiryDate;

	@SequenceGenerator(name = "card_number_generator", sequenceName = "card_number_generator", initialValue = 64)
	@GeneratedValue(generator = "card_number_generator")
	/**
	 * Represents a card number.
	 */
	private Long cardNumber;

	@ManyToOne
	@JoinColumn(name = "account_id")
	@NotNull(message = "You must provide an account to connect this card to")
	/**
	 * The account the card is connected to. Many card can belong to one accounts.
	 */
	private Account account;

	@Column
	@NotNull(message = "You must provide a status for the card")
	@Enumerated(EnumType.ORDINAL)
	/**
	 * Status of the card (i.e is it frozen or active?).
	 */
	private CardStatus cardStatus;

	/**
	 * Empty Constructor. Leave this for Spring.
	 */
	protected Card() {
	}

	/**
	 * Card constructor.
	 * 
	 * @param startDate
	 *            Date the Card starts.
	 * @param expiryDate
	 *            Date the card expires.
	 * @param cardNumber
	 *            The card numbers on the front.
	 * @param account
	 *            Account the card belongs to.
	 * @param cardStatus
	 *            Status of the card.
	 */
	public Card(Date startDate, Date expiryDate, Long cardNumber, Account account, CardStatus cardStatus) {
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
		this.account = account;
		this.cardStatus = cardStatus;
	}

	/**
	 * Card Constructor
	 * 
	 * @param id
	 * @param startDate
	 * @param expiryDate
	 * @param cardNumber
	 * @param account
	 * @param cardStatus
	 */
	public Card(Long id, Date startDate, Date expiryDate, Long cardNumber, Account account, CardStatus cardStatus) {
		this.id = id;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.cardNumber = cardNumber;
		this.account = account;
		this.cardStatus = cardStatus;
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
	 * set Id
	 * 
	 * @param id
	 *            Long id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get startDate
	 * 
	 * @return Date startDate.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * set startDate
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get expiryDate
	 * 
	 * @return Date expiryDate.
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * set expiryDate
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * get cardNumber
	 * 
	 * @return Long cardNumber.
	 */
	public Long getCardNumber() {
		return cardNumber;
	}

	/**
	 * set cardNumber
	 * 
	 * @param cardNumber
	 *            Lond cardNumber.
	 */
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * get account
	 * 
	 * @return Account.
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * set Account.
	 * 
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * get cardStatus
	 * 
	 * @return CardStatus
	 */
	public CardStatus getCardStatus() {
		return cardStatus;
	}

	/**
	 * set cardStatus
	 * 
	 * @param cardStatus
	 */
	public void setCardStatus(CardStatus cardStatus) {
		this.cardStatus = cardStatus;
	}

}
