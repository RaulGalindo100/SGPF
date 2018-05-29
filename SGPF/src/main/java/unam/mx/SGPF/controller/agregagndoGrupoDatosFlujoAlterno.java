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
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.FlujoAlterno;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

/**
 *
 * @author jlope
 */
public class agregagndoGrupoDatosFlujoAlterno extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        String redireccion="";
        
        FlujoAlterno miFlujoAlterno = (FlujoAlterno) session.getAttribute("FlujoAlternoInsertar");
        int idGrupoDatos = Integer.parseInt(request.getParameter("grupoDatosFA"));
        
        GrupoDatoJpaController grupoDatos = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato MiGrupoDato = grupoDatos.findGrupoDato(idGrupoDatos);
        
        miFlujoAlterno.setIdgrupoDato(MiGrupoDato);
        
        FlujoAlternoJpaController FlujoAlternoJPA = new FlujoAlternoJpaController(EntityProvider.provider());
        
        try{
            FlujoAlternoJPA.create(miFlujoAlterno);
            redireccion = "BuscaProcesoFuncional?idprocesoFuncional=";
            redireccion = redireccion.concat(Integer.toString(miFlujoAlterno.getIdsubProceso().getIdprocesoFuncional().getIdprocesoFuncional()));
        }catch(Exception e){
            redireccion="agregaGrupoDatosFlujoAlterno.jsp?error=1";
        }
        
        response.sendRedirect(redireccion);
    }
    
    
}
