package com.sda;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer a = mapToInteger(req.getParameter("a"));
        Integer b = mapToInteger(req.getParameter("b"));

        int result = a + b;

        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Wynik " + a + " + " + b + " = " + result + "</h1>");
    }

    private Integer mapToInteger(String param) {
        return Optional.ofNullable(param)
                .filter(e -> StringUtils.isNumeric(e))
                .map(e -> Integer.valueOf(e))
                .orElse(0);
    }
}
