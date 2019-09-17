package DealerStat.restControllers;

import DealerStat.domain.entites.Comment;
import DealerStat.domain.entites.User;
import DealerStat.domain.entites.GameObject;
import DealerStat.domain.repository.CommentRepository;
import DealerStat.domain.repository.GameObjectRepository;
import DealerStat.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private GameObjectRepository gameObjectRepository;

    @PreAuthorize("hasRole('User')")
    @DeleteMapping("/users/{traderId/comments/{postId}}")
    public String deleteComment(@AuthenticationPrincipal User user,
                                @PathVariable Long postId) {
        Comment comment=commentRepository.getOne(postId);
        if(user==comment.getAuthor_id()) {
            commentRepository.deleteById(postId);
        }
        return "main";
    }

    @GetMapping("/users/{traderId}/comments")
    public String ListOfComments(@PathVariable Long traderId, Model model) {
        Iterable<Comment> allAuthorComments = commentRepository.findAllByAuthorId(traderId);
        model.addAttribute("allComments", allAuthorComments);
        return "/users/{id}/comments";
    }

    @GetMapping("/users/{traderId}/comments/{commentId}")
    public String ViewTraderComment(@PathVariable Long commentId, Model model) {
        model.addAttribute("comment", commentRepository.findById(commentId));
        return "/users/{traderId}/comments/{commentId}";
    }

    @PreAuthorize("hasRole('User')")
    @PostMapping("/articles/{postId}/comments")
    public String AddComment(@AuthenticationPrincipal User user,
                             @PathVariable Long postId,
                             String message) {
        Comment comment = new Comment(message);
        comment.setAuthor_id(user);
        comment.setPost_id(gameObjectRepository.getOne(postId));
        return "main";
    }

}
