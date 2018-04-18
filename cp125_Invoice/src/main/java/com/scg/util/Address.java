package com.scg.util;

/**
 * A simple mailing address. Does no validity checking for things like valid
 * states or postal codes. Instances of this class are immutable.
 * 
 * @author chq-alexs
 *
 */
public final class Address {
	/** Factor used in calculating hashCode. */
	private static final int HASH_FACTOR = 37;

	private final String streetNumber;
	private final String city;
	private final StateCode state;
	private final String postalCode;

	/** Hash code value. */
	private Integer hashCode;

	/**
	 * Construct an Address.
	 * 
	 * @param streetNumber
	 *            - the street number.
	 * @param city
	 *            - the city.
	 * @param state
	 *            - the state.
	 * @param postalCode
	 *            - the postal code.
	 */
	public Address(String streetNumber, String city, StateCode state, String postalCode) {
		this.streetNumber = streetNumber;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;

	}

	/**
	 * Get the street number number for this address.
	 * 
	 * @return the street number.
	 * 
	 */
	public String getStreetNumber() {
		return this.streetNumber;

	}

	/**
	 * Gets the city for this address.
	 * 
	 * @return the city.
	 */
	public String getCity() {
		return this.city;

	}

	/**
	 * Get the state for this address.
	 * 
	 * @return the state.
	 */
	public StateCode getState() {

		return this.state;

	}

	/**
	 * Gets the postal code for this address.
	 * 
	 * @return the postal code.
	 */
	public String getPostalCode() {
		return this.postalCode;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		if (hashCode == null) {
			int result = Address.class.hashCode();
			result = HASH_FACTOR * result + ((city == null) ? 0 : city.hashCode());
			result = HASH_FACTOR * result + ((postalCode == null) ? 0 : postalCode.hashCode());
			result = HASH_FACTOR * result + ((state == null) ? 0 : state.hashCode());
			result = HASH_FACTOR * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
			hashCode = result;
		}
		return hashCode;
	}

	/**
	 * Compares two Address object for value equality.
	 *
	 * @param obj
	 *            the object to compare to the object
	 *
	 * @return true if all fields are equal
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Address other = (Address) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (postalCode == null) {
			if (other.postalCode != null) {
				return false;
			}
		} else if (!postalCode.equals(other.postalCode)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (streetNumber == null) {
			if (other.streetNumber != null) {
				return false;
			}
		} else if (!streetNumber.equals(other.streetNumber)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		StringBuilder addressString = new StringBuilder();
		addressString.append(getStreetNumber() + "\n");
		addressString.append(getCity() + ", " + getState().name() + " " + getPostalCode());

		return addressString.toString();

	}

}
