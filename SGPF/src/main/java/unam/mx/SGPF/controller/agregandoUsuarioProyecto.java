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

public class agregandoUsuarioProyecto extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redireccion="";
        int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
        int IdProyecto = Integer.parseInt(request.getParameter("IdProyecto"));
        Proyecto proyecto = new Proyecto(IdProyecto);
        Usuario usuario = new Usuario(IdUsuario);
        InterUP interUP = new InterUP();
        interUP.setIdproyecto(proyecto);
        interUP.setIdusuario(usuario);
        InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());
        try{
           ijpa.create(interUP);
           redireccion="gestionUsuariosProyectos";
        }catch(Exception e){
           redireccion="agregaUsuarioProyecto.jsp?error=1";
           e.printStackTrace();
        }finally{
            response.sendRedirect(redireccion);
        }
    }
}
