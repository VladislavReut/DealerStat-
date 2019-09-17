package DealerStat.domain.entites;

import javax.persistence.*;
import java.util.Date;

    @Entity
    @Table(name = "gamaobject")
public class GameObject {
        @Id
        private Long id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "game_id")
        private Game game_id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "author_id")
        private User author_id;

        public Long getId() {
            return id;
        }

        public Game getGame_id() {
            return game_id;
        }

        public void setGame_id(Game game_id) {
            this.game_id = game_id;
        }

        public User getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(User author_id) {
            this.author_id = author_id;
        }

        private Enum status;

        private String title;
        private String Text;

        private Date created_at;
        private Date updated_at;

        public GameObject(Long id, Long game_id, Long author_id, Date created_at) {
            this.id = id;
            this.created_at = new Date();
        }
        public void UpdateDate() {
            updated_at= new Date();
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return Text;
        }

        public void setText(String text) {
            Text = text;
        }
    }
