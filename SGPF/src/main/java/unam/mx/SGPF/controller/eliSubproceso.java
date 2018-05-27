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

public class eliSubproceso extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redireccion="";
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso aux = SubProcesoJPA.findSubProceso(idSubProceso);
        
        FlujoAlternoJpaController FlujoAlternoJPA = new FlujoAlternoJpaController(EntityProvider.provider());
        List<FlujoAlterno> listaFlujosAlterno = FlujoAlternoJPA.findByIdSubProceso(aux);
        if(listaFlujosAlterno!=null && !listaFlujosAlterno.isEmpty()){
            listaFlujosAlterno.forEach((iter) -> {
                try{
                    FlujoAlternoJPA.destroy(iter.getIdflujoAlterno());
                }catch(Exception r){}
            });
        }
        
        try{
            
            int idPF = aux.getIdprocesoFuncional().getIdprocesoFuncional();
            int indiceSPEliminado = aux.getIndice();
            String actividadSPEliminado = aux.getActividad();
            ProcesoFuncional pfSPEliminado = aux.getIdprocesoFuncional();
            
            SubProcesoJPA.destroy(aux.getIdsubProceso());
            
            List<SubProceso> listaSPActualizarInd = SubProcesoJPA.findSPByActividadMayorAIndice(indiceSPEliminado, pfSPEliminado, actividadSPEliminado);
            if(listaSPActualizarInd!=null && !listaSPActualizarInd.isEmpty()){
                listaSPActualizarInd.forEach((SPActualizar) -> {
                    int indiceAnterior = SPActualizar.getIndice();
                    SPActualizar.setIndice(indiceAnterior-1);
                    try{
                        SubProcesoJPA.edit(SPActualizar);
                    }catch(Exception R){}
                });
            }
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
