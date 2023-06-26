package com.syrtin.parser.server;

import com.syrtin.parser.repository.InMemoryCustomerRepository;
import com.syrtin.parser.service.CustomerServiceImpl;
import com.syrtin.parser.servlet.CustomerApiServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class CustomerWebServerImpl implements CustomerWebServer {

    private final Server server;

    public CustomerWebServerImpl(int port) {
        server = new Server(port);
    }

    @Override
    public void start() throws Exception {
        if (server.getHandlers().length == 0) {
            initContext();
        }
        server.start();
    }

    @Override
    public void join() throws Exception {
        server.join();
    }

    @Override
    public void stop() throws Exception {
        server.stop();
    }

    private Server initContext() {

        ServletContextHandler servletContextHandler = createServletContextHandler();

        HandlerList handlers = new HandlerList();
        handlers.addHandler(servletContextHandler);

        server.setHandler(handlers);
        return server;
    }

    private ServletContextHandler createServletContextHandler() {
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.addServlet(
                new ServletHolder(
                        new CustomerApiServlet(
                                new CustomerServiceImpl(
                                        new InMemoryCustomerRepository()))), "/api/customer/*");
        return servletContextHandler;
    }
}
