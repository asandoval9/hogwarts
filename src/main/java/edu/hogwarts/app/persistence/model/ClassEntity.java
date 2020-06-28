package edu.hogwarts.app.persistence.model;

import edu.hogwarts.app.persistence.core.BaseEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ClassEntity extends BaseEntity {

    private String code;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "classes")
    private Set<StudentEntity> students = new HashSet<>();

    public ClassEntity(String code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

}
