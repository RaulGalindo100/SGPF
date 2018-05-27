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
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

public class eliActividad extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso aux = SubProcesoJPA.findSubProceso(idSubProceso);
        int indiceAnteriorActividad = aux.getIndiceActividad();
        int idPFAnterior = aux.getIdprocesoFuncional().getIdprocesoFuncional();
        ProcesoFuncional PF_Actual = aux.getIdprocesoFuncional();
        List<SubProceso> listaSPEliminar = SubProcesoJPA.findSPByActividadyPF(aux.getActividad(),aux.getIdprocesoFuncional());
        FlujoAlternoJpaController FlujoAlternoJPA = new FlujoAlternoJpaController(EntityProvider.provider());
        try{
            if(listaSPEliminar!=null && !listaSPEliminar.isEmpty())
            listaSPEliminar.forEach((action) -> {
                //Eliminar Flujos Alternos
                List<FlujoAlterno> listaFlujosAlterno = FlujoAlternoJPA.findByIdSubProceso(aux);
                if(listaFlujosAlterno!=null && !listaFlujosAlterno.isEmpty()){
                    listaFlujosAlterno.forEach((iter) -> {
                    try{ FlujoAlternoJPA.destroy(iter.getIdflujoAlterno()); }catch(Exception r){}});
                }
            try{SubProcesoJPA.destroy(action.getIdsubProceso());}catch(Exception J){}
            });
            
            //Actualizar los índices de las actividades
            List<SubProceso> listaSPActualizar = SubProcesoJPA.findSPByIndiceActividadMayor(idPFAnterior, indiceAnteriorActividad);
            if(listaSPActualizar!=null && !listaSPActualizar.isEmpty())
                listaSPActualizar.forEach((action)->{
                    int indiceActAnterio = action.getIndiceActividad();
                    action.setIndiceActividad(indiceActAnterio-1);
                    try{SubProcesoJPA.edit(action);}catch(Exception e){}
                });
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            HttpSession session = request.getSession(true);
            session.setAttribute("PF_Actual", PF_Actual);
            response.sendRedirect("eliminadoSubProceso.jsp");   
        }
    }
}
