package com.syrtin.parser;

import com.syrtin.parser.server.CustomerWebServer;
import com.syrtin.parser.server.CustomerWebServerImpl;

public class GsonTestParserApplication {
    private static final int WEB_SERVER_PORT = 8080;

    public static void main(String[] args) throws Exception {

        CustomerWebServer customerWebServer = new CustomerWebServerImpl(WEB_SERVER_PORT);

        customerWebServer.start();
        customerWebServer.join();
    }
}
