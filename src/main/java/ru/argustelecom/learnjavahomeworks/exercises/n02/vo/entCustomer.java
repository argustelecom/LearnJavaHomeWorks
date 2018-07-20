package ru.argustelecom.learnjavahomeworks.exercises.n02.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.List;

@Entity
@Table(name = "customer")
public class entCustomer {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(nullable = false,name = "CUSTOMER_NAME")
    private String name;

    @Column(nullable = false,name = "JIRA_NAME")
    private String jiraName;

    @Column(name = "JIRA_PROJECT")
    private String jiraProject;

    @Column(name = "PRODUCT")
    private String product;

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

    public String getJiraName() {
        return jiraName;
    }

    public void setJiraName(String jiraName) {
        this.jiraName = jiraName;
    }

    public String getJiraProject() {
        return jiraProject;
    }

    public void setJiraProject(String jiraProject) {
        this.jiraProject = jiraProject;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<entAppServer> getappServers() {
        return appServers;
    }

    public void setappServers(List<entAppServer> appServers) {
        this.appServers = appServers;
    }
}