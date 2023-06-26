package com.syrtin.parser.service;

import jakarta.servlet.http.HttpServletRequest;

public interface CustomerService {
    void parseAndSave(HttpServletRequest request);
}
