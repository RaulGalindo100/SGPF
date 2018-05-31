package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class usuarioFuncional extends HttpServlet{
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
                
                List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
                
                UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
                
                ArrayList<UsuarioFuncional> listaUsuarioFuncional = new ArrayList<UsuarioFuncional>();
                inters.forEach((iter)->{
                    List<UsuarioFuncional> uf = ufjpa.findUsuarioFuncionalOrdered(iter.getIdproyecto());
                    listaUsuarioFuncional.addAll(uf);
                });
		
		session.setAttribute("usuarioFuncional",listaUsuarioFuncional);
		
		response.sendRedirect("usuarioFuncional.jsp");
	}
        
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
                
                UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
                
                ArrayList<UsuarioFuncional> listaUsuarioFuncional = new ArrayList<UsuarioFuncional>();
                inters.forEach((iter)->{
                    List<UsuarioFuncional> uf = ufjpa.findUsuarioFuncionalOrdered(iter.getIdproyecto());
                    listaUsuarioFuncional.addAll(uf);
                });
		
		session.setAttribute("usuarioFuncional",listaUsuarioFuncional);
		
		response.sendRedirect("usuarioFuncional.jsp");
	}
}
