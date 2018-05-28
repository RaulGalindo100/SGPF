/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jlope
 */
public class agregaGrupoDatos extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        session.setAttribute("idSubProceso", idSubProceso);
        
        response.sendRedirect("agregaGrupoDatos.jsp");
    }
}
