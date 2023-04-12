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

    @GetMapping("/list/{id}")
    public List<Comment> getComments(@PathVariable("id") String id) {
        return commentService.getComments(UUID.fromString(id));
    }

    @GetMapping("/listByUser/{id}")
    public List<Comment> getCommentsByUser(@PathVariable("id") String id) {
        return commentService.getCommentsByUser(UUID.fromString(id));

    }

    @PostMapping("/")
    public void comment(@RequestBody Comment comment) {
        commentService.comment(comment);
    }
}
