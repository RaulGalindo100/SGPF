package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import java.util.List;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.SubprocesoGrupoDato;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.SubprocesoGrupoDatoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class agregandoActividad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//VARIABLES QUE PROVIENEN DEL FORM modificaPF.jsp
        String redireccion = "";
        String NombreActividad = request.getParameter("actividad");
        String descripcionActividad = request.getParameter("descripcion");
        int idUsuarioFuncional = Integer.parseInt(request.getParameter("usuarioFuncional"));
        int idAccion = Integer.parseInt(request.getParameter("accion"));
        int idGrupoDatos = Integer.parseInt(request.getParameter("grupoDatos"));
        SubProcesoJpaController subPjpa = new SubProcesoJpaController(EntityProvider.provider());
        HttpSession session = request.getSession(true);
        ProcesoFuncional PF = (ProcesoFuncional) session.getAttribute("pfDetalle");
        if(!subPjpa.findSPByActividadyIdPF(NombreActividad,PF.getIdprocesoFuncional()).isEmpty())
            redireccion = "e_ExisteActividad.jsp";
    
        //OBTENER EL OBJETO PF PARA OBTENER IDPROY
        ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");   

        SubProceso aux = new SubProceso();
        aux.setActividad(NombreActividad);
        aux.setDescripcion(descripcionActividad);
        aux.setIdprocesoFuncional(detalle);
        
        List<SubProceso> subProceso = subPjpa.findSPByActividadyPF(NombreActividad,detalle);
        aux.setIndice(subProceso.size()+1);
        List<SubProceso> subProcesoIndActiv = subPjpa.findSPByActividad_PF(detalle);
        if(subProcesoIndActiv.isEmpty())
            aux.setIndiceActividad(1);
        else
            aux.setIndiceActividad(subProcesoIndActiv.size()+1);
        
        UsuarioFuncionalJpaController usuarioFuncional = new UsuarioFuncionalJpaController(EntityProvider.provider());
        UsuarioFuncional MiUsuarioFuncional = usuarioFuncional.findUsuarioFuncional(idUsuarioFuncional);
        aux.setIdusuarioFuncional(MiUsuarioFuncional);
        
        AccionJpaController accion = new AccionJpaController(EntityProvider.provider());
        Accion MiAccion = accion.findAccion(idAccion);
        aux.setIdaccion(MiAccion);
        
        GrupoDatoJpaController grupoDatos = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato MiGrupoDato = grupoDatos.findGrupoDato(idGrupoDatos);
        aux.setIdgrupoDato(MiGrupoDato);
        
        try {
            if(redireccion.isEmpty())
                subPjpa.create(aux);
            //Insertar subprocesogrupodato
            SubprocesoGrupoDato spgd = new SubprocesoGrupoDato();
            spgd.setIdGrupoDato(MiGrupoDato);
            aux.setIdsubProceso(subPjpa.findLastSP().getIdsubProceso());
            spgd.setIdSubProceso(aux);
            SubprocesoGrupoDatoJpaController spgdJpa = new SubprocesoGrupoDatoJpaController(EntityProvider.provider());
            spgdJpa.create(spgd);
        } catch (Exception e) {
            redireccion = "addActividad.jsp";
            return;
        } finally {
            if(redireccion.isEmpty()){
                redireccion = "detallePF.jsp";
        
                ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
                ProcesoFuncional pfDetalle = pfjpa.findProcesoFuncional(PF.getIdprocesoFuncional());
                session.setAttribute("pfDetalle", pfDetalle);

                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> sp = spjpa.findSPByIDPForder(PF.getIdprocesoFuncional());
                session.setAttribute("subProc", sp);
            }
            response.sendRedirect(redireccion);
        }
    }
}
