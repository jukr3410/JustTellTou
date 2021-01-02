/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.Movie;
import Entity.ReviewMovie;
import Entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class WriteReviewServlet extends HttpServlet {

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
           request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("com.mycompany_JustTellYou_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        HttpSession session = request.getSession();
//        String user = (String)session.getAttribute("user");
        Movie movie = (Movie) session.getAttribute("movieID");
        ReviewMovie id = em.find(ReviewMovie.class, movie.getMovieID());
//        System.out.println(movieID);
//        session.removeAttribute("movieID");
        String review = request.getParameter("review");
        String rating = request.getParameter("rating");
        double r = Double.parseDouble(rating);

        if (session.getAttribute("user") != null) {
            em.getTransaction().begin();
            id.setReviewText(review);
            id.setRating(r);

            em.getTransaction().commit();
//            request.setAttribute("r", id);
//             request.setAttribute("id", id);
        }
        session.setAttribute("movieID",movie.getMovieID());
        response.sendRedirect("/JustTellYou/Review?movieID=" + session.getAttribute("movieID"));
        session.removeAttribute("movieID");
//            request.getRequestDispatcher("/ReviewMovie").forward(request, response);
//            return;
//          request.getRequestDispatcher("/Index").forward(request, response);
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
