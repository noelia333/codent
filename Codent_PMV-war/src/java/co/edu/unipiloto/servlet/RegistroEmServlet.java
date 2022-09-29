/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.entitys.Registroemergencia;
import co.edu.unipiloto.session.RegistroemergenciaFacadeLocal;
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
@WebServlet(name = "RegistroEmServlet", urlPatterns = {"/RegistroEmServlet"})
public class RegistroEmServlet extends HttpServlet {

    @EJB
    private RegistroemergenciaFacadeLocal registroemergenciaFacade;
  
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
        
        String idStr = request.getParameter("emergenciaId");
        int emid = 0;
        if (idStr != null && !idStr.equals("")) {
            emid = Integer.parseInt(idStr);
        }

        String descripcionStr = request.getParameter("emergenciaDescr");
        
        String estadoStr = request.getParameter("emergenciaEstado");
        boolean estem = false;
        if (estadoStr != null && !estadoStr.equals("")) {          
            estem = Boolean.valueOf(estadoStr);
        }
    
        Registroemergencia regEm = new Registroemergencia(emid, descripcionStr, estem);
        
        if("Add".equalsIgnoreCase(action)){
            registroemergenciaFacade.create(regEm);
        }else if("Search".equalsIgnoreCase(action)){
            registroemergenciaFacade.find(emid);
        }else if("Edit".equalsIgnoreCase(action)){
            registroemergenciaFacade.edit(regEm);
        }else if("Delete".equalsIgnoreCase(action)){
            registroemergenciaFacade.remove(regEm);
        }
        
        //string de conexion nos vamos a persistence.xml en data source jdbc/estudiante
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("registroemergencia", regEm);
        request.setAttribute("allRegistroEmergencias", registroemergenciaFacade.findAll());
        request.getRequestDispatcher("emergenciaInfo.jsp").forward(request, response);
        
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
