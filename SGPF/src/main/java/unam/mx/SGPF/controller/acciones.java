package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.controller.AccionJpaController;


public class acciones extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
                List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
                
		AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
                
                ArrayList<Accion> listaAcciones = new ArrayList<Accion>();
                inters.forEach((iter)->{
                    List<Accion> ac = ajpa.findAccionOrdered(iter.getIdproyecto());
                    listaAcciones.addAll(ac);
                });
		
		session.setAttribute("action",listaAcciones);
		
		response.sendRedirect("acciones.jsp");
	}
        
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
                
		List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
                
		AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
                
                ArrayList<Accion> listaAcciones = new ArrayList<Accion>();
                inters.forEach((iter)->{
                    List<Accion> ac = ajpa.findAccionOrdered(iter.getIdproyecto());
                    listaAcciones.addAll(ac);
                });
		
		session.setAttribute("action",listaAcciones);
		
		response.sendRedirect("acciones.jsp");
	}
}
