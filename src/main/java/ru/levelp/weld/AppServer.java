package ru.levelp.weld;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppServer {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String hostPort;

    public AppServer() {
    }

    public AppServer(String name, String hostPort) {
        this.name = name;
        this.hostPort = hostPort;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    @Override
    public String toString() {
        return "AppServer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hostPort='" + hostPort + '\'' +
                '}';
    }
}
