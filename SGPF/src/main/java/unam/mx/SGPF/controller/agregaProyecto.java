package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
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
import unam.mx.SGPF.model.Lenguaje;
import unam.mx.SGPF.model.MarcoPosUsa;
import unam.mx.SGPF.model.MetDesarrollo;
import unam.mx.SGPF.model.MetMedicion;
import unam.mx.SGPF.model.ModCalidad;
import unam.mx.SGPF.model.SectorOrganizacion;
import unam.mx.SGPF.model.SisOpe;
import unam.mx.SGPF.model.TamOrg;
import unam.mx.SGPF.model.TipoCapDes;
import unam.mx.SGPF.model.TipoOrganizacion;
import unam.mx.SGPF.model.TipodeDesarrollo;
import unam.mx.SGPF.model.controller.ArqProyectoJpaController;
import unam.mx.SGPF.model.controller.BaseDatosJpaController;
import unam.mx.SGPF.model.controller.ConfInfoJpaController;
import unam.mx.SGPF.model.controller.EscalaJpaController;
import unam.mx.SGPF.model.controller.LenguajeJpaController;
import unam.mx.SGPF.model.controller.MarcoPosUsaJpaController;
import unam.mx.SGPF.model.controller.MetDesarrolloJpaController;
import unam.mx.SGPF.model.controller.MetMedicionJpaController;
import unam.mx.SGPF.model.controller.ModCalidadJpaController;
import unam.mx.SGPF.model.controller.SectorOrganizacionJpaController;
import unam.mx.SGPF.model.controller.SisOpeJpaController;
import unam.mx.SGPF.model.controller.TamOrgJpaController;
import unam.mx.SGPF.model.controller.TipoCapDesJpaController;
import unam.mx.SGPF.model.controller.TipoOrganizacionJpaController;
import unam.mx.SGPF.model.controller.TipodeDesarrolloJpaController;

public class agregaProyecto extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        ConfInfoJpaController ConfInfoJpa = new ConfInfoJpaController(EntityProvider.provider());
        List<ConfInfo> ListaConfInfo = ConfInfoJpa.findConfInfoEntities();
        session.setAttribute("ListaConfInfo", ListaConfInfo);
        
        ArqProyectoJpaController arqProyJpa = new  ArqProyectoJpaController((EntityProvider.provider()));
        List<ArqProyecto> ListaArqProyecto = arqProyJpa.findArqProyectoEntities();
        session.setAttribute("ListaArqProyecto", ListaArqProyecto);
        
        MetDesarrolloJpaController metDesJpa = new MetDesarrolloJpaController(EntityProvider.provider());
        List<MetDesarrollo> ListaMetDesarrollo = metDesJpa.findMetDesarrolloEntities();
        session.setAttribute("ListaMetDesarrollo", ListaMetDesarrollo);
        
        MetMedicionJpaController metMedJpa = new MetMedicionJpaController(EntityProvider.provider());
        List<MetMedicion> ListaMetMedicon = metMedJpa.findMetMedicionEntities();
        session.setAttribute("ListaMetMedicon", ListaMetMedicon);
        
        SisOpeJpaController sisOpeJpa = new SisOpeJpaController(EntityProvider.provider());
        List<SisOpe> ListaSisOpe = sisOpeJpa.findSisOpeEntities();
        session.setAttribute("ListaSisOpe", ListaSisOpe);
        
        TipodeDesarrolloJpaController tipoDesJpa = new TipodeDesarrolloJpaController(EntityProvider.provider());
        List<TipodeDesarrollo> ListaTipoDes = tipoDesJpa.findTipodeDesarrolloEntities();
        if(ListaTipoDes.isEmpty()){System.out.println("Lista vacia");}else{System.out.println("Lista OK");}
        session.setAttribute("ListaTipoDes", ListaTipoDes);
        
        LenguajeJpaController lenguajeJpa = new LenguajeJpaController(EntityProvider.provider());
        List<Lenguaje> ListaLenguaje = lenguajeJpa.findLenguajeEntities();
        session.setAttribute("ListaLenguaje", ListaLenguaje);
        
        ModCalidadJpaController modCalidadJpa = new ModCalidadJpaController(EntityProvider.provider());
        List<ModCalidad> ListaModCalidad = modCalidadJpa.findModCalidadEntities();
        session.setAttribute("ListaModCalidad", ListaModCalidad);
        
        BaseDatosJpaController baseDatosJpa = new BaseDatosJpaController(EntityProvider.provider());
        List<BaseDatos> ListaBaseDatos = baseDatosJpa.findBaseDatosEntities();
        session.setAttribute("ListaBaseDatos", ListaBaseDatos);
        
        SectorOrganizacionJpaController sectorOrgaJpa = new SectorOrganizacionJpaController(EntityProvider.provider());
        List<SectorOrganizacion> ListaSectorOrganizacion = sectorOrgaJpa.findSectorOrganizacionEntities();
        session.setAttribute("ListaSectorOrganizacion", ListaSectorOrganizacion);
        
        TipoOrganizacionJpaController tipoOrgJpa = new TipoOrganizacionJpaController(EntityProvider.provider());
        List<TipoOrganizacion> ListaTipoOrg = tipoOrgJpa.findTipoOrganizacionEntities();
        session.setAttribute("ListaTipoOrg", ListaTipoOrg);
        
        TipoCapDesJpaController tipoCapDesJpa = new TipoCapDesJpaController(EntityProvider.provider());
        List<TipoCapDes> ListaTipoCapDes = tipoCapDesJpa.findTipoCapDesEntities();
        session.setAttribute("ListaTipoCapDes", ListaTipoCapDes);
        
        TamOrgJpaController tamOrgJpa = new TamOrgJpaController(EntityProvider.provider());
        List<TamOrg> ListaTamOrg = tamOrgJpa.findTamOrgEntities();
        session.setAttribute("ListaTamOrg", ListaTamOrg);
        
        MarcoPosUsaJpaController marcoJpa = new MarcoPosUsaJpaController(EntityProvider.provider());
        List<MarcoPosUsa> ListaMarcoPosUsa = marcoJpa.findMarcoPosUsaEntities();
        session.setAttribute("ListaMarcoPosUsa", ListaMarcoPosUsa);
        
        EscalaJpaController escalaJpa = new EscalaJpaController(EntityProvider.provider());
        List<Escala> ListaEscala = escalaJpa.findEscalaEntities();
        session.setAttribute("ListaEscala", ListaEscala);
        
        response.sendRedirect("agregarProyecto.jsp");
    }
}
