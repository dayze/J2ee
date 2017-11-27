package fr.unicaen.dez.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unicaen.dez.person.*;

public class withoutIdPerson extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result;
        PrintWriter out = response.getWriter();
        PersonDBStub personDB = PersonDB.getInstance();
        ObjectMapper mapper = new ObjectMapper();
        result = mapper.writeValueAsString(personDB.readAll());
        response.setContentType("application/json");
        response.getWriter().write(result);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        PersonDBStub personDB = PersonDB.getInstance();
        ObjectMapper mapper = new ObjectMapper();
    }
}
