package boylem.matt.transaction.domain;

/**
 * Bean for Merchant class. Maps to Merchant entity of Merchant service.
 * 
 * @author Matt Boyle
 *
 */
public class Merchant {

	/**
	 * id of Merchant.
	 */
	private Long id;

	/**
	 * get id
	 * 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * set id
	 * 
	 * @param id
	 *            Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
