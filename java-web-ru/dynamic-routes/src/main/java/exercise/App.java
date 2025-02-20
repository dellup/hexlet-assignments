package exercise;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            long id = ctx.pathParamAsClass("id", Long.class).get();
            ctx.json(findUserById(id));
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }
    public static Map<String, String> findUserById(long id) {
        for (Map<String, String> company : COMPANIES) {
            if (Integer.parseInt(company.get("id")) == id) {
                return company;
            }
        }
        throw new NotFoundResponse("Company not found");
    }
    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
