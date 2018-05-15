package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;
import unam.mx.SGPF.model.controller.UsuarioJpaController;

public class gestionUsuariosProyectos extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioJpaController ujpa = new UsuarioJpaController(EntityProvider.provider());
        InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());
        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
        List<InterUP> ListaInterUP = (List<InterUP>)  ijpa.findInterUPEntities();
        List<Usuario> ListaUsuario = (List<Usuario>) ujpa.findUsuarioEntities();
        List<Proyecto> ListaProyectos = (List<Proyecto>) pjpa.findProyectoEntities();
        HttpSession session = request.getSession(true);
        session.setAttribute("ListaInterUP", ListaInterUP);
        session.setAttribute("ListaUsuario", ListaUsuario);
        session.setAttribute("ListaProyectos", ListaProyectos);
        
        response.sendRedirect("gestionaUsuariosProyectos.jsp");
    }
}
