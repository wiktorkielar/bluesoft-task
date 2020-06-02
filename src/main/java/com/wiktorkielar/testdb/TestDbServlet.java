package com.wiktorkielar.testdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(TestDbServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost/";
        String user = "postgres";
        String password = "postgres";

        try {
            PrintWriter printWriter = resp.getWriter();
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            logger.info("Connection successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
