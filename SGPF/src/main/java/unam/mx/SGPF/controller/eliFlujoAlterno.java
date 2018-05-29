/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.FlujoAlterno;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

public class eliFlujoAlterno extends HttpServlet  {
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String redireccion="";
		 int idFA = Integer.parseInt(request.getParameter("idFA"));
		 int idpf = Integer.parseInt(request.getParameter("idPF"));
//                 SubProcesoJpaController spJpa = new SubProcesoJpaController(EntityProvider.provider());
//                 SubProceso subproceso = spJpa.findSubProceso
                 
		 FlujoAlternoJpaController faJpa = new FlujoAlternoJpaController(EntityProvider.provider());
		 FlujoAlterno aux = faJpa.findFlujoAlterno(idFA);
                 List<FlujoAlterno> listaFlujoEliminar = faJpa.findByIdSubProcesoActividad(aux.getIdsubProceso(), aux.getActividad());
                 
		 try {
                        if(listaFlujoEliminar!=null && !listaFlujoEliminar.isEmpty())
                            for(FlujoAlterno FA_Eliminar : listaFlujoEliminar)
                                faJpa.destroy(FA_Eliminar.getIdflujoAlterno());
			 redireccion = "BuscaProcesoFuncional?idprocesoFuncional=";
	         redireccion = redireccion.concat(Integer.toString(idpf));
		 }catch(Exception e){
	            e.printStackTrace();
	     }finally{
	            response.sendRedirect(redireccion);   
	     }
	 }
    
}
