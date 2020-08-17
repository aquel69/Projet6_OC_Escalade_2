package fr.alardon.escalade.webapp.servlet;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Contact")
public class Contact extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(("do get contact"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/contact.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("do post contact");

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/contact.jsp").forward(request, response);
    }
}
