
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.Users;

import com.mysql.cj.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author Dell
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("com.mycompany_JustTellYou_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        String UserName = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Fname = request.getParameter("Fname");
        String Lname = request.getParameter("Lname");
        String Email = request.getParameter("Email");

        Users u = em.find(Users.class, UserName);
        if (u == null) {
            Users newUser = new Users();
            newUser.setUserName(UserName);
            newUser.setPassword(Password);
            newUser.setFname(Fname);
            newUser.setLname(Lname);
            newUser.setEmail(Email);

            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();

            HttpSession session = request.getSession();
            session.setAttribute("user", newUser);
            request.getRequestDispatcher("/Index").forward(request, response);

        } else {
            request.setAttribute("message", "Duplicate Username,Password or Email");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
