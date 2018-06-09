package boylem.matt.merchant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
/**
 * Merchant entity
 * 
 * @author Matt Boyle
 *
 */
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * id of Merchant.
	 */
	private Long id;

	@Column
	@NotNull(message = "You must provide a business name")
	/**
	 * name of business.
	 */
	private String name;

	@Column
	@NotNull(message = "You must provide an address")
	/**
	 * address of business.
	 */
	private String address;

	/**
	 * basic constructor. Leave for Spring.
	 */
	protected Merchant() {

	}

	/**
	 * Merchant constructor.
	 * 
	 * @param name
	 *            name of Merchant
	 * @param address
	 *            address of merchant
	 */
	public Merchant(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * get id
	 * 
	 * @return Lond id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * set id
	 * 
	 * @param id.
	 *            Long id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get name
	 * 
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set Name.
	 * 
	 * @param name.
	 *            String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get address.
	 * 
	 * @return String address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set Address.
	 * 
	 * @param address
	 *            String address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
