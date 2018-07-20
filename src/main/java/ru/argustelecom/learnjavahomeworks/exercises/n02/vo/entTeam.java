package ru.argustelecom.learnjavahomeworks.exercises.n02.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.List;

@Entity
@Table(name = "team")
public class entTeam {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(nullable = false,name = "TEAM_NAME")
    private String name;

    @Column(name = "JIRA_PROJECT_ID")
    private String jiraProject;

    @Column(name = "JIRA_COMPONENT")
    private String jiraComponent;

    @Column
    private String products;

    @OneToMany
    private List<entAppServer> appServers;

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

    public String getJiraProject() {
        return jiraProject;
    }

    public void setJiraProject(String jiraProject) {
        this.jiraProject = jiraProject;
    }

    public String getJiraComponent() {
        return jiraComponent;
    }

    public void setJiraComponent(String jiraComponent) {
        this.jiraComponent = jiraComponent;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public List<entAppServer> getappServers() {
        return appServers;
    }

    public void setappServers(List<entAppServer> appServers) {
        this.appServers = appServers;
    }
}