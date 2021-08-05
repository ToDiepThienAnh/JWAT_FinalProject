package cyberlogitec.training.project.ecommerce.dto.computer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCommentDto {
    @NotBlank(message = "{computer.type.content.botblank}")
    private String content;

    private long replyForId;

    @NotBlank(message = "{computer.computer.name.notblank")
    private String nameComputer;

}
