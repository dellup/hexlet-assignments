package exercise.dto.posts;

import exercise.dto.BasePage;
import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PostPage extends BasePage {
    private Post post;

    public PostPage(Post post) {
        this.post = post;
    }
}
