package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.computer.model.Comment;
import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.computer.repository.CommentRepository;
import cyberlogitec.training.project.ecommerce.computer.repository.ComputerRepository;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateCommentDto;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl extends GenericService<Comment, Long> implements CommentService {
    private CommentRepository repository;
    private UserRepository userRepository;
    private ComputerRepository computerRepository;

    @Override
    public Comment save(CreateCommentDto dto) {
        Comment newComment = new Comment();
        newComment.setContent(dto.getContent());
        if(dto.getReplyForId() != 0){
            Optional<Comment> replyFor = repository.findById(dto.getReplyForId());
            if(replyFor.isPresent())
                newComment.setReplyFor(replyFor.get());
        } else
            newComment.setReplyFor(null);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        Computer computer = computerRepository.findByName(dto.getNameComputer());
        newComment.setComputer(computer);
        if(user.isPresent())
            newComment.setUser(user.get());
        return repository.save(newComment);
    }


}
