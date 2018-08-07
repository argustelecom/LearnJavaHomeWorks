package ru.argustelecom.learnjavahomeworks.exercises.n02.model;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * |Имя	            |Тип	|Обяз?	|Откуда данные|
 * ---------------------------------------------------------
 * |Имя	            |Текст	|ДА	    |
 * |Имя в Jira	    |Текст	|ДА	    |
 * |Проект в Jira	|Текст	|НЕТ	|
 * |Продукты	    |список	|НЕТ	|Справочник продуктов|
 *
 * v.semchenko
 */

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "customer_name_in_jira", nullable = false)
	private String nameInJira;

	@Column
	private String nameProjectInJira;

	@ManyToMany(cascade = CascadeType.ALL)
	/*@JoinTable(name = "customers", joinColumns = @JoinColumn(name = "appserver_id"),
			inverseJoinColumns=@JoinColumn(name = "team_id"))*/
	private List<Module> modules;

	@OneToMany(mappedBy = "customer")
	private List<ApplicationServer> appservers;

	public Customer() {
		this.name = "Заказчик_" + id;
		this.nameInJira = "customer_" + id;
		this.nameProjectInJira = "";
		this.modules = new ArrayList<>();
		this.appservers = new ArrayList<>();
	}

	public Customer(String name, String nameInJira, String nameProjectInJira) {
		this.name = name;
		this.nameInJira = nameInJira;
		this.nameProjectInJira = nameProjectInJira;
		this.modules = new ArrayList<>();
		this.appservers = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameInJira() {
		return nameInJira;
	}

	public void setNameInJira(String nameInJira) {
		this.nameInJira = nameInJira;
	}

	public String getNameProjectInJira() {
		return nameProjectInJira;
	}

	public void setNameProjectInJira(String nameProjectInJira) {
		this.nameProjectInJira = nameProjectInJira;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public boolean addModule(Module module) {
		module.addCustomer(this);
		return this.modules.add(module);
	}

	public List<ApplicationServer> getAppservers() {
		return appservers;
	}

	public void setAppservers(
			List<ApplicationServer> appservers) {
		this.appservers = appservers;
	}

	public boolean addAppServer(ApplicationServer appServer) {
		return this.appservers.add(appServer);
	}

	@Override public String toString() {
		return "Customer{" +
				"\nid=" + id +
				", \nname='" + name + '\'' +
				", \nnameInJira='" + nameInJira + '\'' +
				", \nnameProjectInJira='" + nameProjectInJira + '\'' +
				", \nmodules=" + modules.stream().map(m -> m.getName()).toArray() +
				", \nappservers=" + appservers.stream().map(s -> s.getAppServerName()).toArray() +
				'}';
	}
}
