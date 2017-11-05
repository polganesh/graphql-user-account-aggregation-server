package com.gp.graphqlaggregator.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity

public class User implements Serializable {

	private static final long serialVersionUID = -5313172176915186631L;

	@Id
	private int entityid;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String firstname;

	private String lastname;

	private String panid;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="user")
	private List<Account> accounts;

	public User() {
	}

	public int getEntityid() {
		return this.entityid;
	}

	public void setEntityid(int entityid) {
		this.entityid = entityid;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPanid() {
		return this.panid;
	}

	public void setPanid(String panid) {
		this.panid = panid;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setUser(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setUser(null);

		return account;
	}

}