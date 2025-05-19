package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        PostDTO postDTO = new PostDTO();
        var post = postRepository
                .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        postDTO.setId(id);
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        var comments = commentRepository
                .findByPostId(post.getId())
                .stream().map(o -> {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(o.getId());
            commentDTO.setBody(o.getBody());
            return commentDTO;
        }).toList();
        postDTO.setComments(comments);
        return postDTO;
    }

    @GetMapping("")
    public List<PostDTO> index() {
        return postRepository.findAll().stream()
                .map(o -> {
                    PostDTO postDTO = new PostDTO();
                    postDTO.setId(o.getId());
                    postDTO.setTitle(o.getTitle());
                    postDTO.setBody(o.getBody());
                    return postDTO;
                }).toList();
    }
}
// END
