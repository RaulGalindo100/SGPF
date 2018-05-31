package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class agregandoUF extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nombreUF = request.getParameter("nombreUF");
        String descripcionUF = request.getParameter("descripcionUF");
        String aux = request.getParameter("usuarioSistema");
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        Short usuarioSistema = 0;
        if(aux!=null){
            usuarioSistema = 1;
        }
        Short activo = 1;
        
        UsuarioFuncional usuarioFuncional = new UsuarioFuncional();
        usuarioFuncional.setNomUF(nombreUF);
        usuarioFuncional.setDescripcion(descripcionUF);
        usuarioFuncional.setActivo(activo);
        usuarioFuncional.setUsuarioSistema(usuarioSistema);
        usuarioFuncional.setIdproyecto(idProyecto);
        
    	UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
    	try{
            ufjpa.create(usuarioFuncional);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect("usuarioFuncional");
        }
       
    }
}
