package mykola.dev.server.comment;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column
    private String login;
    @Column
    private String text;
    @Column
    @Convert(converter = UUIDConverter.class)
    private UUID restaurant;
    @Column
    @Convert(converter = UUIDConverter.class)
    private UUID userID;
    @Column
    private double stars;

    public Comment(String login, String text, UUID restaurant, UUID userID, int stars) {
        this.login = login;
        this.text = text;
        this.restaurant = restaurant;
        this.stars = stars;
        this.userID = userID;

    }

    public Comment() {

    }
}
