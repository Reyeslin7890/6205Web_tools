package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        String remember = request.getParameter("rememberMe");
            
        if(action.equals("login")) {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //Normally, we will need to connect to the DB to validate username/password
            //DB Connection will be discussed later
            //For now, we assume, username: admin, password: secret
            if (username.equals("admin") && password.equals("admin")) {
                //username/password correct, go to search page
                //add username to the session
                if (remember!=null){ 
                    Cookie cookie1 = new Cookie("username",username);
                    cookie1.setMaxAge(60);
                    Cookie cookie2 = new Cookie("password",password);
                    cookie2.setMaxAge(60);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }

                session.setAttribute("username", username);
                response.sendRedirect("searchCourse.jsp");
            } else {
                response.sendRedirect("index.jsp");
                //username/password not correct, send user to error-page or login page
            }
        } else if (action.equals("logout")) {
            //invalidate() removes all the objects from the session
            session.invalidate();
            response.sendRedirect("index.jsp");
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
