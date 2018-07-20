package ru.argustelecom.learnjavahomeworks.exercises.n02.achalyi;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "app_server")
public class AppServer {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "status", nullable = false, updatable = false) // список
    private String status;

    @Column(name = "server_name", nullable = false)
    private String serverName;

    @Column(name = "build_number", updatable = false)
    private String buildNumber;

    @OneToMany
    private ArrayList<Customer> customers;

    @Column(name = "version") // список
    private String version;

    @Column(name = "destination") // список
    private String destination;

    @Column(name = "note")
    private String note;

    @OneToMany
    private ArrayList<Command> commands;

    @Column (name = "host", nullable = false)
    private String host;

    @Column(name = "port_set", nullable = false)
    private Number portSet;

    @Column(name = "install_dir", nullable = false)
    private String installDir;

    @Column(name = "url", updatable = false)
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
