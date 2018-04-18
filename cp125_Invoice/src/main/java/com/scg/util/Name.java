package com.scg.util;

/**
 * Encapsulates the first, middle and last name of a person.
 * 
 * @author chq-alexs
 *
 */
public class Name {
	private static final int HASH_FACTOR = 37;
	private Integer hashCode;
	private int hash;
	private String lastName;
	private String middleName;
	private String firstName;

	/**
	 * Creates a new instance of Name
	 * 
	 */
	public Name() {

	}

	/**
	 * Construct a Name.
	 * 
	 * @param lastName
	 *            - Value for the last name.
	 * @param firstName
	 *            - Value for the first name.
	 */
	public Name(String lastName, String firstName) {
		setLastName(lastName);
		setFirstName(firstName);
		setMiddleName("NMN");
	}

	/**
	 * Construct a Name.
	 * 
	 * @param lastName
	 *            - Value for the last name.
	 * @param firstName
	 *            - Value for the first name.
	 * @param middleName
	 *            - Value for the middle name.
	 */
	public Name(String lastName, String firstName, String middleName) {
		setLastName(lastName);
		setFirstName(firstName);
		setMiddleName(middleName);

		// this.hash = calcHashCode();
	}

	/**
	 * Getter for property firstName.
	 * 
	 * @return Value of property firstName.
	 * 
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Setter for property first.
	 * 
	 * @param firstName
	 *            - New value of property firstName.
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for property lastName.
	 * 
	 * @return Value of property lastName.
	 * 
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Setter for property lastName.
	 * 
	 * @param lastName
	 *            - New value of property lastName.
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for property middleName.
	 * 
	 * @return Value of property middleName.
	 * 
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	/**
	 * Setter for property middleName.
	 * 
	 * @param middleName
	 *            - New value of property middleName.
	 * 
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		if (hashCode == null) {
			int result = Address.class.hashCode();
			result = HASH_FACTOR * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
			result = HASH_FACTOR * result + ((this.middleName == null) ? 0 : this.middleName.hashCode());
			result = HASH_FACTOR * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
			hashCode = result;
		}
		return hashCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/*
	 * public boolean equals(Object other) {
	 * 
	 * boolean equals = false;
	 * 
	 * if (hashCode() == other.hashCode()) { equals = true; }
	 * 
	 * return equals;
	 * 
	 * }
	 */

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
		final Name other = (Name) obj;
		if (this.firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!this.firstName.equals(other.firstName)) {
			return false;
		}
		if (this.middleName == null) {
			if (other.middleName != null) {
				return false;
			}
		} else if (!this.middleName.equals(other.middleName)) {
			return false;
		}
		if (this.lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!this.lastName.equals(other.lastName)) {
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

		// Add String builder
		/*
		 * StringBuilder name = new StringBuilder(); name.append(this.lastName);
		 * name.append(","); name.append(" "); name.append(this.middleName);
		 */
		String out = this.lastName + ", " + this.firstName + " " + this.middleName;
		return out;
		// return name.toString();

	}

}
