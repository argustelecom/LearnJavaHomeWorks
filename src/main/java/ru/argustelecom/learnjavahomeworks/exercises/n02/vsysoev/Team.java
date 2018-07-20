package ru.argustelecom.learnjavahomeworks.exercises.n02.vsysoev;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String jiraProjectKeyword;

    @Column
    private String jiraComponent;

    @Column
    private String product;

    @OneToMany
    private List<ApplicationServer> servers;

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

    public String getJiraProjectKeyword() {
        return jiraProjectKeyword;
    }

    public void setJiraProjectKeyword(String jiraProjectKeyword) {
        this.jiraProjectKeyword = jiraProjectKeyword;
    }

    public String getJiraComponent() {
        return jiraComponent;
    }

    public void setJiraComponent(String jiraComponent) {
        this.jiraComponent = jiraComponent;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<ApplicationServer> getServers() {
        return servers;
    }

    public void setServers(List<ApplicationServer> servers) {
        this.servers = servers;
    }
}