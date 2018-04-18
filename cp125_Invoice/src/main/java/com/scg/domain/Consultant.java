package com.scg.domain;

import com.scg.util.Name;

/**
 * 
 * A consultant.
 * 
 * @author chq-alexs
 *
 */
public class Consultant {

	/**
	 * Consultant name.
	 */
	private Name name;

	/**
	 * Creates new consultant.
	 * 
	 * @param name
	 *            name of consultant.
	 */
	public Consultant(Name name) {
		this.name = name;
	}

	/**
	 * Getter for property name.
	 * 
	 * @return Value of property name.
	 */
	public final Name getName() {
		return this.name;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public final String toString() {
		return this.name.toString();
	}

}
