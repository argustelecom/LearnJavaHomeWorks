package ru.levelp.hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(value = IdWithEntityID.class)
public class AuditLog {
//    @EmbeddedId
//    private IdWithEntityID id;

    @Id
    private int id;

    @Id
    private int entityId;
}
