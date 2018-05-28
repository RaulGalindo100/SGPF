/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.FlujoAlterno;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

/**
 *
 * @author jlope
 */
public class agregandoFlujoAlterno extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        SubProceso SubProceso = (SubProceso) session.getAttribute("SubProceso");
        String redireccion = "";
        
        String descripcionFA = request.getParameter("descripcionFA");
        int usuarioFuncionalFA = Integer.parseInt(request.getParameter("usuarioFuncionalFA"));
        int accionFA = Integer.parseInt(request.getParameter("accionFA"));
        int grupoDatosFA = Integer.parseInt(request.getParameter("grupoDatosFA"));
        
        FlujoAlterno aux = new FlujoAlterno();
        aux.setActividad(SubProceso.getActividad());
        aux.setIdsubProceso(SubProceso);
        aux.setDescripcion(descripcionFA);
        
        UsuarioFuncionalJpaController usuarioFuncional = new UsuarioFuncionalJpaController(EntityProvider.provider());
        UsuarioFuncional MiUsuarioFuncional = usuarioFuncional.findUsuarioFuncional(usuarioFuncionalFA);
        aux.setIdusuarioFuncional(MiUsuarioFuncional);
        
        AccionJpaController accion = new AccionJpaController(EntityProvider.provider());
        Accion MiAccion = accion.findAccion(accionFA);
        aux.setIdaccion(MiAccion);
        
        GrupoDatoJpaController grupoDatos = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato MiGrupoDato = grupoDatos.findGrupoDato(grupoDatosFA);
        aux.setIdgrupoDato(MiGrupoDato);
        
        FlujoAlternoJpaController FlujoAlternoJPA = new FlujoAlternoJpaController(EntityProvider.provider());
       
        try{
            FlujoAlternoJPA.create(aux);
            redireccion = "BuscaProcesoFuncional?idprocesoFuncional=";
            redireccion = redireccion.concat(Integer.toString(SubProceso.getIdsubProceso()));
            
        }catch(Exception e){
            redireccion = "detallePF.jsp";
        }
        
        response.sendRedirect(redireccion);
        
    }
    
}
