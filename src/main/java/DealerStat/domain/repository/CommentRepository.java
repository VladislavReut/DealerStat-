package DealerStat.domain.repository;

import DealerStat.domain.entites.Comment;
import DealerStat.domain.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Iterable <Comment> findAllByAuthorId(Long author_id);

}
