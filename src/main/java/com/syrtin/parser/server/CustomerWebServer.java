package com.syrtin.parser.server;

public interface CustomerWebServer {
    void start() throws Exception;

    void join() throws Exception;

    void stop() throws Exception;
}
