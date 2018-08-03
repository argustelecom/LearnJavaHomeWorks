package ru.levelp.hibernate;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class IdWithEntityID implements Serializable {
    @Id
    private int id;

    @Id
    private int entityId;
}
