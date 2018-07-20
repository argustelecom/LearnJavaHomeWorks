package ru.argustelecom.learnjavahomeworks.exercises.n02.vsysoev;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String jiraName;

    @Column
    private String jiraProject;

    @Column
    private String product;

    @ManyToOne
    private ApplicationServer server;

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

    public ApplicationServer getServer() {
        return server;
    }

    public void setServer(ApplicationServer server) {
        this.server = server;
    }
}