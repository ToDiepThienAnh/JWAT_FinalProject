package cyberlogitec.training.project.ecommerce.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ecommerce_role")
public class Role extends AbstractEntity {
    @Column(unique = true)
    @NotBlank(message = "{user.role.name.notblank}")
    private String name;

    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;
}
