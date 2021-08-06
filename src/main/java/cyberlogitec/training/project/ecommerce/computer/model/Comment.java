package cyberlogitec.training.project.ecommerce.computer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cyberlogitec.training.project.ecommerce.common.AbstractEntity;
import cyberlogitec.training.project.ecommerce.user.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ecommerce_comment")
public class Comment extends AbstractEntity {
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Comment replyFor;

    @OneToMany(mappedBy = "replyFor", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "code")
    private Computer computer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "username")
    @JsonIgnore
    private User user;
}
