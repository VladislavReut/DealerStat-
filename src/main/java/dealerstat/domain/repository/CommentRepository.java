package dealerstat.domain.repository;

import dealerstat.domain.entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Iterable <Comment> findAllByAuthorId(Long author_id);
}
