package ru.argustelecom.learnjavahomeworks.exercises.n02.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * |Имя	                |Тип	|Откуда данные|
 * ---------------------------------------------------------
 * |Название команды	|Текст	|
 * |Проект в Jira	    |текст	|Key-word проекта, в котором работает команда|
 * |Компонент в Jira	|текст	|Список компонентов Jira проекта команды не связанных с существующими командами|
 * |Продукты	        |список	|Список продуктов, которыми владеет команда|
 *
 * v.semchenko
 */
@Entity
@Table(name = "developer_team")
public class DeveloperTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "team_name", nullable = false)
	private String name;

	@Column(name = "team_name_in_jira", nullable = false)
	private String nameProjectInJira;

	@Column
	private String componentInJira;

	@Column
	private String modules;

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

	public String getNameProjectInJira() {
		return nameProjectInJira;
	}

	public void setNameProjectInJira(String nameProjectInJira) {
		this.nameProjectInJira = nameProjectInJira;
	}

	public String getComponentInJira() {
		return componentInJira;
	}

	public void setComponentInJira(String componentInJira) {
		this.componentInJira = componentInJira;
	}

	public String getModules() {
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}

}
