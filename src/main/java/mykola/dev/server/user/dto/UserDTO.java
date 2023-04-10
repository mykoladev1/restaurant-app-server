package mykola.dev.server.user.dto;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UserDTO {
    private UUID id;
    private String name;
    private String surname;

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.name = name;
    }
    
    public void setId(String id) {
        this.id = UUID.fromString(id);
    }
    public UUID getId() {
        return id;
    }
}
