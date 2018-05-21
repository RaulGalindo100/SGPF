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

public class eliSubproceso extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redireccion="";
        String eliminar="E-L-I-M-I-N-A-D-O";
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso aux = SubProcesoJPA.findSubProceso(idSubProceso);
        aux.setActividad(eliminar);
        try{
            int idPF = aux.getIdprocesoFuncional().getIdprocesoFuncional();
            SubProcesoJPA.destroy(aux.getIdsubProceso());
            HttpSession session = request.getSession(true);
            session.setAttribute("idPF", idPF);
            redireccion = "BuscaProcesoFuncional?idprocesoFuncional=";
            redireccion = redireccion.concat(Integer.toString(idPF));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect(redireccion);   
        }
    }
}
