package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.computer.model.Comment;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateCommentDto;
import cyberlogitec.training.project.ecommerce.dto.computer.UpdateCommentDto;

public interface CommentService extends IGenericService<Comment, Long> {
    public Comment save(CreateCommentDto dto);

    public Comment update(UpdateCommentDto dto, long commentId) throws Exception;

    public Comment deleteById(long commentId);
}
