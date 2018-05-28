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
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.FlujoAlterno;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;

public class eliFlujoAlterno extends HttpServlet  {
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String redireccion="";
		 int idFA = Integer.parseInt(request.getParameter("idFA"));
		 int idpf = Integer.parseInt(request.getParameter("idPF"));
		 FlujoAlternoJpaController faJpa = new FlujoAlternoJpaController(EntityProvider.provider());
		 FlujoAlterno aux = faJpa.findFlujoAlterno(idFA);
		 
		 
		 try {
			 faJpa.destroy(aux.getIdflujoAlterno());
			 redireccion = "BuscaProcesoFuncional?idprocesoFuncional=";
	         redireccion = redireccion.concat(Integer.toString(idpf));
		 }catch(Exception e){
	            e.printStackTrace();
	     }finally{
	            response.sendRedirect(redireccion);   
	     }
	 }
    
}
