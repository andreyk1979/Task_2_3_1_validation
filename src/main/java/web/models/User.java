package web.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "FIrstname should not be empty")
    @Size(min = 2, max = 30,message = "Firstname shuld be between 2 and 30 characters")
    private String firstName;

    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 2, max = 30,message = "Lastname shuld be between 2 and 30 characters")
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be correct")
    private String email;


    public User(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Имя:'" + firstName +
                ", Фамилия:'" + lastName + '\'' +
                ", Электронная почта:" + email + '\'' +
                '}';
    }
}
