/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.Proyecto;

import javax.servlet.http.HttpServlet;
import unam.mx.SGPF.model.Historico;
import unam.mx.SGPF.model.controller.HistoricoJpaController;

/**
 *
 * @author jlope
 */
public class consultaHistorico extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        String nomProy = request.getParameter("nomProy");
        Proyecto proyecto = new Proyecto();
        proyecto.setIdproyecto(idProyecto);
        HistoricoJpaController historicoJpa = new HistoricoJpaController(EntityProvider.provider());
        List<Historico> listaProyectos = historicoJpa.findHistoricoByIdProyecto(proyecto);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("listaProyectos", listaProyectos);
        session.setAttribute("nomProy", nomProy);
        
        response.sendRedirect("consultaHistoricos.jsp");
       
    }
}
