package mykola.dev.server.restaurant;

import mykola.dev.server.comment.Comment;
import mykola.dev.server.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {

    private final CommentRepository commentRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(CommentRepository commentRepository, RestaurantRepository restaurantRepository) {
        this.commentRepository = commentRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Optional<Restaurant> getRestaurant(UUID restaurantid) {
        return restaurantRepository.findById(restaurantid);
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public double countRate(UUID restaurantId, List<Comment> comments) {
        int i;
        double resultSumOfStars = 0;
        for(i=0; i < comments.size(); i++) {
            resultSumOfStars = resultSumOfStars + comments.get(i).getStars();

        }
        return resultSumOfStars/comments.size();
    }

    public List<Comment> getRestaurantComments(UUID restaurantId) {
        return commentRepository.findAllByRestaurant(restaurantId);
    }
}
