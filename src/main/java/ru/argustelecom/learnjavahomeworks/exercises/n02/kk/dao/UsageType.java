package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author k.koropovskiy
 */
@Entity
public class UsageType {
	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;

}
