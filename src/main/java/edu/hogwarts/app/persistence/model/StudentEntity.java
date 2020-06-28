package edu.hogwarts.app.persistence.model;

import edu.hogwarts.app.persistence.core.BaseEntity;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity extends BaseEntity {

    private String firstName;
    private String lastName;

}
