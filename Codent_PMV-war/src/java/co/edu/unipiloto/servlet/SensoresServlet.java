/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.entitys.Sensores;
import co.edu.unipiloto.session.SensoresFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Noelia
 */
@WebServlet(name = "SensoresServlet", urlPatterns = {"/SensoresServlet"})
public class SensoresServlet extends HttpServlet {

    @EJB
    private SensoresFacadeLocal sensoresFacade;

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
        
        String action = request.getParameter("action");

        String idStr = request.getParameter("sensorId");
        int senid = 0;
        if (idStr != null && !idStr.equals("")) {
            senid = Integer.parseInt(idStr);
        }

        String ubicacionStr = request.getParameter("ubicacion");

        String estadoStr = request.getParameter("estado");
        boolean estsen = false;
        if (estadoStr != null && !estadoStr.equals("")) {
            estsen = Boolean.valueOf(estadoStr);
        }

        Sensores sensor = new Sensores(senid, ubicacionStr, estsen);

        if ("Add".equalsIgnoreCase(action)) {
            sensoresFacade.create(sensor);
        } else if ("Search".equalsIgnoreCase(action)) {
            sensoresFacade.find(senid);
        } else if ("Edit".equalsIgnoreCase(action)) {
            sensoresFacade.edit(sensor);
        } else if ("Delete".equalsIgnoreCase(action)) {
            sensoresFacade.remove(sensor);
        }

        //string de conexion nos vamos a persistence.xml en data source jdbc/estudiante
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("sensores", sensor);
        request.setAttribute("allSensores", sensoresFacade.findAll());
        request.getRequestDispatcher("sensoresInfo.jsp").forward(request, response);
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
