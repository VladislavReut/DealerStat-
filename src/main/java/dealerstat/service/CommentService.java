package dealerstat.service;

import dealerstat.domain.entites.Comment;
import dealerstat.domain.entites.User;
import dealerstat.domain.repository.CommentRepository;
import dealerstat.domain.repository.GameObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private GameObjectRepository gameObjectRepository;

    public String deleteComment(Long postID, User user){
        Comment comment=commentRepository.getOne(postID);
        if(user==comment.getAuthorId()) {
            commentRepository.deleteById(postID);
        }
        return "main";
    }

    public String listOfComments(Long traderID, Model model){
    Iterable<Comment> allAuthorComments = commentRepository.findAllByAuthorId(traderID);
        model.addAttribute("allComments", allAuthorComments);
        return "/users/{TraderID}/comments";
    }

    public String ViewTraderComment(Long commentId, Model model) {
        model.addAttribute("comment", commentRepository.findById(commentId));
        return "/users/{traderId}/comments/{commentId}";
    }

    public String AddComment(User user, Long postId, String message) {
        Comment comment = new Comment(message);
        comment.setAuthorId(user);
        comment.setPostId(gameObjectRepository.getOne(postId));
        return "main";
    }


}
