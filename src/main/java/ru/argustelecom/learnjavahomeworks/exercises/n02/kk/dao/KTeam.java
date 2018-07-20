package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author k.koropovskiy
 */
@Entity
public class KTeam {
	@Id
	@GeneratedValue
	@Getter @Setter
	private int id;

	@Column
	@Getter @Setter
	private String name;

	@Column
	@Getter @Setter
	private String jiraComponent;

	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@JoinTable(name = "team_teammate",
			joinColumns = @JoinColumn(name = "team_id"),
			inverseJoinColumns = @JoinColumn(name = "teammate_id"))
	private List<KTeammate> teammates;

	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@JoinTable(name = "team_product",
			joinColumns = @JoinColumn(name = "team_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<KProduct> products;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "team_appserver",
			joinColumns = @JoinColumn(name = "team_id"),
			inverseJoinColumns = @JoinColumn(name = "asi_id"))
	@Getter @Setter
	private Collection<KApplicationServerInstance> applicationServerInstances;

	public KTeam() {
		this.teammates = new ArrayList<>();
		this.products = new ArrayList<>();
	}

	@Override public String toString() {
		return "KTeam{" +
				"id=" + id +
				", name='" + name + '\'' +
				", jiraComponent='" + jiraComponent + '\'' +
				", teammates=" + teammates +
				", products=" + products +
				", applicationServerInstances=" + applicationServerInstances +
				'}';
	}

	public KTeam(String name, String jiraComponent) {
		this();
		this.jiraComponent = jiraComponent;
		this.name = name;
	}

	public Boolean addTeammate(KTeammate teammate) {
		return teammates.add(teammate);
	}

	public Boolean addProduct(KProduct product) {
		return products.add(product);
	}

}
