/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.Categories;
import Entity.Movie;
import Entity.ReviewMovie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class SearchServlet extends HttpServlet {

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_JustTellYou_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        String searchName = request.getParameter("search");

        String sql = "SELECT p FROM Movie p WHERE p.movieName like :pn ";
        Query qry = em.createQuery(sql);
        qry.setParameter("pn", "%" + searchName + "%");
//        qry.setParameter("pn", "t%");
        List<Movie> pd = qry.getResultList();
        List<Movie> m = new ArrayList();
        List<ReviewMovie> mn = new ArrayList();

        for (Iterator<Movie> ii = pd.iterator(); ii.hasNext();) {
            Movie rm = ii.next();

            ReviewMovie mmm = em.find(ReviewMovie.class, rm.getMovieID());

            mn.add(mmm);

        }

//        for (Movie mn : pd) {
//            System.out.println(mn.getMovieName());
//            
//        
//        String sql = "SELECT c FROM Categories c WHERE c.catID = :catID";
//        Query qry = em.createQuery(sql);
//        qry.setParameter("catID",searchName);
//        qry.setParameter("pn", "t%");
        Query a = em.createNamedQuery("Categories.findAll");
        request.setAttribute("Cat", a.getResultList());

        request.setAttribute("mn", mn);
        request.getRequestDispatcher("/SearchMovie.jsp").forward(request, response);
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
