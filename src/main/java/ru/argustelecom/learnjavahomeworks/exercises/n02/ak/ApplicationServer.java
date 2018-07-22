package ru.argustelecom.learnjavahomeworks.exercises.n02.ak;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.ArrayList;

@Entity
@Table(name = "application_server")
public class ApplicationServer {
/**
	---------------------------------------------------------------------
	|     Имя        | тип  |Обяз?|Редакт?|Откуда данные
	---------------------------------------------------------------------
	|состояние       |Иконки|  ДА |  НЕТ  |Список: включен, выключен, заблокирован для показа. Исследование.
	---------------------------------------------------------------------
	|имя сервера     | текст|  ДА |   ДА  |
	---------------------------------------------------------------------
	|точный номер    |      |     |       |
	|сборки (точная  |      |     |       |
	|версия ПО)      | текст| НЕТ |  НЕТ  |Исследование.
	---------------------------------------------------------------------
	|Заказчик        | текст| НЕТ |   ДА  |Список из справочника Заказчики
	---------------------------------------------------------------------
	|Версия          | текст| НЕТ |   ДА  |Список из справочника Список версий
	---------------------------------------------------------------------
	|Предназначение  | текст| НЕТ |   ДА  |Выбор из справочника Типы использования
	---------------------------------------------------------------------
	|Примечание      | текст| НЕТ |   ДА  |Многострочный текст до 512симв
	---------------------------------------------------------------------
	|Команда, исп. СП|список| НЕТ |   ДА  |Множественный выбор из справочника Команды.
	---------------------------------------------------------------------
	|host            | текст|  ДА |   ДА  |
	---------------------------------------------------------------------
	|PortSet         | число|  ДА |   ДА  |
	---------------------------------------------------------------------
	|Install dir     | текст|  ДА |   ДА  |Путь установки в Linux формате
	---------------------------------------------------------------------
	|Ссылка на сервер|ссылка| НЕТ |  НЕТ  |Вычисляемое: http:host:port/argus
	---------------------------------------------------------------------
 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String stateName;
	@Column
	private String serverName;
	@Column
	private String buildNumber;
	@Column
	private String customerName;
	@Column
	private String versionNumber;
	@Column
	private String destination;
	@Column (name = "developer_command_id")
	private ArrayList<DeveloperCommand> developerCommand;
	@Column
	private String host;
	@Column
	private Number portSet;
	@Column
	private String installDir;
	@Column
	private String serverUrl;

	public String getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public ArrayList<DeveloperCommand> getDeveloperCommand() {
		return developerCommand;
	}

	public void setDeveloperCommand(
			ArrayList<DeveloperCommand> developerCommand) {
		this.developerCommand = developerCommand;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Number getPortSet() {
		return portSet;
	}

	public void setPortSet(Number portSet) {
		this.portSet = portSet;
	}

	public String getInstallDir() {
		return installDir;
	}

	public void setInstallDir(String installDir) {
		this.installDir = installDir;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
}
