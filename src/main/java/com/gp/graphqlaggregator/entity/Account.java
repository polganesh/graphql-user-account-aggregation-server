package com.gp.graphqlaggregator.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="account_id")
	@Id
	private int accountId;

	@Column(name="account_category")
	private String accountCategory;

	@Column(name="account_name")
	private String accountName;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="account_type")
	private String accountType;

	@Column(name="current_market_value")
	private double currentMarketValue;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="entityid")
	private User user;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountCategory() {
		return this.accountCategory;
	}

	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getCurrentMarketValue() {
		return this.currentMarketValue;
	}

	public void setCurrentMarketValue(double currentMarketValue) {
		this.currentMarketValue = currentMarketValue;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}