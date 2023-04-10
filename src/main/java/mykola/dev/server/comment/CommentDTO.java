package mykola.dev.server.comment;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;

@Data
public class CommentDTO {

    private UUID id;

    private String login;

    private String text;

    private UUID restaurant;

    private int stars;


    public void setRestaurant(String restaurant) {
        this.restaurant = UUID.fromString(restaurant);
    }

}
