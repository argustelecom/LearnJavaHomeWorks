package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * @author k.koropovskiy
 */
@Entity
public class ApplicationServerInstance {
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
	private Customer customer;

	@ManyToOne
	@Getter @Setter
	private Version version;

	@ManyToOne
	@Getter @Setter
	private UsageType usageType;

	@Column
	@Getter @Setter
	private String comment;

	@ManyToMany
	@Getter @Setter
	private List<Team> teams;

	@Column(length = 128, nullable = false)
	@Getter @Setter
	private String host;

	@Column(nullable = false)
	@Getter @Setter
	private int portSet;

	@Column
	@Getter @Setter
	private String installDir;

	public ApplicationServerInstance() {
		super();
	}

	public ApplicationServerInstance(ApplicationServerStatus applicationServerStatus, String name, String host,
			int portSet) {
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


}
