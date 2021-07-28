package cyberlogitec.training.project.ecommerce.user.model;

import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import cyberlogitec.training.project.ecommerce.user.util.UserStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ecommerce_user")
@Getter
@Setter
public class User extends AbstractEntity {
    @Column(unique = true)
    private String username;

    private String fullname;

    private String password;

    private String avatar;

    @Column(unique = true)
    private String email;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
