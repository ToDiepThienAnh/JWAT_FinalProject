package cyberlogitec.training.project.ecommerce.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import cyberlogitec.training.project.ecommerce.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Version
    protected int version;

    @CreatedDate
    @Column(name = "created_at",nullable = false ,updatable = false)
    @JsonFormat(pattern = DateUtils.DATE_FORMAT)
    protected LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    @JsonFormat(pattern = DateUtils.DATE_FORMAT)
    protected LocalDateTime updateAt;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String lastModifiedBy;

}
