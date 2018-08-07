package ru.argustelecom.learnjavahomeworks.exercises.n02.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * |Имя	                        |тип	|Обяз?	|Редакт?	|Откуда данные	|
 * ------------------------------------------------------------------------------------------------------------------
 * |состояние 	                |Иконки	|ДА	    |НЕТ	    |Список: включен, выключен, заблокирован для показа. Исследование.	|
 * |имя сервера	                |текст	|ДА	    |ДА	        |                |
 * |точный номер сборки (точная версия ПО)	|текст	|НЕТ	|НЕТ	|Исследование.	|
 * |Заказчик	                |текст	|НЕТ	|ДА	        |Список из справочника Заказчики |
 * |Версия	                    |текст	|НЕТ	|ДА	        |Список из справочника Список версий |
 * |Предназначение	            |текст	|НЕТ	|ДА	        |Выбор из справочника Типы использования	|
 * |Примечание	                |текст	|НЕТ	|ДА	        |Многострочный текст до 512симв	|
 * |Команда, использующая СП	|список	|НЕТ	    |ДА	|Множественный выбор из справочника Команды.	|
 * |host	                    |текст	|ДА	    |ДА	        |	|
 * |PortSet	                    |число	|ДА	    |ДА	        |	|
 * |Install dir	                |текст	|ДА	    |ДА	        |Путь установки в Linux формате	|
 * |Ссылка на сервер	        |ссылка	|НЕТ	|НЕТ	|Вычисляемое: http://host:port/argus	|
 *
 * v.semchenko
 */
@Entity
@Table(name = "application_server")
public class ApplicationServer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "appserver_status", nullable = false)
	private String state;

	@Column(name = "appserver_name", nullable = false)
	private String appServerName;

	@Column
	private String buildNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column
	private String version;

	@Column
	private String goal;
	
	@Column
	private String comment;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "appservers", joinColumns = @JoinColumn(name = "appserver_id"),
			inverseJoinColumns=@JoinColumn(name = "team_id"))
	private List<DeveloperTeam> teams;

	@Column(name = "host", nullable = false)
	private String host;

	@Column(name = "port_offset", nullable = false)
	private int portOffSet;

	@Column(name = "appserver_dir_path", nullable = false)
	private String installDirPath;

	@Column
	private String urlAddress;

	public ApplicationServer(String state, String appServerName, String host, int portOffSet, String installDirPath) {
		this.state = state;
		this.appServerName = appServerName;
		this.teams = new ArrayList<>();
		this.customer = new Customer();
		this.host = host;
		this.portOffSet = portOffSet;
		this.installDirPath = installDirPath;
		this.urlAddress = "http://" + host + ":" + (8080 + portOffSet) + "/argus";
	}

	public ApplicationServer() {
		this.state = "";
		this.appServerName = "";
		this.teams = new ArrayList<>();
		this.customer = new Customer();
		this.host = "";
		this.portOffSet = 0;
		this.installDirPath = "";
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAppServerName() {
		return appServerName;
	}

	public void setAppServerName(String appServerName) {
		this.appServerName = appServerName;
	}

	public String getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public List<DeveloperTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<DeveloperTeam> teams) {
		this.teams = teams;
	}

	public boolean addTeam(DeveloperTeam team) {
		return this.teams.add(team);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPortOffSet() {
		return portOffSet;
	}

	public void setPortOffSet(int portOffSet) {
		this.portOffSet = portOffSet;
	}

	public String getInstallDirPath() {
		return installDirPath;
	}

	public void setInstallDirPath(String installDirPath) {
		this.installDirPath = installDirPath;
	}

	public String getUrlAddress() {
		return urlAddress;
	}

	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}

	@Override public String toString() {
		return "ApplicationServer{" +
				"\nid=" + id +
				", \nstate='" + state + '\'' +
				", \nappServerName='" + appServerName + '\'' +
				", \nbuildNumber='" + buildNumber + '\'' +
				", \n\ncustomer=" + customer.getName() +
				", \n\nversion='" + version + '\'' +
				", \ngoal='" + goal + '\'' +
				", \ncomment='" + comment + '\'' +
				", \n\nteams=" + teams.stream().map(t -> t.getName()).toArray() +
				", \n\nhost='" + host + '\'' +
				", \nportOffSet=" + portOffSet +
				", \ninstallDirPath='" + installDirPath + '\'' +
				", \nurlAddress='" + urlAddress + '\'' +
				'}';
	}
}
