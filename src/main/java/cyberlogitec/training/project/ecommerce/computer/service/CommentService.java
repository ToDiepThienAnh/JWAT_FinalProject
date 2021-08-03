package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.computer.model.Comment;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateCommentDto;

public interface CommentService extends IGenericService<Comment, Long> {
    public Comment save(CreateCommentDto dto);
}
