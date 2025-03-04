package exercise;

import exercise.dto.MainPage;
import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;


public final class App {
    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());

        });
        app.before(ctx -> {
            ctx.header("Content-Type", "text/html; charset=UTF-8");
        });
        // BEGIN
        app.get(NamedRoutes.rootPath(), ctx -> {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.header("Content-Type", "text/html; charset=UTF-8");
            ctx.render("index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);

        app.post(NamedRoutes.loginPath(), SessionsController::create);

        app.post(NamedRoutes.logoutPath(), SessionsController::delete);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7060);
    }
}
