package ru.argustelecom.learnjavahomeworks.exercises.n02.vtr;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
    @Id
    private int id;
    @Column
    private String name;
    
    public int getId() {
        return id;
    }
    
    @OneToMany
    private List<AppServer> appServers;
    
    @Embedded
    private JiraLink jiraLink;
    
}
