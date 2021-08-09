package cyberlogitec.training.project.ecommerce.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import cyberlogitec.training.project.ecommerce.computer.model.Comment;
import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;
import cyberlogitec.training.project.ecommerce.user.annotation.ExistsUsername;
import cyberlogitec.training.project.ecommerce.user.util.UserStatus;
import cyberlogitec.training.project.ecommerce.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ecommerce_user")
@Getter
@Setter
public class User extends AbstractEntity {
    @Column(unique = true)
    @NotBlank(message = "{user.username.notblank}")
    @Size(message = "{user.username.size}", min = 4, max = 8)
    private String username;

    private String userId;

    private String phone;

    private String fullname;

    private String password;

    private String avatar;

    @JsonFormat(pattern = DateUtils.DATE)
    private LocalDateTime birthday;

    @Column(unique = true)
    @NotBlank(message = "{user.email.notblank}")
    @Email
    private String email;

    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "name")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Invoice> invoices;
}
