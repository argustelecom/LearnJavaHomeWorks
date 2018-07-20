package ru.argustelecom.learnjavahomeworks.exercises.n02.vtr;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    private int id;
    @Column
    private String name;
    @Embedded
    private JiraLink jiraLink;
    @OneToMany
    private List<AppServer> appServers;
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
