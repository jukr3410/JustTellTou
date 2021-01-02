/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.ReviewMovie;
import Entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.AssertFalse.List;

/**
 *
 * @author Dell
 */
public class TestServlet extends HttpServlet {

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_JustTellYou_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Users.findAll");
        java.util.List<Users> us = q.getResultList();
        for (Users u : us) {
            System.out.println(u.getUserName());

        }
        Query aa = em.createNamedQuery("ReviewMovie.findAll");
//        List<ReviewMovie> s = aa.getResultList();
//        request.setAttribute("r", a.getResultList());
//        for (int i = 0; i < us.size(); i++) {
//            if(us.get(i).get<=)
//            
//        }
        Query c = em.createQuery("select r from ReviewMovie r ");
        java.util.List<ReviewMovie> ss = c.getResultList();
//
//        List<ReviewMovie> s = c.getResultList();
        java.util.List<ReviewMovie> g = new ArrayList();
//        for (ReviewMovie s : ss) {
//            System.out.println(s);
//            
//        }
        for (int i = 0; i < ss.size(); i++) {
            if (ss.get(i).getRating() == null|| ss.get(i).getReviewText()==null) {
                g.remove(ss.get(i));
               
            }else{ 
                g.add(ss.get(i));
            }
             System.out.println(g.toString());
        }
//            Movie mm = em.find(Movie.class, );
        
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
