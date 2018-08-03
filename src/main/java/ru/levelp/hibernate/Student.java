package ru.levelp.hibernate;

import javax.persistence.*;

@Entity
@DiscriminatorValue("S")
public class Student extends Person {
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "name",
                    column = @Column(name = "name2"))
    )
    private Name name2;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "name",
                    column = @Column(name = "name3"))
    )
    private Name name3;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
