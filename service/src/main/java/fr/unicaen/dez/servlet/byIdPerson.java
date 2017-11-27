package fr.unicaen.dez.servlet;

import fr.unicaen.dez.person.PersonDBStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class byIdPerson extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        PersonDBStub personDB = PersonDB.getInstance();
        out.println("GET :id");
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        PersonDBStub personDB = PersonDB.getInstance();
        //out.println(personDB.readAll().toString());
        out.println("DELETE :id");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        PersonDBStub personDB = PersonDB.getInstance();
        //out.println(personDB.readAll().toString());
        out.println("PUT :id");
    }
}
