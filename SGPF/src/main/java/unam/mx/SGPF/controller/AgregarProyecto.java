package unam.mx.SGPF.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.ArqProyecto;
import unam.mx.SGPF.model.BaseDatos;
import unam.mx.SGPF.model.ConfInfo;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.Escala;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Lenguaje;
import unam.mx.SGPF.model.MarcoPosUsa;
import unam.mx.SGPF.model.MetDesarrollo;
import unam.mx.SGPF.model.MetMedicion;
import unam.mx.SGPF.model.ModCalidad;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.SectorOrganizacion;
import unam.mx.SGPF.model.SisOpe;
import unam.mx.SGPF.model.TamOrg;
import unam.mx.SGPF.model.TipoCapDes;
import unam.mx.SGPF.model.TipoOrganizacion;
import unam.mx.SGPF.model.TipodeDesarrollo;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.ArqProyectoJpaController;
import unam.mx.SGPF.model.controller.BaseDatosJpaController;
import unam.mx.SGPF.model.controller.ConfInfoJpaController;
import unam.mx.SGPF.model.controller.EscalaJpaController;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.LenguajeJpaController;
import unam.mx.SGPF.model.controller.MarcoPosUsaJpaController;
import unam.mx.SGPF.model.controller.MetDesarrolloJpaController;
import unam.mx.SGPF.model.controller.MetMedicionJpaController;
import unam.mx.SGPF.model.controller.ModCalidadJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;
import unam.mx.SGPF.model.controller.SectorOrganizacionJpaController;
import unam.mx.SGPF.model.controller.SisOpeJpaController;
import unam.mx.SGPF.model.controller.TamOrgJpaController;
import unam.mx.SGPF.model.controller.TipoCapDesJpaController;
import unam.mx.SGPF.model.controller.TipoOrganizacionJpaController;
import unam.mx.SGPF.model.controller.TipodeDesarrolloJpaController;
import unam.mx.SGPF.model.controller.UsuarioJpaController;

