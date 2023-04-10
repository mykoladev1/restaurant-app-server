package mykola.dev.server.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/list")
    public List<Comment> getComments(@RequestBody CommentDTO data) {
        return commentService.getComments(data.getRestaurant());
    }

    @PostMapping("/")
    public void comment(@RequestBody Comment comment) {
        commentService.comment(comment);
    }
}
