package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

public class addSubProceso extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //cachar IDdelSubProceso que lo manda llamar y mandarlo para cacharlo con POST en el addSubProceso.jsp
        
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso SubProceso = SubProcesoJPA.findSubProceso(idSubProceso);
       
        
        
        HttpSession session = request.getSession(true);
        session.setAttribute("SubProceso", SubProceso);
        session.setAttribute("opcionSPDetallePF", opcion);
        session.setAttribute("idSPDetallePF", idSubProceso);
        
        response.sendRedirect("addSubProceso.jsp");
        
    }
}
