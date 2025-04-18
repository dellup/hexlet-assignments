package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            UsersPage page = new UsersPage(USERS, "Пользователи");
            ctx.render("users/index.jte", model("page", page));
        });
        app.get("/users/{id}", ctx -> {
           var id = ctx.pathParamAsClass("id", Long.class).get();
           User user = USERS.stream().filter(o -> o.getId() == id).toList().getFirst();
            if (user == null) {
                ctx.status(404).result("User not found");
                return;
            }
           ctx.render("users/show.jte", model("user", user));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
