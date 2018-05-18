package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class agregandoSubProceso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int opcion = Integer.parseInt(session.getAttribute("opcionSPDetallePF").toString());
        int idSP = Integer.parseInt(session.getAttribute("idSPDetallePF").toString());
        String redireccion = "";
        String NombreActividad = request.getParameter("actividad");
        String descripcionActividad = request.getParameter("descripcion");
        int idUsuarioFuncional = Integer.parseInt(request.getParameter("usuarioFuncional"));
        int idAccion = Integer.parseInt(request.getParameter("accion"));
        int idGrupoDatos = Integer.parseInt(request.getParameter("grupoDatos"));
        String flujoAl_ = request.getParameter("flujoAl");
        SubProcesoJpaController subPjpa = new SubProcesoJpaController(EntityProvider.provider());
        ProcesoFuncional PF = (ProcesoFuncional) session.getAttribute("pfDetalle");
        SubProceso auxSP = subPjpa.findSubProceso(idSP);

        SubProceso aux = new SubProceso();
        aux.setActividad(NombreActividad);
        aux.setDescripcion(descripcionActividad);
        aux.setIdprocesoFuncional(PF);

        List<SubProceso> subProceso = subPjpa.findSPByActividadyPF(NombreActividad, PF);
        aux.setIndice(subProceso.size() + 1);
        short b = 0;
        if (flujoAl_ == null) {
            b = 1;
        }
        aux.setFlujoAl(b);

        UsuarioFuncionalJpaController usuarioFuncional = new UsuarioFuncionalJpaController(EntityProvider.provider());
        UsuarioFuncional MiUsuarioFuncional = usuarioFuncional.findUsuarioFuncional(idUsuarioFuncional);
        aux.setIdusuarioFuncional(MiUsuarioFuncional);

        AccionJpaController accion = new AccionJpaController(EntityProvider.provider());
        Accion MiAccion = accion.findAccion(idAccion);
        aux.setIdaccion(MiAccion);

        GrupoDatoJpaController grupoDatos = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato MiGrupoDato = grupoDatos.findGrupoDato(idGrupoDatos);
        aux.setIdgrupoDato(MiGrupoDato);

        if (opcion == 1) {
            List<SubProceso> subProc = subPjpa.findAddUp(PF.getIdprocesoFuncional(), NombreActividad, auxSP.getIndice());
            aux.setIndice(auxSP.getIndice());
            subPjpa.create(aux);
            for (SubProceso subP : subProc) {
                subP.setIndice(subP.getIndice()+1);
                try {
                    subPjpa.edit(subP);
                } catch (Exception ex) {
                    redireccion = "addSubProceso.jsp";
                    Logger.getLogger(agregandoSubProceso.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    redireccion = "detallePF.jsp";
                }
            }
        } else if (opcion == 2) {
            List<SubProceso> subProc = subPjpa.findAddDown(PF.getIdprocesoFuncional(), NombreActividad, auxSP.getIndice());
            aux.setIndice(auxSP.getIndice()+1);
            subPjpa.create(aux);
            if(!subProc.isEmpty())
            for (SubProceso subP : subProc) {
                subP.setIndice(subP.getIndice()+1);
                try {
                    subPjpa.edit(subP);
                } catch (Exception ex) {
                    redireccion = "addSubProceso.jsp";
                    Logger.getLogger(agregandoSubProceso.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    redireccion = "detallePF.jsp";
                }
            }else redireccion = "detallePF.jsp";
        }

        ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
        ProcesoFuncional pfDetalle = pfjpa.findProcesoFuncional(PF.getIdprocesoFuncional());
        session.setAttribute("pfDetalle", pfDetalle);

        SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
        List<SubProceso> sp = spjpa.findSPByIDPForder(PF.getIdprocesoFuncional());
        session.setAttribute("subProc", sp);
        response.sendRedirect(redireccion);
    }
}
