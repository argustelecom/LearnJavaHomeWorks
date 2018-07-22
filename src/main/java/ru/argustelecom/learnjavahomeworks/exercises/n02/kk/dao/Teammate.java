package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author k.koropovskiy
 */
@Entity
public class Teammate {
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

	@ManyToMany(mappedBy = "teammates")
	@Getter @Setter
	private List<Team> teams;

	@Enumerated(value = EnumType.STRING)
	@Column(length = 32)
	@Getter @Setter
	private WatchingType versionWatchingType;

	@Enumerated(value = EnumType.STRING)
	@Column(length = 32)
	@Getter @Setter
	private WatchingType deliveryWatchingType;

	public enum WatchingType{
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

}
