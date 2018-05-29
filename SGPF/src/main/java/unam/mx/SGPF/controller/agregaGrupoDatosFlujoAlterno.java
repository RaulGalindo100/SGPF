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
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.FlujoAlterno;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;

/**
 *
 * @author jlope
 */
public class agregaGrupoDatosFlujoAlterno extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        int idFlujoAlterno = Integer.parseInt(request.getParameter("idFlujoAlterno"));
        
        FlujoAlternoJpaController FlujoAlternoJPA = new FlujoAlternoJpaController(EntityProvider.provider());
        FlujoAlterno FlujoAlterno = new FlujoAlterno();
        FlujoAlterno = FlujoAlternoJPA.findFlujoAlterno(idFlujoAlterno);
        
        session.setAttribute("FlujoAlternoInsertar", FlujoAlterno);
        
        response.sendRedirect("agregaGrupoDatosFlujoAlterno.jsp");
    }
    
}
