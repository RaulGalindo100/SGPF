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
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

/**
 *
 * @author jlope
 */
public class agregaFlujoAlterno extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //cachar IDdelSubProceso que lo manda llamar y mandarlo para cacharlo con POST en el addSubProceso.jsp
        
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso SubProceso = SubProcesoJPA.findSubProceso(idSubProceso);
       
        HttpSession session = request.getSession(true);
        session.setAttribute("SubProceso", SubProceso);
        
        response.sendRedirect("agregaFlujoAlterno.jsp");
        
    }
    
}
