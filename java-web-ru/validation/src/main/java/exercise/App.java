package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;
import io.javalin.validation.ValidationException;

public final class App {

    public static Javalin getApp() {


        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.before(ctx -> ctx.contentType("text/html; charset=utf-8"));

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            var titleValue = ctx.formParam("title");
            var contentValue = ctx.formParam("content");

            try {
                var title = ctx.formParamAsClass("title", String.class)
                        .check(o -> o.length() >= 2, "Название не должно быть короче двух символов")
                        .check(o -> !ArticleRepository.existsByTitle(o), "Статья с таким названием уже существует")
                        .get();

                var content = ctx.formParamAsClass("content", String.class)
                        .check(d -> d != null && !d.trim().isEmpty(), "Текст не должен быть пустым")
                        .check(d -> d.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();

                ArticleRepository.save(new Article(title, content));
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                ctx.status(422);
                var page = new BuildArticlePage(titleValue, contentValue, e.getErrors());
                ctx.render("articles/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
