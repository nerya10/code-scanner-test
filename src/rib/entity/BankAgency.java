// Generated by delombok at Wed Jul 19 10:10:00 IDT 2023
package rib.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.Hibernate;

@Entity
@Table(name = "BankAgency")
public class BankAgency {
	@Id
	@Column(name = "No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	@Column(name = "ID")
	private String id;
	@Column(name = "PhoneBankNumber")
	private String phoneBankNumber;
	@Column(name = "OperatingMorningHours")
	private String operatingMorningHours;
	@Column(name = "OperatingAfternoonHours")
	private String operatingAfternoonHours;
	@Column(name = "LunchBreak")
	private String lunchBreak;
	@OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE}, mappedBy = "bankAgency")
	private List<CustomerAdvisors> customerAdvisors;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;

	public BankAgency(String id, String phoneBankNumber, String operatingMorningHours, String operatingAfternoonHours, String lunchBreak, Address address) {
		super();
		this.id = id;
		this.phoneBankNumber = phoneBankNumber;
		this.operatingMorningHours = operatingMorningHours;
		this.operatingAfternoonHours = operatingAfternoonHours;
		this.lunchBreak = lunchBreak;
		this.address = address;
	}

	@Override
	public String toString() {
		String finalString;
		finalString = "\nAgentie bancara " + "\nId: " + id + "\nTelefon: " + phoneBankNumber + "\nProgram\nLuni-Vineri: " + operatingMorningHours + " si " + operatingAfternoonHours + "\nSambata si Duminica: inchis" + "\nPauza de masa: " + lunchBreak + "\n";
		if (Hibernate.isInitialized(this.address) && this.address != null) finalString += "Adresa agentie bancara: " + this.address + "\n";
		return finalString;
	}

	@java.lang.SuppressWarnings("all")
	public int getNo() {
		return this.no;
	}

	@java.lang.SuppressWarnings("all")
	public String getId() {
		return this.id;
	}

	@java.lang.SuppressWarnings("all")
	public String getPhoneBankNumber() {
		return this.phoneBankNumber;
	}

	@java.lang.SuppressWarnings("all")
	public String getOperatingMorningHours() {
		return this.operatingMorningHours;
	}

	@java.lang.SuppressWarnings("all")
	public String getOperatingAfternoonHours() {
		return this.operatingAfternoonHours;
	}

	@java.lang.SuppressWarnings("all")
	public String getLunchBreak() {
		return this.lunchBreak;
	}

	@java.lang.SuppressWarnings("all")
	public List<CustomerAdvisors> getCustomerAdvisors() {
		return this.customerAdvisors;
	}

	@java.lang.SuppressWarnings("all")
	public Address getAddress() {
		return this.address;
	}

	@java.lang.SuppressWarnings("all")
	public void setNo(final int no) {
		this.no = no;
	}

	@java.lang.SuppressWarnings("all")
	public void setId(final String id) {
		this.id = id;
	}

	@java.lang.SuppressWarnings("all")
	public void setPhoneBankNumber(final String phoneBankNumber) {
		this.phoneBankNumber = phoneBankNumber;
	}

	@java.lang.SuppressWarnings("all")
	public void setOperatingMorningHours(final String operatingMorningHours) {
		this.operatingMorningHours = operatingMorningHours;
	}

	@java.lang.SuppressWarnings("all")
	public void setOperatingAfternoonHours(final String operatingAfternoonHours) {
		this.operatingAfternoonHours = operatingAfternoonHours;
	}

	@java.lang.SuppressWarnings("all")
	public void setLunchBreak(final String lunchBreak) {
		this.lunchBreak = lunchBreak;
	}

	@java.lang.SuppressWarnings("all")
	public void setCustomerAdvisors(final List<CustomerAdvisors> customerAdvisors) {
		this.customerAdvisors = customerAdvisors;
	}

	@java.lang.SuppressWarnings("all")
	public void setAddress(final Address address) {
		this.address = address;
	}

	@java.lang.SuppressWarnings("all")
	public BankAgency() {
	}
}
