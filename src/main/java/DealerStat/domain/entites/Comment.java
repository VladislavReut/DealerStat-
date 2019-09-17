package DealerStat.domain.entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
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

    public GameObject getPost_id() {
        return post_id;
    }

    public void setPost_id(GameObject post_id) {
        this.post_id = post_id;
    }

    public User getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(User author_id) {
        this.author_id = author_id;
    }
}
