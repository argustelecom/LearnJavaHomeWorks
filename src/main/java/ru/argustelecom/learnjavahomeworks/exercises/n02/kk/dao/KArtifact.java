package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * @author k.koropovskiy
 */
@Entity
public class KArtifact {

	@Id
	@GeneratedValue
	@Getter @Setter
	private int id;

	@Column
	@Getter @Setter
	private String name;

	@Column
	@Getter @Setter
	private String gitRepository;

	@ManyToMany
	@Getter @Setter
	@JoinTable(name = "artifact_product",
			joinColumns = @JoinColumn(name = "artifact_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Collection<KProduct> products;
}
