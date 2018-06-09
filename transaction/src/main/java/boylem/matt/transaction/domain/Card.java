package boylem.matt.transaction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

/**
 * Card bean that maps to Card Entity of Account service.
 * 
 * @author Matt
 *
 */
public class Card {

	/**
	 * card id.
	 */
	private Long id;

	/**
	 * card start date.
	 */
	private Date startDate;

	/**
	 * card expiry date.
	 */
	private Date expiryDate;

	/**
	 * card number.
	 */
	private Long cardNumber;

	/**
	 * account card belongs to.
	 */
	private Account account;

	/**
	 * status of card. i.e Frozen.
	 */
	private CardStatus cardStatus;

	/**
	 * get id
	 * 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * set Id
	 * 
	 * @param id
	 *            Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get startDate
	 * 
	 * @return Date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * set startDate
	 * 
	 * @param startDate
	 *            Date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get expiryDate
	 * 
	 * @return Date
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * set expiryDate
	 * 
	 * @param expiryDate
	 *            Date
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * get cardNumber
	 * 
	 * @return Long
	 */
	public Long getCardNumber() {
		return cardNumber;
	}

	/**
	 * set cardNumber
	 * 
	 * @param cardNumber
	 *            Long
	 */
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * get account
	 * 
	 * @return Account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * set Account.
	 * 
	 * @param account
	 *            Account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * get cardStatus
	 * 
	 * @return CardStatuss
	 */
	public CardStatus getCardStatus() {
		return cardStatus;
	}

	/**
	 * set cardStatus
	 * 
	 * @param cardStatus
	 *            CardStatus
	 */
	public void setCardStatus(CardStatus cardStatus) {
		this.cardStatus = cardStatus;
	}

	/**
	 * @override toString
	 */
	public String toString() {
		return "Card [id=" + id + ", startDate=" + startDate + ", expiryDate=" + expiryDate + ", cardNumber="
				+ cardNumber + ", account=" + account + ", cardStatus=" + cardStatus + "]";
	}

}
