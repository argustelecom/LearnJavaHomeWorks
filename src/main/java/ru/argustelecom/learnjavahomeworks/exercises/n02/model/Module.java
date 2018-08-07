package ru.argustelecom.learnjavahomeworks.exercises.n02.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author v.semchenko
 */
@Entity
@Table(name = "module")
public class Module {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = true)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	private DeveloperTeam team;

	@ManyToMany(mappedBy = "modules", cascade = CascadeType.ALL)
	/*@JoinTable(name = "module_by_customer", joinColumns = @JoinColumn(name = "module_id"),
			inverseJoinColumns=@JoinColumn(name = "customer_id"))*/
	private List<Customer> customers;

	public Module(String name) {
		this.name = name;
		this.customers = new ArrayList<>();
	}

	@Override public String toString() {
		return "Module{" +
				"\nid=" + id +
				",\nname='" + name + '\'' +
				",\nteam=" + team.getName() +
				",\n\ncustomers=" + customers.stream().map(c -> c.getName()).toArray() +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DeveloperTeam getTeam() {
		return team;
	}

	public void setTeam(DeveloperTeam team) {
		this.team = team;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public boolean addCustomer(Customer customer){
		return this.customers.add(customer);
	}

}
