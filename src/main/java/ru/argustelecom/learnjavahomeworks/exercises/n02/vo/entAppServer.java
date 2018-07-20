package ru.argustelecom.learnjavahomeworks.exercises.n02.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "app_server")
public class entAppServer {

    @Id
    @GeneratedValue
    @Column(name = "APP_SERVER_ID")
    private Long id;

    @Column(nullable = false, name = "APP_SERVER_NAME")
    private String name;

    @Column(updatable = false, name = "BUILD_NAME")
    private String buildNum;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private Integer port;

    @Column(nullable = false, name = "INSTALL_DIR")
    private String installDir;

    @Column
    private String version;

    @Column
    private String usage;

    @Column
    private String description;

    @ManyToOne
    private entCustomer customer;

    @ManyToOne
    private entTeam team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getInstallDir() {
        return installDir;
    }

    public void setInstallDir(String installDir) {
        this.installDir = installDir;
    }

    public entCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(entCustomer customer) {
        this.customer = customer;
    }

    public entTeam getTeam() {
        return team;
    }

    public void setTeam(entTeam team) {
        this.team = team;
    }

}