package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author k.koropovskiy
 */
@Entity
public class KTeammate {
	@Id
	@GeneratedValue
	@Getter @Setter
	private int id;

	@Column
	@Getter @Setter
	private String FIO;

	@Column
	@Getter @Setter
	private String jiraName;

	@Column
	@Getter @Setter
	private String email;

	@ManyToMany//(mappedBy = "teammates")
	@Getter @Setter
	@JoinTable(name = "team_teammate",
			joinColumns = @JoinColumn(name = "team_id"),
			inverseJoinColumns = @JoinColumn(name = "teammate_id"))
	private List<KTeam> teams;

	@Enumerated(value = EnumType.STRING)
	@Column(length = 32)
	@Getter @Setter
	private WatchingType versionWatchingType;

	@Enumerated(value = EnumType.STRING)
	@Column(length = 32)
	@Getter @Setter
	private WatchingType deliveryWatchingType;

	public enum WatchingType {
		ALWAYS("Всегда"),
		MYTEAM("Когда участвует команда"),
		NEWER("Никогда");

		private String desc;

		WatchingType(String desc) {
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

	public KTeammate() {
		teams = new ArrayList<>();
	}

	@Override public String toString() {
		return "KTeammate{" +
				"id=" + id +
				", FIO='" + FIO + '\'' +
				", jiraName='" + jiraName + '\'' +
				", email='" + email + '\'' +
				", teams=" + teams +
				", versionWatchingType=" + versionWatchingType +
				", deliveryWatchingType=" + deliveryWatchingType +
				'}';
	}

	public KTeammate(String FIO, String email, String jiraName, KTeam team) {
		this();
		this.FIO = FIO;
		this.email = email;
		this.jiraName = jiraName;
		teams.add(team);
	}

	public Boolean addToTeam(KTeam team) {
		return teams.add(team);
	}

}
