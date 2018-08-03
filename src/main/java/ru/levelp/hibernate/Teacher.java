package ru.levelp.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("T")
public class Teacher extends Person {
    @ManyToMany
    @JoinTable(name = "group_teacher",
        joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;

    @ElementCollection
    @CollectionTable(name = "achievements",
            joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "achievement")
    private List<String> achievements;

//    @Enumerated(EnumType.STRING)
    @Column
    @Convert(converter = DegreeConverter.class)
    private Degree degree;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "groups=" + groups +
                ", achievements=" + achievements +
                ", degree=" + degree +
                "} " + super.toString();
    }
}
