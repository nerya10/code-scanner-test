// Generated by delombok at Wed Jul 19 10:10:00 IDT 2023
package rib.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.Hibernate;

@Entity
@Table(name = "BankAccount")
public class BankAccount {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Username")
	private String username;
	@Column(name = "Password")
	private int password;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Deposit deposit;

	public BankAccount(String username, int password, Deposit deposit) {
		super();
		this.username = username;
		this.password = password;
		this.deposit = deposit;
	}

	@Override
	public String toString() {
		String finalString = "Id cont: " + id + ", nume de utilizator: " + username + ", parola: " + password;
		if (Hibernate.isInitialized(this.deposit) && this.deposit != null) finalString += "\nDepozit: " + this.deposit + "\n";
		 else finalString += "\n";
		return finalString;
	}

	@java.lang.SuppressWarnings("all")
	public int getId() {
		return this.id;
	}

	@java.lang.SuppressWarnings("all")
	public String getUsername() {
		return this.username;
	}

	@java.lang.SuppressWarnings("all")
	public int getPassword() {
		return this.password;
	}

	@java.lang.SuppressWarnings("all")
	public Deposit getDeposit() {
		return this.deposit;
	}

	@java.lang.SuppressWarnings("all")
	public void setId(final int id) {
		this.id = id;
	}

	@java.lang.SuppressWarnings("all")
	public void setUsername(final String username) {
		this.username = username;
	}

	@java.lang.SuppressWarnings("all")
	public void setPassword(final int password) {
		this.password = password;
	}

	@java.lang.SuppressWarnings("all")
	public void setDeposit(final Deposit deposit) {
		this.deposit = deposit;
	}

	@java.lang.SuppressWarnings("all")
	public BankAccount() {
	}
}
