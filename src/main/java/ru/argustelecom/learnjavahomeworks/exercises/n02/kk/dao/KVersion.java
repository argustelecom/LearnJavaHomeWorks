package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author k.koropovskiy
 */
@Entity
public class KVersion {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;

	@Override public String toString() {
		return "KVersion{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	public KVersion(String name){
		this.name = name;
	};

	public KVersion(){
		super();
	}

}
