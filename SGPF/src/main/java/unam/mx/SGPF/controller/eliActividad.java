package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

public class eliActividad extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso aux = SubProcesoJPA.findSubProceso(idSubProceso);
        List<SubProceso> listaSPEliminar = SubProcesoJPA.findSPByActividadyPF(aux.getActividad(),aux.getIdprocesoFuncional());
        try{
            SubProcesoJPA.destroy(idSubProceso);
            if(listaSPEliminar!=null && !listaSPEliminar.isEmpty())
            listaSPEliminar.forEach((action) -> {
                //Eliminar Flujos Alternos
                try{SubProcesoJPA.destroy(action.getIdsubProceso());}catch(Exception J){}
            });
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect("eliminadoSubProceso.jsp");   
        }
    }
}
