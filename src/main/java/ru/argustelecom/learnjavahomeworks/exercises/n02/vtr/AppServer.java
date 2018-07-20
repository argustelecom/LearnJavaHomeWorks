package ru.argustelecom.learnjavahomeworks.exercises.n02.vtr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AppServer {
    
    @Id
    private int id;
    @Column
    private int stateId;
    @Column
    private String serverName;
    @Column
    private String description;
    @Column
    private String mission;
    @Column
    private String host;
    @Column
    private int portSet;
    @Column
    private String installDir;
    
    @ManyToOne
    Customer customer;
    
    @ManyToOne
    Team team;
    
}
