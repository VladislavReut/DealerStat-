package dealerstat.domain.entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    private Long id;
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private GameObject post_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author_id;

    private Date created_at;

    public Comment(String message) {
        this.message= message;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GameObject getPostId() {
        return post_id;
    }

    public void setPostId(GameObject post_id) {
        this.post_id = post_id;
    }

    public User getAuthorId() {
        return author_id;
    }

    public void setAuthorId(User author_id) {
        this.author_id = author_id;
    }
}
