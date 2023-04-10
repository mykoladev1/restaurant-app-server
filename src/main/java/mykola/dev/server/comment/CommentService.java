package mykola.dev.server.comment;


import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(UUID restaurantID) {
        return commentRepository.findAllById(restaurantID);
    }

    public void comment(Comment comment) {
        commentRepository.save(comment);
    }
}
