package com.example;

import io.undertow.Undertow;
import io.undertow.util.Headers;
import io.undertow.util.StatusCodes;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        Undertow.builder()
                .addHttpListener(80, "0.0.0.0")
                .setHandler(exchange -> {
                    exchange.setStatusCode(StatusCodes.OK);
                    exchange.getRequestHeaders()
                            .put(Headers.CONTENT_TYPE, "application/json;");
                    exchange.getResponseSender().send("{\"status\": \"success\"}");
                })
                .build()
                .start();
    }
}
