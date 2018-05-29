/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;

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

public class actualizaRproyectO extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String redireccion = "";

        int idProy = Integer.parseInt(request.getParameter("idProyecto"));
        String nombreProy = request.getParameter("nombreProyecto");
        String anio = request.getParameter("anio");
        Short operProy = (short)Integer.parseInt(request.getParameter("operProy"));
        int IdTipodeDesarrollo = Integer.parseInt(request.getParameter("IdTipodeDesarrollo"));
        int IdsectorOrganizacion = Integer.parseInt(request.getParameter("IdsectorOrganizacion"));
        int IdtipoOrganizacion = Integer.parseInt(request.getParameter("IdtipoOrganizacion"));
        int IdtipoCapDes = Integer.parseInt(request.getParameter("IdtipoCapDes"));
        int IdtamOrgDes = Integer.parseInt(request.getParameter("IdtamOrgDes"));
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
        double aux = Double.parseDouble(request.getParameter("esfuTotProy"));
        BigDecimal esfuTotProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("esfuPlaneProy"));
        BigDecimal esfuPlaneProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("duraProy"));
        BigDecimal duraProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("esfuEsReqProy"));
        BigDecimal esfuEsReqProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("esfuAnaDisProy"));
        BigDecimal esfuAnaDisProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("esfuConstProy"));
        BigDecimal esfuConstProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("esfuPrueProy"));
        BigDecimal esfuPrueProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("esfuImpleDesProy"));
        BigDecimal esfuImpleDesProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("costTotProy"));
        BigDecimal costTotProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("costPlanProy"));
        BigDecimal costPlanProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("costEsReqProy"));
        BigDecimal costEsReqProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("costAnaDisProy"));
        BigDecimal costAnaDisProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("costConstProy"));
        BigDecimal costConstProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("costPrueProy"));
        BigDecimal costPrueProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("costImpleDesProy"));
        BigDecimal costImpleDesProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("tamFunProy"));
        BigDecimal tamFunProy = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("fpAjusProy"));
        BigDecimal fpAjusProy = new BigDecimal(aux);
        
        aux = Double.parseDouble(request.getParameter("estimacionCosto"));
        BigDecimal estimacionCosto = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("estimacionEsfuerzo"));
        BigDecimal estimacionEsfuerzo = new BigDecimal(aux);
        aux = Double.parseDouble(request.getParameter("estimacionDuracion"));
        BigDecimal estimacionDuracion = new BigDecimal(aux);
        int idescalaEstimacionDuracion = Integer.parseInt(request.getParameter("idescalaEstimacionDuracion"));
        
        int IdmetMedicion = Integer.parseInt(request.getParameter("IdmetMedicion"));
        Short certModelo = (short)Integer.parseInt(request.getParameter("certModelo"));
        int expeMedMetProy = Integer.parseInt(request.getParameter("expeMedMetProy"));
        int IdconfInfo = Integer.parseInt(request.getParameter("IdconfInfo"));
        
        
        
        
        
        HttpSession session = request.getSession(true);
        Usuario u = (Usuario) session.getAttribute("usuario");

        InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());
        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
        
        Proyecto proyecto = pjpa.findProyecto(idProy);
        //Proyecto proyecto = new Proyecto();
        
        //Proyecto proyecto = new Proyecto();
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
        
        
        try {
            pjpa.edit(proyecto);
            //session.setAttribute("proyActual", proyecto);

         // Apuntador al objeto u
            List<InterUP> inters = ijpa.getProyectosUsuario(u);
            session.setAttribute("usuario", u);
            session.setAttribute("inters", inters);
        } catch (Exception e) {
            e.printStackTrace();
            redireccion = "modificaProyecto.jsp";
            return;
        } finally {
            redireccion = "BuscaProyecto?idProyecto="+idProy;
            response.sendRedirect(redireccion);
        }
    }

}
