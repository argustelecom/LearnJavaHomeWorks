package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author k.koropovskiy
 */
@Entity
public class KApplicationServerInstance {
	@Id
	@GeneratedValue
	@Getter @Setter @NonNull
	private int id;

	@Enumerated(value = EnumType.STRING)
	@Column(length = 32, nullable = false)
	@Getter @Setter
	private ApplicationServerStatus applicationServerStatus;

	@Column(length = 128, nullable = false)
	@Getter @Setter
	private String name;

	@Column(length = 128)
	@Getter @Setter
	private String versionBuildNumber;

	@ManyToOne
	@Getter @Setter
	private KCustomer customer;

	@ManyToOne
	@Getter @Setter
	private KVersion version;

	@ManyToOne
	@Getter @Setter
	private KUsageType usageType;

	@Column
	@Getter @Setter
	private String comment;

	@ManyToMany(mappedBy = "applicationServerInstances")
	@Getter @Setter
	private List<KTeam> teams;

	@Column(length = 128, nullable = false)
	@Getter @Setter
	private String host;

	@Column(nullable = false)
	@Getter @Setter
	private int portSet;

	@Column
	@Getter @Setter
	private String installDir;

	public KApplicationServerInstance(ApplicationServerStatus applicationServerStatus, String name, String host,
			int portSet) {
		this();
		this.applicationServerStatus = applicationServerStatus;
		this.name = name;
		this.host = host;
		this.portSet = portSet;
	}

	public enum ApplicationServerStatus {
		RUNNING("Включен"),
		SHUTDOWN("Выключен"),
		USED("Заблокирован для показа");

		private String desc;

		ApplicationServerStatus(String desc) {
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		@Override
		public String toString() {
			return desc;
		}
	}

	public KApplicationServerInstance(){
		teams = new ArrayList<>();
	}
	public KApplicationServerInstance(
			ApplicationServerStatus applicationServerStatus, String name, String versionBuildNumber,
			KCustomer customer, KVersion version,
			KUsageType usageType, String comment, String host, int portSet, String installDir) {
		this();
		this.applicationServerStatus = applicationServerStatus;
		this.name = name;
		this.versionBuildNumber = versionBuildNumber;
		this.customer = customer;
		this.version = version;
		this.usageType = usageType;
		this.comment = comment;
		this.host = host;
		this.portSet = portSet;
		this.installDir = installDir;
	}

	public Boolean addTeam(KTeam team){
		return teams.add(team);
	}

	@Override public String toString() {
		return "KApplicationServerInstance{" +
				"id=" + id +
				", applicationServerStatus=" + applicationServerStatus +
				", name='" + name + '\'' +
				", versionBuildNumber='" + versionBuildNumber + '\'' +
				", customer=" + customer +
				", version=" + version +
				", usageType=" + usageType +
				", comment='" + comment + '\'' +
				", teams=" + teams +
				", host='" + host + '\'' +
				", portSet=" + portSet +
				", installDir='" + installDir + '\'' +
				'}';
	}
}
