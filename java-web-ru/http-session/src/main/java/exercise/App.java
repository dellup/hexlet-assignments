package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            int start = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int end = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            List<Map<String, String>> list = new ArrayList<>();
            for (int i = end*(start-1); i < end*start; i++) {
                list.add(USERS.get(i));
            }
            ctx.json(list);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
