package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            var page = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + page + "!");
        });


        app.get("/users/{id}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
        });
        app.get("/post/{postId}", ctx -> {
            ctx.result("Post ID: " + ctx.pathParam("postId"));
        });
        

        app.start(7070); // Стартуем веб-сервер
    }
}
