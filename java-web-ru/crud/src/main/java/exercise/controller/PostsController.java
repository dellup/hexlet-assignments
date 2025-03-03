package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        Long pageNum = ctx.queryParamAsClass("page", Long.class).getOrDefault(1L);
        List<Post> posts = PostRepository.findAll(Math.toIntExact(pageNum), 5);
        PostsPage page = new PostsPage(posts);
        ctx.render("posts/index.jte", model("postsPage", page, "pageNum", pageNum));
    }

    public static void show(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> {
                    ctx.status(404);
                    return new NotFoundResponse("Page not found");
                });
        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", model("postPage", page));
    }
    // END
}