public class AgregarProyecto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String redireccion = "";
        String nombreProy = request.getParameter("nombreProyecto");
        String anio = request.getParameter("anio");
        Short operProy = (short)Integer.parseInt(request.getParameter("operProy"));
        int IdTipodeDesarrollo = Integer.parseInt(request.getParameter("IdTipodeDesarrollo"));
        int IdsectorOrganizacion = Integer.parseInt(request.getParameter("IdsectorOrganizacion"));
        int IdtipoOrganizacion = Integer.parseInt(request.getParameter("IdtipoOrganizacion"));
        int IdtipoCapDes = Integer.parseInt(request.getParameter("IdtipoCapDes"));
        int IdtamOrgDes = Integer.parseInt(request.getParameter("IdtamOrgDes").toString());
        int tamOrgUsa = Integer.parseInt(request.getParameter("tamOrgUsa"));
        int idarqProyecto = Integer.parseInt(request.getParameter("idarqProyecto"));
        int Idlenguaje = Integer.parseInt(request.getParameter("Idlenguaje"));
        int idsisOpe = Integer.parseInt(request.getParameter("idsisOpe"));
        int IdbaseDatos = Integer.parseInt(request.getParameter("IdbaseDatos"));
        Short usoCase = (short)Integer.parseInt(request.getParameter("usoCase"));
        int IdmetDesarrollo = Integer.parseInt(request.getParameter("IdmetDesarrollo"));
        int IdmarcoPosUsao = Integer.parseInt(request.getParameter("IdmarcoPosUsao"));
        int IdmodCalidad = Integer.parseInt(request.getParameter("IdmodCalidad"));
        Short medidorCertProy = (short)Integer.parseInt(request.getParameter("medidorCertProy"));
        String comCertModelo = request.getParameter("comCertModelo");
        String alcance = request.getParameter("alcance");
        String proposito = request.getParameter("proposito");
        int Idescala = Integer.parseInt(request.getParameter("Idescala"));
        Double aux=0.0;
        BigDecimal esfuTotProy = new BigDecimal(0.0);
        BigDecimal esfuPlaneProy  = new BigDecimal(0.0);
        BigDecimal duraProy  = new BigDecimal(0.0);
        BigDecimal esfuEsReqProy  = new BigDecimal(0.0);
        BigDecimal esfuAnaDisProy = new BigDecimal(0.0);
        BigDecimal esfuConstProy = new BigDecimal(0.0);
        BigDecimal esfuPrueProy = new BigDecimal(0.0);
        BigDecimal esfuImpleDesProy = new BigDecimal(0.0);
        BigDecimal costTotProy = new BigDecimal(0.0);
        BigDecimal costPlanProy = new BigDecimal(0.0);
        BigDecimal costEsReqProy = new BigDecimal(0.0);
        BigDecimal costAnaDisProy = new BigDecimal(0.0);
        BigDecimal costConstProy = new BigDecimal(0.0);
        BigDecimal costPrueProy = new BigDecimal(0.0);
        BigDecimal costImpleDesProy = new BigDecimal(0.0);
        BigDecimal tamFunProy = new BigDecimal(0.0);
        BigDecimal fpAjusProy = new BigDecimal(0.0);
        BigDecimal estimacionCosto = new BigDecimal(0.0);
        BigDecimal estimacionEsfuerzo = new BigDecimal(0.0);
        BigDecimal estimacionDuracion = new BigDecimal(0.0);
        
        String valor = request.getParameter("esfuTotProy");
        if (valor!=null&&!valor.isEmpty())
            esfuTotProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("esfuPlaneProy");
        if (valor!=null&&!valor.isEmpty())
            esfuPlaneProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("duraProy");
        if (valor!=null&&!valor.isEmpty())
            duraProy  = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("esfuEsReqProy");
        if (valor!=null&&!valor.isEmpty())
            esfuEsReqProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("esfuAnaDisProy");
        if (valor!=null&&!valor.isEmpty())
            esfuAnaDisProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("esfuConstProy");
        if (valor!=null&&!valor.isEmpty())
            esfuConstProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("esfuPrueProy");
        if (valor!=null&&!valor.isEmpty())
            esfuPrueProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("esfuImpleDesProy");
        if (valor!=null&&!valor.isEmpty())
            esfuImpleDesProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("costTotProy");
        if (valor!=null&&!valor.isEmpty())
            costTotProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("costPlanProy");
        if (valor!=null&&!valor.isEmpty())
            costPlanProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("costEsReqProy");
        if (valor!=null&&!valor.isEmpty())
            costEsReqProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("costAnaDisProy");
        if (valor!=null&&!valor.isEmpty())
            costAnaDisProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("costConstProy");
        if (valor!=null&&!valor.isEmpty())
            costConstProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("costPrueProy");
        if (valor!=null&&!valor.isEmpty())
            costPrueProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("costImpleDesProy");
        if (valor!=null&&!valor.isEmpty())
            costImpleDesProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("tamFunProy");
        if (valor!=null&&!valor.isEmpty())
            tamFunProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("fpAjusProy");
        if (valor!=null&&!valor.isEmpty())
            fpAjusProy = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("estimacionCosto");
        if (valor!=null&&!valor.isEmpty())
            estimacionCosto = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("estimacionEsfuerzo");
        if (valor!=null&&!valor.isEmpty())
            estimacionEsfuerzo = new BigDecimal(Double.parseDouble(valor));
        
        valor = request.getParameter("estimacionDuracion");
        if (valor!=null&&!valor.isEmpty())
            estimacionDuracion = new BigDecimal(Double.parseDouble(valor));
        
        int idescalaEstimacionDuracion = Integer.parseInt(request.getParameter("idescalaEstimacionDuracion"));
        
        int IdmetMedicion = Integer.parseInt(request.getParameter("IdmetMedicion"));
        Short certModelo = (short)Integer.parseInt(request.getParameter("certModelo"));
        String a = request.getParameter("expeMedMetProy");
        
        int expeMedMetProy = 0;
        if(!a.isEmpty())
            expeMedMetProy = Integer.parseInt(a);
        
        int IdconfInfo = Integer.parseInt(request.getParameter("IdconfInfo"));
        
        Proyecto proyecto = new Proyecto();
        proyecto.setEstimacionCosto(estimacionCosto);
        proyecto.setEstimacionEsfuerzo(estimacionEsfuerzo);
        proyecto.setEstimacionDuracion(estimacionDuracion);
        EscalaJpaController escalaJpa1 = new EscalaJpaController(EntityProvider.provider());
        Escala escala1 = escalaJpa1.findEscala(idescalaEstimacionDuracion);
        proyecto.setIdescalaEstimacionDuracion(escala1);
        
        
        proyecto.setNomProy(nombreProy);
        proyecto.setAnioProy(anio);
        proyecto.setOperProy(operProy);
        proyecto.setDuraProy(duraProy);
        proyecto.setEsfuTotProy(esfuTotProy);
        proyecto.setEsfuPlaneProy(esfuPlaneProy);
        proyecto.setEsfuEsReqProy(esfuEsReqProy);
        proyecto.setEsfuAnaDisProy(esfuAnaDisProy);
        proyecto.setEsfuConstProy(esfuConstProy);
        proyecto.setEsfuPrueProy(esfuPrueProy);
        proyecto.setEsfuImpleDesProy(esfuImpleDesProy);
        proyecto.setCostTotProy(costTotProy);
        proyecto.setCostEsReqProy(costEsReqProy);
        proyecto.setCostAnaDisProy(costAnaDisProy);
        proyecto.setCostConstProy(costConstProy);
        proyecto.setCostPrueProy(costPrueProy);
        proyecto.setCostImpleDesProy(costImpleDesProy);
        proyecto.setTamFunProy(tamFunProy);
        proyecto.setFpAjusProy(fpAjusProy);
        proyecto.setMedidorCertProy(medidorCertProy);
        proyecto.setExpeMedMetProy(expeMedMetProy);
        proyecto.setUsoCase(usoCase);
        proyecto.setCertModelo(certModelo);
        proyecto.setComCertModelo(comCertModelo);
        proyecto.setCostPlanProy(costPlanProy);
        ConfInfoJpaController coninfoJpa = new ConfInfoJpaController(EntityProvider.provider());
        ConfInfo confInfo = coninfoJpa.findConfInfo(IdconfInfo);
        proyecto.setIdconfInfo(confInfo);
        ArqProyectoJpaController arqJpa = new ArqProyectoJpaController(EntityProvider.provider());
        ArqProyecto arqProy = arqJpa.findArqProyecto(idarqProyecto);
        proyecto.setIdarqProyecto(arqProy);
        MetDesarrolloJpaController metDesJpa = new MetDesarrolloJpaController(EntityProvider.provider());
        MetDesarrollo metDes = metDesJpa.findMetDesarrollo(IdmetDesarrollo);
        proyecto.setIdmetDesarrollo(metDes);
        MetMedicionJpaController metMedJpa = new MetMedicionJpaController(EntityProvider.provider());
        MetMedicion metMed = metMedJpa.findMetMedicion(IdmetMedicion);
        proyecto.setIdmetMedicion(metMed);
        SisOpeJpaController sisOpeJpa = new SisOpeJpaController(EntityProvider.provider());
        SisOpe sisOpe = sisOpeJpa.findSisOpe(idsisOpe);
        proyecto.setIdsisOpe(sisOpe);
        TipodeDesarrolloJpaController tipoJpa = new TipodeDesarrolloJpaController(EntityProvider.provider());
        TipodeDesarrollo tipoDes = tipoJpa.findTipodeDesarrollo(IdTipodeDesarrollo);
        proyecto.setIdTipoDesarrollo(tipoDes);
        LenguajeJpaController lenguaJpa = new LenguajeJpaController(EntityProvider.provider());
        Lenguaje lenguaje = lenguaJpa.findLenguaje(Idlenguaje);
        proyecto.setIdlenguaje(lenguaje);
        ModCalidadJpaController modJpa = new ModCalidadJpaController(EntityProvider.provider());
        ModCalidad modeloCal = modJpa.findModCalidad(IdmodCalidad);
        proyecto.setIdmodCalidad(modeloCal);
        BaseDatosJpaController baseJpa = new BaseDatosJpaController(EntityProvider.provider());
        BaseDatos baseDatos = baseJpa.findBaseDatos(IdbaseDatos);
        proyecto.setIdbaseDatos(baseDatos);
        SectorOrganizacionJpaController sectJpa = new SectorOrganizacionJpaController(EntityProvider.provider());
        SectorOrganizacion sectorOrg = sectJpa.findSectorOrganizacion(IdsectorOrganizacion);
        proyecto.setIdsectorOrganizacion(sectorOrg);
        Short b = 1;
        proyecto.setEstatus(b);
        TipoOrganizacionJpaController tipoOrgJpa = new TipoOrganizacionJpaController(EntityProvider.provider());
        TipoOrganizacion tipoOrganizacion = tipoOrgJpa.findTipoOrganizacion(IdtipoOrganizacion);
        proyecto.setIdtipoOrganizacion(tipoOrganizacion);
        TipoCapDesJpaController capJpa = new TipoCapDesJpaController(EntityProvider.provider());
        TipoCapDes tipoCapDes = capJpa.findTipoCapDes(IdtipoCapDes);
        proyecto.setIdtipoCapDes(tipoCapDes);
        TamOrgJpaController tamJpa = new TamOrgJpaController(EntityProvider.provider());
        TamOrg tamOrg = tamJpa.findTamOrg(IdtamOrgDes);
        proyecto.setIdtamOrgDes(tamOrg);
        tamOrg = tamJpa.findTamOrg(tamOrgUsa);
        proyecto.setTamOrgUsa(tamOrg);
        MarcoPosUsaJpaController marcoJpa = new MarcoPosUsaJpaController(EntityProvider.provider());
        MarcoPosUsa marco = marcoJpa.findMarcoPosUsa(IdmarcoPosUsao);
        proyecto.setIdmarcoPosUsa(marco);
        EscalaJpaController escalaJpa = new EscalaJpaController(EntityProvider.provider());
        Escala escala = escalaJpa.findEscala(Idescala);
        proyecto.setIdescala(escala);
        proyecto.setProposito(proposito);
        proyecto.setAlcance(alcance);
        
        HttpSession session = request.getSession(true);
        Usuario u = (Usuario) session.getAttribute("usuario");
        InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());
        UsuarioJpaController userJpa = new UsuarioJpaController(EntityProvider.provider());
        List<Usuario> listaAdmins = userJpa.getUsuariosAdmin();
        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
        short z = 1;
        
        try {
            pjpa.create(proyecto);
            proyecto = pjpa.findLastProyecto();
            InterUP up = new InterUP();
            up.setIdproyecto(proyecto);
            up.setIdusuario(u);
            up.setActivo(z);
            ijpa.create(up);
            List<InterUP> inters = ijpa.getProyectosUsuario(u);
            // Apuntador al objeto u
            session.setAttribute("usuario", u);
            session.setAttribute("inters", inters);
            
            for(Usuario iter : listaAdmins)
                if(!Objects.equals(iter.getIdusuario(), u.getIdusuario())){
                    up.setIdusuario(iter);
                    up.setActivo(z);
                    ijpa.create(up);
                }
            
            redireccion = "proyectos.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            redireccion = "agregarProyecto.jsp";
            return;
        } finally {
            
            response.sendRedirect(redireccion);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
