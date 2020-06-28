package edu.hogwarts.app.persistence.model;

import edu.hogwarts.app.persistence.core.BaseEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name = "student_class",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"))
    private Set<ClassEntity> classes = new HashSet<>();

    public StudentEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
