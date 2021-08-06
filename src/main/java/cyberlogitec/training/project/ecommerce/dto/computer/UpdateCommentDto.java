package cyberlogitec.training.project.ecommerce.dto.computer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateCommentDto {
    @NotBlank(message = "{comment.content.notblank")
    private String content;

}
