package edu.hogwarts.app.persistence.model;

import edu.hogwarts.app.persistence.core.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassEntity extends BaseEntity {

    private String code;
    private String title;
    private String description;

}
