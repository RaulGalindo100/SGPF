package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class modificandoUF extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nombreAccion = request.getParameter("nombreUF");
        String descripcion = request.getParameter("descripcionUF");
        int idUF = Integer.parseInt(request.getParameter("idUF"));
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        
        UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
        UsuarioFuncional UF = ufjpa.findUsuarioFuncional(idUF);
        UF.setNomUF(nombreAccion);
        UF.setDescripcion(descripcion);
        UF.setIdproyecto(idProyecto);
        
    	try{
            ufjpa.edit(UF);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect("usuarioFuncional");
        }
       
    }
}
