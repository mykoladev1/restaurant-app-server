package mykola.dev.server.comment;


import mykola.dev.server.restaurant.Restaurant;
import mykola.dev.server.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    private final RestaurantService restaurantService;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(RestaurantService restaurantService, CommentRepository commentRepository) {
        this.restaurantService = restaurantService;
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(UUID restaurantID) {
        return commentRepository.findAllByRestaurant(restaurantID);
    }
    public List<Comment> getCommentsByUser(UUID userId) {
        return commentRepository.findAllByUserID(userId);
    }


    public void comment(Comment comment) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(comment.getRestaurant());
        restaurant.get().setRate(restaurantService.countRate(comment.getRestaurant(), commentRepository.findAllByRestaurant(comment.getRestaurant())));
        commentRepository.save(comment);
        }
    }

