package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author k.koropovskiy
 */
@Entity
public class Product {
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

	@ManyToMany
	@Getter @Setter
	private List<Customer> customers;

	@ManyToMany
	@Getter @Setter
	private List<Artifact> artifacts;

	@ManyToMany(mappedBy = "products")
	@Getter @Setter
	private List<Team> teams;

}
