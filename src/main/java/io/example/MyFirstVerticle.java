package io.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerRequest;

public class MyFirstVerticle extends AbstractVerticle {

    public void start() {
        vertx.createHttpServer(new HttpServerOptions().setLogActivity(true)).requestHandler(req -> {

            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello World!");
        }).listen(8080);

        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest event) {

            }
        }).listen(8980);
    }
}