package pl.coderslab.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tweeg")
public class Tweeg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ////////////////.............................
    @ManyToOne
    private User user;
    ////////////////.............................
    @Size(min = 1, max = 120)
    private String text;
    ////////////////.............................
    private LocalDateTime created;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweeg tweeg = (Tweeg) o;
        return Objects.equals(id, tweeg.id) &&
                Objects.equals(user, tweeg.user) &&
                Objects.equals(text, tweeg.text) &&
                Objects.equals(created, tweeg.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, text, created);
    }
}
