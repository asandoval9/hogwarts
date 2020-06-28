package edu.hogwarts.app.persistence.core;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public class BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    public boolean isNew() {
        return this.id == null;
    }

}
