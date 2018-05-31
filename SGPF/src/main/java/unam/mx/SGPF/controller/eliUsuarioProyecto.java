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
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.controller.InterUPJpaController;

/**
 *
 * @author jlope
 */
public class eliUsuarioProyecto extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    int idusuproy = Integer.parseInt(request.getParameter("idusuproy"));
    InterUP iup = new InterUP();
        InterUPJpaController jpaup = new InterUPJpaController(EntityProvider.provider());
        iup = jpaup.findInterUP(idusuproy);
        short b=0;
        String bla="";
        if(iup.getActivo()==1)
            iup.setActivo(b);
        else{
            b=1;
            iup.setActivo(b);
        }
        try{
            jpaup.edit(iup);
            bla="gestionUsuariosProyectos";
        }catch(Exception e){
            bla = "proyectos.jsp";
        }
        response.sendRedirect(bla);
    }
    
}
