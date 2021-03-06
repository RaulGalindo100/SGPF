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
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.SubprocesoGrupoDato;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import unam.mx.SGPF.model.controller.SubprocesoGrupoDatoJpaController;

public class agregagndoGrupoDatos extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String redireccion="";
        
        int idGrupoDatos = Integer.parseInt(request.getParameter("grupoDatosFA"));
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController subPjpa = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso auxSP = subPjpa.findSubProceso(idSubProceso);
        
        GrupoDatoJpaController grupoDatos = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato MiGrupoDato = grupoDatos.findGrupoDato(idGrupoDatos);
        
        SubprocesoGrupoDato aux2 = new SubprocesoGrupoDato();
        aux2.setIdGrupoDato(MiGrupoDato);
        aux2.setIdSubProceso(auxSP);
        SubprocesoGrupoDatoJpaController spgdjpa = new SubprocesoGrupoDatoJpaController(EntityProvider.provider());
        
        try{
            spgdjpa.create(aux2);
            redireccion = "BuscaProcesoFuncional?idprocesoFuncional=";
            redireccion = redireccion.concat(Integer.toString(auxSP.getIdprocesoFuncional().getIdprocesoFuncional()));
        }catch(Exception e){
             redireccion="agregaGrupoDatos.jsp?error=1";
        }finally{
            response.sendRedirect(redireccion);
        }     
    }
}
