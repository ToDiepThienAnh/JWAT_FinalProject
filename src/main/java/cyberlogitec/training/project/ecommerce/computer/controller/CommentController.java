package cyberlogitec.training.project.ecommerce.computer.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.computer.model.Comment;
import cyberlogitec.training.project.ecommerce.computer.service.CommentService;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateCommentDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
public class CommentController {
    private CommentService service;

    @GetMapping("")
    public ResponseEntity<Object> findAllComments(){
        List<Comment> list = service.findAll();
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addComment(@Valid @RequestBody CreateCommentDto dto,
                                             BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Comment addComment = service.save(dto);
        return ResponseObject.getResponse(addComment, HttpStatus.CREATED);
    }
}
