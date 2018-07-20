package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author k.koropovskiy
 */
@Entity
public class KProduct {
	@Id
	@GeneratedValue
	@Getter @Setter
	private int id;

	@Column
	@Getter @Setter
	private String name;

	@Column
	@Getter @Setter
	private String jiraProject;

	@Column
	@Getter @Setter
	private String jiraComponent;

	@ManyToMany(mappedBy = "products")
	@Getter @Setter
	private List<KCustomer> customers;

	@ManyToMany(mappedBy = "products")
	@Getter @Setter
	private List<KArtifact> artifacts;

	@ManyToMany(mappedBy = "products")
	@Getter @Setter
	private List<KTeam> teams;

	public KProduct(){
		customers = new ArrayList<>();
		artifacts = new ArrayList<>();
	}

	public KProduct(String name, String jiraProject, String jiraComponent) {
		this();
		this.name = name;
		this.jiraProject = jiraProject;
		this.jiraComponent = jiraComponent;
	}

	@Override public String toString() {
		return "KProduct{" +
				"id=" + id +
				", name='" + name + '\'' +
				", jiraProject='" + jiraProject + '\'' +
				", jiraComponent='" + jiraComponent + '\'' +
				", customers=" + (customers == null ? "" : customers.stream().map(KCustomer::getName).collect(Collectors.joining(","))) +
				", artifacts=" + (artifacts == null ? "" : artifacts.stream().map(KArtifact::getName).collect(Collectors.joining(","))) +
				", teams=" + (teams == null ? "" : teams.stream().map(KTeam::getName).collect(Collectors.joining(","))) +
				'}';
	}
}
