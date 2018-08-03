package ru.levelp.hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "`group`")
public class Group {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @OneToMany(mappedBy = "group")
    @MapKey(name = "name")
    private Map<String, Student> studentsMap;

    @ManyToMany
    @JoinTable(name = "group_teacher",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
