package cyberlogitec.training.project.ecommerce.computer.repository;

import cyberlogitec.training.project.ecommerce.computer.model.Comment;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateCommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
