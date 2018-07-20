package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author k.koropovskiy
 */
@Entity
public class KUsageType {
	@Id
	@Getter
	private String key;

	@Column
	@Getter @Setter
	private String name;

	public KUsageType(){super();};

	public KUsageType(String key, String name){
		this.key = key;
		this.name = name;
	}
}
