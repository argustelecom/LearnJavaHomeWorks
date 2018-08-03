package ru.levelp.hibernate;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ptype",
        discriminatorType = DiscriminatorType.CHAR,
        length = 1)
@DiscriminatorValue("?")
public abstract class Person {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "name length should be in 2..255")
    private String name;

    @Column
    @Pattern.List({
            @Pattern(regexp = "[0-9]{10}"),
            @Pattern(regexp = "[0-9]{10}")
    })
    private String phone;

    @Column
    @Temporal(TemporalType.DATE)
    @Past
    private Date birthdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
