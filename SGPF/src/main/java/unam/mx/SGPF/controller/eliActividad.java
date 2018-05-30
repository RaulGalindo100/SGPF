package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import unam.mx.SGPF.model.SubprocesoGrupoDato;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import unam.mx.SGPF.model.controller.SubprocesoGrupoDatoJpaController;

public class eliActividad extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String redireccion="";
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        //Obtener el Subproceso - ACTIVIDAD
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso aux = SubProcesoJPA.findSubProceso(idSubProceso);
        
        //Guardo los ìndices
        int indiceAnteriorActividad = aux.getIndiceActividad();
        int idPFAnterior = aux.getIdprocesoFuncional().getIdprocesoFuncional();
        
        ProcesoFuncional PF_Actual = aux.getIdprocesoFuncional();
        
        //Obtener los SP de la actividad
        List<SubProceso> listaSPEliminar = SubProcesoJPA.findSPByActividadyPF(aux.getActividad(),aux.getIdprocesoFuncional());
        FlujoAlternoJpaController FlujoAlternoJPA = new FlujoAlternoJpaController(EntityProvider.provider());
        
        SubprocesoGrupoDatoJpaController subgdJpa = new SubprocesoGrupoDatoJpaController(EntityProvider.provider());
        
        //Ontener dependencias
        ArrayList<FlujoAlterno> listaFAEliminar = new ArrayList<FlujoAlterno>();
        ArrayList<SubprocesoGrupoDato> listaSPGDEliminar = new ArrayList<SubprocesoGrupoDato>();
        //List<FlujoAlterno> listaFAEliminar = Collections.emptyList();
        //List<SubprocesoGrupoDato> listaSPGDEliminar = Collections.emptyList();
        for(SubProceso iter : listaSPEliminar){
                //Obtener la lista de Subproceso-grupoDato del SP
                List<SubprocesoGrupoDato> listaSubprocesoGrupoDato = subgdJpa.findByIdSP(iter);
                if(listaSubprocesoGrupoDato!=null && !listaSubprocesoGrupoDato.isEmpty())
                    listaSPGDEliminar.addAll(listaSubprocesoGrupoDato);
        
                //Obtener la lista de FA del SP
                List<FlujoAlterno> listaFlujosAlterno = FlujoAlternoJPA.findByIdSubProceso(iter);
                if(listaFlujosAlterno!=null && !listaFlujosAlterno.isEmpty())
                    listaFAEliminar.addAll(listaFlujosAlterno);
        }
        
        int idPF = aux.getIdprocesoFuncional().getIdprocesoFuncional();
        try{
            listaFAEliminar.forEach((iter)->{
                try{FlujoAlternoJPA.destroy(iter.getIdflujoAlterno());}catch(Exception w){}
            });
            
            listaSPGDEliminar.forEach((iter)->{
                try{subgdJpa.destroy(iter.getIdsubprocesoGrupoDato());}catch(Exception s){}
            });
            
            listaSPEliminar.forEach((iter)->{ 
                try{SubProcesoJPA.destroy(iter.getIdsubProceso());}catch(Exception t){}
            });
            
            //Actualizar los índices de las actividades
            List<SubProceso> listaSPActualizar = SubProcesoJPA.findSPByIndiceActividadMayor(idPFAnterior, indiceAnteriorActividad);
            if(listaSPActualizar!=null && !listaSPActualizar.isEmpty())
                listaSPActualizar.forEach((action)->{
                    int indiceActAnterio = action.getIndiceActividad();
                    action.setIndiceActividad(indiceActAnterio-1);
                    try{SubProcesoJPA.edit(action);}catch(Exception e){}
                });
            HttpSession session = request.getSession(true);
            session.setAttribute("idPF", idPF);
            redireccion = "BuscaProcesoFuncional?idprocesoFuncional=";
            redireccion = redireccion.concat(Integer.toString(idPF));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            HttpSession session = request.getSession(true);
            session.setAttribute("PF_Actual", PF_Actual);
            response.sendRedirect(redireccion);
            //response.sendRedirect("eliminadoSubProceso.jsp");   
        }
    }
}
