package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;

public class modificandoGrupoDato extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nombreGD = request.getParameter("nombreGD");
        String descripcionGD = request.getParameter("descripcionGD");
        int idGD = Integer.parseInt(request.getParameter("idGD"));
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        
        GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato GD = gdjpa.findGrupoDato(idGD);
        GD.setNomGD(nombreGD);
        GD.setDescripcion(descripcionGD);
        GD.setIdproyecto(idProyecto);
        
    	try{
            gdjpa.edit(GD);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect("grupoDatos");
        }
       
    }
}
