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
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.FlujoAlterno;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.FlujoAlternoJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;
public class BuscaProcesoFuncional extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Integer idPf= Integer.parseInt(request.getParameter("idprocesoFuncional"));    	
    	   
        HttpSession session = request.getSession(true);
        
        ////////
    	ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
        ProcesoFuncional pfDetalle = pfjpa.findProcesoFuncional(idPf);
        session.setAttribute("pfDetalle", pfDetalle);
        ////
        // Busca la lsita de los subprocesos
        SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
        //List<SubProceso> sp = spjpa.findSPByIdProcesoFuncional(idPf);
        List<SubProceso> sp = spjpa.findSPByIDPForder(idPf);
        
        FlujoAlternoJpaController fajpa = new FlujoAlternoJpaController(EntityProvider.provider());
        List<FlujoAlterno> flujoAl = new ArrayList<>();
        for(SubProceso inter : sp){
            List<FlujoAlterno> flujoAlterno = new ArrayList<>();
            flujoAlterno = fajpa.findByIdSubProceso(inter);
            if(flujoAlterno!=null && !flujoAlterno.isEmpty()){
                flujoAl.add(flujoAlterno.get(0));
            }
            
        }
        
        int flujoAlternos = 0;
        if(!flujoAl.isEmpty())
            flujoAlternos = 1;
        session.setAttribute("flujoAlternos", flujoAlternos);
        session.setAttribute("subProc", sp);
        session.setAttribute("ListaflujoAlternos", flujoAl);
        
        //
       
        List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
                
                UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
                
                ArrayList<UsuarioFuncional> listaUsuarioFuncional = new ArrayList<UsuarioFuncional>();
                inters.forEach((iter)->{
                    List<UsuarioFuncional> uf = ufjpa.findUsuarioFuncionalOrdered(iter.getIdproyecto());
                    listaUsuarioFuncional.addAll(uf);
                });
		
	session.setAttribute("ufCatalogo",listaUsuarioFuncional);
        
        
        AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
                
                ArrayList<Accion> listaAcciones = new ArrayList<Accion>();
                inters.forEach((iter)->{
                    List<Accion> ac = ajpa.findAccionOrdered(iter.getIdproyecto());
                    listaAcciones.addAll(ac);
                });
		
	session.setAttribute("accCatalogo",listaAcciones);
                
	GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
                
        ArrayList<GrupoDato> listaGrupoDatos = new ArrayList<GrupoDato>();
        inters.forEach((iter)->{
            List<GrupoDato> gd = gdjpa.findGrupoDatoOrdered(iter.getIdproyecto());
            listaGrupoDatos.addAll(gd);
        });
	
        session.setAttribute("grupoDatosCatalogo", listaGrupoDatos);
        
        if(pfDetalle!=null){
            List<ProcesoFuncional> pf = pfjpa.findPFByIdProyectoActivo(pfDetalle.getIdproyecto().getIdproyecto());
            if(pf!=null && !pf.isEmpty())
                session.setAttribute("procFunc", pf);
        
        }
        
        response.sendRedirect("detallePF.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Integer idPf= Integer.parseInt(request.getParameter("idprocesoFuncional"));    	
    	
        HttpSession session = request.getSession(true);
        
        ////////
    	ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
        ProcesoFuncional pfDetalle = pfjpa.findProcesoFuncional(idPf);
        session.setAttribute("pfDetalle", pfDetalle);
        ////
        
        // Busca la lsita de los subprocesos
        SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
        //List<SubProceso> sp = spjpa.findSPByIdProcesoFuncional(idPf);
        List<SubProceso> sp = spjpa.findSPByIDPForder(idPf);
        session.setAttribute("subProc", sp);
        
        FlujoAlternoJpaController fajpa = new FlujoAlternoJpaController(EntityProvider.provider());
        List<FlujoAlterno> flujoAl = Collections.emptyList();
        for(SubProceso inter : sp){
            List<FlujoAlterno> flujoAlterno ;
            flujoAlterno = fajpa.findByIdSubProceso(inter);
            if(flujoAlterno!=null && !flujoAlterno.isEmpty())
                flujoAl.addAll(flujoAlterno);
        }
        
        int flujoAlternos = 0;
        if(!flujoAl.isEmpty())
            flujoAlternos = 1;
        session.setAttribute("flujoAlternos", flujoAlternos);
        session.setAttribute("subProc", sp);
        session.setAttribute("ListaflujoAlternos", flujoAl);
        
        List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
                
                UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
                
                ArrayList<UsuarioFuncional> listaUsuarioFuncional = new ArrayList<UsuarioFuncional>();
                inters.forEach((iter)->{
                    List<UsuarioFuncional> uf = ufjpa.findUsuarioFuncionalOrdered(iter.getIdproyecto());
                    listaUsuarioFuncional.addAll(uf);
                });
		
	session.setAttribute("ufCatalogo",listaUsuarioFuncional);
        
        
        AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
                
                ArrayList<Accion> listaAcciones = new ArrayList<Accion>();
                inters.forEach((iter)->{
                    List<Accion> ac = ajpa.findAccionOrdered(iter.getIdproyecto());
                    listaAcciones.addAll(ac);
                });
		
	session.setAttribute("accCatalogo",listaAcciones);
                
	GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
                
        ArrayList<GrupoDato> listaGrupoDatos = new ArrayList<GrupoDato>();
        inters.forEach((iter)->{
            List<GrupoDato> gd = gdjpa.findGrupoDatoOrdered(iter.getIdproyecto());
            listaGrupoDatos.addAll(gd);
        });
	
        session.setAttribute("grupoDatosCatalogo", listaGrupoDatos);
        
        List<ProcesoFuncional> pf = pfjpa.findPFByIdProyectoActivo(pfDetalle.getIdproyecto().getIdproyecto());
        if(pf!=null && !pf.isEmpty())
            session.setAttribute("procFunc", pf);
        
        response.sendRedirect("detallePF.jsp");
    }
}
