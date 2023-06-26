package com.syrtin.parser.servlet;

import com.syrtin.parser.service.CustomerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerApiServlet extends HttpServlet {

    private final CustomerService service;

    public CustomerApiServlet(CustomerService service) {
        this.service = service;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        service.parseAndSave(request);
        response.setStatus(200);
    }
}
