package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author k.koropovskiy
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue
	@Getter @Setter
	private int id;

	@Column
	@Getter @Setter
	private String name;

	@Column
	@Getter @Setter
	private String jiraName;

	@Column
	@Getter @Setter
	private String jiraProject;

	@ManyToMany
	@Getter @Setter
	private List<Product> products;

	@OneToMany
	@Getter @Setter
	private List<ApplicationServerInstance> serverInstances;
}
