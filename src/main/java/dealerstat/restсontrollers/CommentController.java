package dealerstat.restсontrollers;

import dealerstat.domain.entites.User;
import dealerstat.service.CommentService;
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
    private CommentService commentService;


    @PreAuthorize("hasRole('User')")
    @DeleteMapping("/users/{traderID}/comments/{postID}}")
    public String deleteComment(@AuthenticationPrincipal User user,
                                @PathVariable Long postID) {
       return commentService.deleteComment(postID, user);
    }

    @GetMapping("/users/{traderID}/comments")
    public String ListOfComments(@PathVariable Long traderID, Model model) {
        return commentService.listOfComments(traderID, model);
    }

    @GetMapping("/users/{traderID}/comments/{commentID}")
    public String ViewTraderComment(@PathVariable Long commentID, Model model) {
        return commentService.ViewTraderComment(commentID, model);
    }

    @PreAuthorize("hasRole('User')")
    @PostMapping("/articles/{postID}/comments")
    public String AddComment(@AuthenticationPrincipal User user,
                             @PathVariable Long postID,
                             String message) {
      return commentService.AddComment(user, postID, message);
    }

}
