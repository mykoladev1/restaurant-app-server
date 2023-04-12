package mykola.dev.server.restaurant;

import mykola.dev.server.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

        @GetMapping("/list")
        public List<Restaurant> getRestaurants() {
            return restaurantService.getRestaurants();
        }

        @PostMapping("/add")
        public void addRestaurant(@RequestBody Restaurant restaurant) {
            restaurantService.addRestaurant(restaurant);
        }

        @GetMapping("/comments/{id}")
        public  List<Comment> getRestaurantComments(@PathVariable("id") String id) {
            return restaurantService.getRestaurantComments(UUID.fromString(id));
        }

}
