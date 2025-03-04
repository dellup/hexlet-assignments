package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.header("Content-Type", "text/html; charset=UTF-8");
        ctx.render("build.jte", model("page", new LoginPage("", null)));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var passwordHash = encrypt(ctx.formParam("password"));

        try{
            var currentUser = UsersRepository.findByName(name)
                    .orElseThrow(() -> new IllegalArgumentException("Wrong username or password"));
            var currentUserPassword = currentUser.getPassword();
            if (passwordHash.equals(currentUserPassword)) {
                ctx.sessionAttribute("currentUser", name);
                ctx.header("Content-Type", "text/html; charset=UTF-8");
                ctx.redirect("/");
            } else {
                throw new IllegalArgumentException("Wrong username or password");
            }
        } catch (IllegalArgumentException e) {
            var page = new LoginPage(name, e.getMessage());
            ctx.header("Content-Type", "text/html; charset=UTF-8");
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.header("Content-Type", "text/html; charset=UTF-8");
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
