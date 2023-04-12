package mykola.dev.server.restaurant;

import jakarta.persistence.*;
import lombok.CustomLog;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private String priceCategory;
    @Column
    private double rate;

    public Restaurant() {
    }

    public Restaurant(String name, String description, String category, String priceCategory) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.priceCategory = priceCategory;
    }
}
