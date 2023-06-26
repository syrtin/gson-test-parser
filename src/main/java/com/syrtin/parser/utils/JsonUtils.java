package com.syrtin.parser.utils;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static <T> T getObjectFromRequest1(HttpServletRequest request, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(request.getAttribute("attributeName"));
            return gson.fromJson(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T getObjectFromRequest2(HttpServletRequest request, Class<T> clazz) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();
        T object = gson.fromJson(reader.lines().collect(Collectors.joining()), clazz);
        return object;
    }

    public static <T> T getObjectFromRequest3(HttpServletRequest request, Class<T> clazz) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        T object = gson.fromJson(reader, clazz);
        reader.close();
        return object;
    }

    public static <T> T getObjectFromRequest4(HttpServletRequest request, Class<T> clazz) throws IOException {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            T object = gson.fromJson(reader, clazz);
            return object;
        }
    }

    public static <T> T getObjectFromRequest5(HttpServletRequest request, Class<T> clazz) throws IOException {
        try (BufferedReader reader = request.getReader()) {
            return gson.fromJson(reader, clazz);
        }
    }

    public static <T> T getObjectFromRequest6(HttpServletRequest request, Class<T> clazz) throws IOException {
        try (var reader = request.getReader()) {
            return gson.fromJson(reader, clazz);
        }
    }

    public static <T> T getObjectFromRequest7(HttpServletRequest request, Class<T> clazz) throws IOException {
        try (BufferedReader reader = request.getReader()) {
            String jsonString = reader.lines().reduce("", (accumulator, actual) -> accumulator + actual);
            return gson.fromJson(jsonString, clazz);
        }
    }

    public static <T> T getObjectFromRequest8(HttpServletRequest request, Class<T> clazz) throws IOException {
        try (BufferedReader reader = request.getReader()) {
            String jsonString = reader.lines().collect(Collectors.joining());
            return gson.fromJson(jsonString, clazz);
        }
    }

    public static <T> T getObjectFromRequest9(HttpServletRequest request, Class<T> clazz) throws IOException {
        try (BufferedReader reader = request.getReader()) {
            Gson gson = new Gson();
            return gson.fromJson(reader, clazz);
        }
    }

    public static <T> T getObjectFromRequest10(HttpServletRequest request, Class<T> clazz) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()), 8192)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, clazz);
        }
    }

    public static <T> T getObjectFromRequest11(HttpServletRequest request, Class<T> clazz) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(request.getInputStream()), 8192)) {
            return gson.fromJson(reader, clazz);
        }
    }

}