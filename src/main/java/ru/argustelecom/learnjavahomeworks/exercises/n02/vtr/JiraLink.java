package ru.argustelecom.learnjavahomeworks.exercises.n02.vtr;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JiraLink {
    @Column
    private String url;
    @Column
    private String name;
    
    public String getUrl() {
        return url;
    }
    
    public String getName() {
        return name;
    }
    
    // blablabla    
}
