package com.scg.domain;

import com.scg.util.Address;
import com.scg.util.Name;

/**
 * Encapsulates the information for a billable client account.
 * 
 * @author chq-alexs
 *
 */
public final class ClientAccount implements Account {

	/**
	 * contact - Name of the contact person for this client.
	 */
	private Name contact;

	/**
	 * name - String with the name of the client.
	 */
	private final String name;

	/**
	 * address - Address of this client.
	 */
	private Address address;

	/**
	 * Creates a new instance of ClientAccount.
	 * 
	 * @param string
	 *            client company name.
	 * @param name
	 *            client name.
	 * @param address
	 *            Address of this client.
	 */

	public ClientAccount(String name, Name contact, Address address) {

		this.name = name;
		setContact(contact);
		setAddress(address);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.scg.domain.Account#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the contact for this account.
	 * 
	 * @return Value of property contact.
	 * 
	 */
	public Name getContact() {
		return this.contact;
	}

	/**
	 * Setter for property contact.
	 * 
	 * @param contact
	 *            - New value of property contact.
	 */
	public void setContact(Name contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return this.address;
	}

	/**
	 * Setter for property address.
	 * 
	 * @param address
	 *            - New value of property address.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.scg.domain.Account#isBillable()
	 */
	@Override
	public boolean isBillable() {
		return true;
	}

	public String toString() {

		StringBuilder clientAccount = new StringBuilder();
		clientAccount.append(this.name + "\n");
		clientAccount.append(this.address.toString() + "\n");
		clientAccount.append(this.contact.toString() + "\n");

		return clientAccount.toString();

	}

}
