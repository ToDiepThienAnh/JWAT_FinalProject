package cyberlogitec.training.project.ecommerce.dto.computer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCommentDto {
    @NotBlank(message = "{comment.content.botblank}")
    private String content;

    private long replyForId;

    @NotBlank(message = "{computer.name.notblank")
    private String nameComputer;

}
