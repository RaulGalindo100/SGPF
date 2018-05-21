package unam.mx.SGPF.controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.fonts.otf.TableHeader;
import java.io.*;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.Historico;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.HistoricoJpaController;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

@WebServlet("/matriz.pdf.pdf")
public class GeneraReporte extends HttpServlet {

    private void generatePDF(Proyecto proy, List<ProcesoFuncional> listaPF) throws Exception {
        try {
            String RESULT = "results/matriz.pdf";
            String arrowR = "results/arrowRight.png";
            String arrowUpDown = "results/arrowUpDown.png";
            String arrowUpDown2 = "results/arrowUpDown2.png";
            String bdPng = "results/bd.png";
            String dottedLine = "results/dottedLine.png";
            String arrowX = "results/arrowX.png";
            String userFunc = "results/UF2.png";
            String arrowAct = "results/arrowAct.png";
            String logoUnam = "results/UNAM.png";

            FileOutputStream archivo = new FileOutputStream(RESULT);
            Document document = new Document(PageSize.A4.rotate(), 50f, 50f, 20f, 20f);
            PdfWriter writer = PdfWriter.getInstance(document, archivo);
            document.open();
            document.addTitle(proy.getNomProy());
            
            Font fontTitle = new Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, BaseColor.BLACK);
            Font fontSub = new Font(FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
            Font fontVer = new Font(FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.BLACK);
            Font fontVer1 = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
            Font fontVer2 = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
            Font fontNormal = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
            Font fontNormal2 = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, BaseColor.BLACK);
            Font fontNormal3 = new Font(FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);
            String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            String DIA[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
            Calendar calendario = Calendar.getInstance();
            String fechaAct = DIA[calendario.get(Calendar.DAY_OF_WEEK) - 1] + " " + calendario.get(Calendar.DAY_OF_MONTH) + " de " + MES[calendario.get(Calendar.MONTH)] + " del " + calendario.get(Calendar.YEAR);
            String fechaActual = calendario.get(Calendar.DAY_OF_MONTH) + " de " + MES[calendario.get(Calendar.MONTH)] + " del " + calendario.get(Calendar.YEAR);

            //Header 
            PdfPTable tableh = new PdfPTable(3);
            tableh.setTotalWidth(750f);
            tableh.setLockedWidth(true);
            tableh.setWidths(new float[]{1f, 3.3f, 1.7f});

            PdfPCell cell;
            cell = new PdfPCell(new Phrase("  "));
            cell.setRowspan(4);
            cell.setColspan(1);
            tableh.addCell(cell);

            cell = new PdfPCell(new Paragraph("UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO", fontSub));
            cell.setColspan(1);
            cell.setRowspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh.addCell(cell);
            
            cell = new PdfPCell(new Paragraph("Hoja #" + (document.getPageNumber()+1), fontVer));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);
            
            cell = new PdfPCell(new Paragraph("Medición de Software", fontVer));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);

            cell = new PdfPCell(new Paragraph("Reporte de Aproximación de Tamaño Funcional para Proyecto '"
                    + proy.getNomProy() + "'", fontVer2));
            cell.setColspan(1);
            cell.setRowspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh.addCell(cell);

            cell = new PdfPCell(new Paragraph(proy.getNomProy(), fontVer));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(fechaActual, fontVer));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);
            document.add(tableh);
            
            Image imgUnam = Image.getInstance(logoUnam);
            imgUnam.setAbsolutePosition(81, 509);
            document.add(imgUnam);
            //Fin de Header

            //Primer P�gina
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            
            Paragraph pTitle = new Paragraph(proy.getNomProy(), fontTitle);
            pTitle.setAlignment(Element.ALIGN_RIGHT);
            document.add(pTitle);
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            
            Paragraph pSub = new Paragraph("Reporte de Aproximación de Tamaño Funcional para Proyecto '"
                    + proy.getNomProy() + "' con Datos Obtenidos de los Procesos Funcionales", fontSub);
            pSub.setAlignment(Element.ALIGN_RIGHT);
            document.add(pSub);
            document.add(new Paragraph("   "));
            Paragraph pVer = new Paragraph("Versión 1.0", fontVer);
            pVer.setAlignment(Element.ALIGN_RIGHT);
            document.add(pVer);

            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));

            Paragraph pDate = new Paragraph("Fecha: " + fechaAct, fontVer);
            pDate.setAlignment(Element.ALIGN_RIGHT);
            document.add(pDate);
            //Fin de Primer P�gina

            //Datos del Proyecto
            document.newPage();
            
            //Inicio Header
            document.add(tableh);
            
            document.add(imgUnam);
            //Fin Header
            
            document.add(new Paragraph("   "));
            document.add(new Paragraph("    1.  DATOS DEL PROYECTO", fontNormal2));
            document.add(new Paragraph("        Nombre del Proyecto: " + proy.getNomProy(), fontNormal2));
            document.add(new Paragraph("        Número Total de Procesos Funcionales: " + listaPF.size(), fontNormal2));
            document.add(new Paragraph("        Propósito del Proyecto: " + proy.getProposito(), fontNormal2));
            document.add(new Paragraph("        Alcance del Proyecto: " + proy.getAlcance(), fontNormal2));
            //document.add(new Paragraph("    Arquitectura del Proyecto: " + proy.getAlcance() ));
            document.add(new Paragraph("  "));
            //Fin Datos del Proyecto

            //Resumen Medición /#PF, #UF, #GD, MD Totales (tabla, porcentaje) , Diag Ctx Total, Matriz FP
            document.add(new Paragraph("    2.  RESUMEN DE MEDICIÓN", fontNormal2));

            //# Procesos Funcionales
            document.add(new Paragraph("        Procesos Funcionales", fontNormal2));
            int pfCont = 1;
            for (ProcesoFuncional pf : listaPF) {

                document.add(new Paragraph("        " + pfCont + ") " + pf.getNomPF() + ". Descripción: " + pf.getDescripcion(), fontNormal2));

                pfCont++;
            }
            //Fin #Procesos Funcionales

            //#UF
            document.add(new Paragraph("  "));
            document.add(new Paragraph("        Usuarios Funcionales", fontNormal2));

            List<UsuarioFuncional> listaUF = new ArrayList<>();
            SubProcesoJpaController spjpa2 = new SubProcesoJpaController(EntityProvider.provider());
            List<SubProceso> subProcesos2 = spjpa2.findSPByIdProcesoFuncionalR(listaPF.get(0).getIdprocesoFuncional());
            listaUF.add(subProcesos2.get(0).getIdusuarioFuncional());

            for (ProcesoFuncional proceso : listaPF) {
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proceso.getIdprocesoFuncional());
                Boolean yaEsta;
                for (SubProceso sub : subProcesos) {
                    yaEsta = false;

                    for (UsuarioFuncional uf : listaUF) {
                        if (Objects.equals(sub.getIdusuarioFuncional().getIdusuarioFuncional(), uf.getIdusuarioFuncional())) {
                            yaEsta = true;
                            break;
                        }
                    }
                    if (!yaEsta) {
                        listaUF.add(sub.getIdusuarioFuncional());
                    }
                }
            }

            pfCont = 1;
            for (UsuarioFuncional listaFinal : listaUF) {

                document.add(new Paragraph("        " + pfCont + ") " + listaFinal.getNomUF() + ". Descripci�n: " + listaFinal.getDescripcion(), fontNormal2));

                pfCont++;
            }
            //Fin #UF

            //# GD
            document.add(new Paragraph("  "));
            document.add(new Paragraph("        Grupos de Datos", fontNormal2));

            List<GrupoDato> listaGD = new ArrayList<>();
            listaGD.add(subProcesos2.get(0).getIdgrupoDato());

            for (ProcesoFuncional proceso : listaPF) {
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proceso.getIdprocesoFuncional());
                Boolean yaEsta;
                for (SubProceso sub : subProcesos) {
                    yaEsta = false;

                    for (GrupoDato gd : listaGD) {
                        if (Objects.equals(sub.getIdgrupoDato().getIdgrupoDato(), gd.getIdgrupoDato())) {
                            yaEsta = true;
                            break;
                        }
                    }

                    if (!yaEsta) {
                        listaGD.add(sub.getIdgrupoDato());
                    }
                }
            }

            pfCont = 1;
            for (GrupoDato listaFinal : listaGD) {
                document.add(new Paragraph("        " + pfCont + ") " + listaFinal.getNomGD() + ". Descripci�n: " + listaFinal.getDescripcion(), fontNormal2));
                pfCont++;
            }
            //Fin #GD

            //Sumatoria de MD
            document.add(new Paragraph("  "));
            document.add(new Paragraph("        Sumatoria de Movimientos de Datos", fontNormal2));
            document.add(new Paragraph("  "));
            PdfPTable tableResumenPF = new PdfPTable(5);
            tableResumenPF.setTotalWidth(400f);
            tableResumenPF.setLockedWidth(true);
            tableResumenPF.setWidths(new float[]{1, 1, 1, 1, 1});

            PdfPCell cellRX = new PdfPCell(new Paragraph("X"));
            cellRX.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRX.setBorderColor(BaseColor.BLUE);
            cellRX.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRX);

            PdfPCell cellRL = new PdfPCell(new Paragraph("L"));
            cellRL.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRL.setBorderColor(BaseColor.BLUE);
            cellRL.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRL);

            PdfPCell cellRE = new PdfPCell(new Paragraph("E"));
            cellRE.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRE.setBorderColor(BaseColor.BLUE);
            cellRE.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRE);

            PdfPCell cellRW = new PdfPCell(new Paragraph("W"));
            cellRW.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRW.setBorderColor(BaseColor.BLUE);
            cellRW.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRW);

            PdfPCell cellTot = new PdfPCell(new Paragraph("Total"));
            cellTot.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTot.setBorderColor(BaseColor.BLUE);
            cellTot.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellTot);

            int sumaX = 0, sumaR = 0, sumaE = 0, sumaW = 0;
            for (ProcesoFuncional proceso : listaPF) {
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proceso.getIdprocesoFuncional());

                for (SubProceso sub : subProcesos) {
                    AccionJpaController acjpa = new AccionJpaController(EntityProvider.provider());
                    Accion accion = acjpa.findAccion(sub.getIdaccion().getIdaccion());

                    if (String.format("%s", accion.getMovDatos()).equals("E")) {
                        sumaE = sumaE + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("X")) {
                        sumaX = sumaX + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("R")) {
                        sumaR = sumaR + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("W")) {
                        sumaW = sumaW + 1;
                    }
                }
            }
            PdfPCell cellSumX = new PdfPCell(new Paragraph("" + sumaX));
            cellSumX.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumX.setBorderColor(BaseColor.BLUE);
            cellSumX.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumX);

            PdfPCell cellSumR = new PdfPCell(new Paragraph("" + sumaR));
            cellSumR.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumR.setBorderColor(BaseColor.BLUE);
            cellSumR.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumR);

            PdfPCell cellSumE = new PdfPCell(new Paragraph("" + sumaE));
            cellSumE.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumE.setBorderColor(BaseColor.BLUE);
            cellSumE.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumE);

            PdfPCell cellSumW = new PdfPCell(new Paragraph("" + sumaW));
            cellSumW.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumW.setBorderColor(BaseColor.BLUE);
            cellSumW.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumW);

            int sumaTotal = sumaX + sumaR + sumaE + sumaW;
            PdfPCell cellT = new PdfPCell(new Paragraph("" + sumaTotal));
            cellT.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellT.setBorderColor(BaseColor.BLUE);
            cellT.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellT);

            DecimalFormat df = new DecimalFormat("#.00");
            PdfPCell cellSumX1 = new PdfPCell(new Paragraph("" + df.format((double) sumaX / (double) sumaTotal * 100) + "%"));
            cellSumX1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumX1.setBorderColor(BaseColor.BLUE);
            cellSumX1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumX1);

            PdfPCell cellSumR1 = new PdfPCell(new Paragraph("" + df.format((double) sumaR / (double) sumaTotal * 100) + "%"));
            cellSumR1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumR1.setBorderColor(BaseColor.BLUE);
            cellSumR1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumR1);

            PdfPCell cellSumE1 = new PdfPCell(new Paragraph("" + df.format((double) sumaE / (double) sumaTotal * 100) + "%"));
            cellSumE1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumE1.setBorderColor(BaseColor.BLUE);
            cellSumE1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumE1);

            PdfPCell cellSumW1 = new PdfPCell(new Paragraph("" + df.format((double) sumaW / (double) sumaTotal * 100) + "%"));
            cellSumW1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumW1.setBorderColor(BaseColor.BLUE);
            cellSumW1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumW1);

            PdfPCell cellSumT1 = new PdfPCell(new Paragraph("100.00 %"));
            cellSumT1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumT1.setBorderColor(BaseColor.BLUE);
            cellSumT1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumT1);

            document.add(tableResumenPF);
            //Fin Sumatoria MD

            //Diagrama de Contexto Total
            document.newPage();
            document.add(tableh);
            document.add(imgUnam);
            document.add(new Paragraph("   "));
            document.add(new Paragraph("   "));
            document.add(new Paragraph("    Diagrama Global de Contexto", fontNormal2));
            Font helvetica = new Font(FontFamily.HELVETICA, 12);
            BaseFont bf_helv = helvetica.getCalculatedBaseFont(false);
            PdfContentByte under = writer.getDirectContentUnder();
            under.saveState();
            under.setColorStroke(BaseColor.ORANGE);
            under.roundRectangle(50, 225, 140, 40, 7);
            under.setLineWidth(2);
            under.stroke();
            under.setFontAndSize(bf_helv, 15);
            //under.showTextAligned(Element.ALIGN_LEFT, usuarioCtx.getNomUF(), 60, 315, 0);
            under.showTextAligned(Element.ALIGN_LEFT, "Usuario Funcional", 60, 240, 0);
            under.restoreState();

            Image img = Image.getInstance(arrowR);
            Image img2 = Image.getInstance(arrowUpDown);
            Image img3 = Image.getInstance(bdPng);
            Image img4 = Image.getInstance(dottedLine);
            Image img5 = Image.getInstance(dottedLine);
            Image img6 = Image.getInstance(arrowX);
            Image img7 = Image.getInstance(userFunc);
            img.setAbsolutePosition(230, 290);
            img2.setAbsolutePosition(400, 190);
            img3.setAbsolutePosition(350, 130);
            img4.setAbsolutePosition(162, 225);
            img5.setAbsolutePosition(480, 225);
            img6.setAbsolutePosition(550, 290);
            img7.setAbsolutePosition(57, 280);
            document.add(img);
            document.add(img2);
            document.add(img3);
            document.add(img4);
            document.add(img5);
            document.add(img6);
            document.add(img7);

            PdfContentByte under2 = writer.getDirectContentUnder();
            under2.saveState();
            under2.setColorStroke(BaseColor.BLUE);
            under2.roundRectangle(335, 265, 180, 120, 10);
            under2.setLineWidth(3);
            under2.stroke();
            under2.setFontAndSize(bf_helv, 18);
            under2.showTextAligned(Element.ALIGN_LEFT, proy.getNomProy(), 400, 315, 0);
            under2.restoreState();

            PdfContentByte under3 = writer.getDirectContentUnder();
            under3.saveState();
            under3.setColorStroke(BaseColor.RED);
            under3.roundRectangle(645, 300, 150, 40, 7);
            under3.setLineWidth(2);
            under3.stroke();
            under3.setFontAndSize(bf_helv, 15);
            under3.showTextAligned(Element.ALIGN_LEFT, "Sistema de Pagos", 650, 315, 0);
            under3.restoreState();
            //Fin Diagrama de Contexto Total

            //Creacion de Matriz
            document.newPage();
            document.add(tableh);
            document.add(imgUnam);
            document.add(new Paragraph("   "));
            document.add(new Paragraph("                                                            Formato Para Medición y Rastreo de Requerimientos", fontNormal2));
            document.add(new Paragraph("  "));
            PdfPTable table = new PdfPTable(9);
            table.setTotalWidth(800f);
            table.setLockedWidth(true);
            table.setWidths(new float[]{0.5f, 2, 2.5f, 1.2f, 3, 1.2f, 0.5f, 0.5f, 0.6f});

            Phrase p3 = new Phrase("PF", fontVer1);
            PdfPCell cell3 = new PdfPCell(p3);
            cell3.setNoWrap(false);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell3);

            Phrase p4 = new Phrase("Proceso Funcional", fontVer1);
            PdfPCell cell4 = new PdfPCell(p4);
            cell4.setNoWrap(false);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell4);

            Phrase p5 = new Phrase("Evento Desencadenante", fontVer1);
            PdfPCell cell5 = new PdfPCell(p5);
            cell5.setNoWrap(false);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell5);

            Phrase p6 = new Phrase("Actor", fontVer1);
            PdfPCell cell6 = new PdfPCell(p6);
            cell6.setNoWrap(false);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell6);
            Phrase p7 = new Phrase("Descripci�n de Subproceso", fontVer1);
            PdfPCell cell7 = new PdfPCell(p7);
            cell7.setNoWrap(false);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell7);

            Phrase p8 = new Phrase("GD", fontVer1);
            PdfPCell cell8 = new PdfPCell(p8);
            cell8.setNoWrap(false);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell8);

            Phrase p9 = new Phrase("MD", fontVer1);
            PdfPCell cell9 = new PdfPCell(p9);
            cell9.setNoWrap(false);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell9);

            Phrase p10 = new Phrase("CFP", fontVer1);
            PdfPCell cell10 = new PdfPCell(p10);
            cell10.setNoWrap(false);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell10);

            Phrase p11 = new Phrase("Suma", fontVer1);
            PdfPCell cell11 = new PdfPCell(p11);
            cell11.setNoWrap(false);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell11);

            UsuarioFuncional usuarioCtx = new UsuarioFuncional();
            int i = 1;
            int auxi = 0;
            int suma = 0;
            for (ProcesoFuncional proceso : listaPF) {
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proceso.getIdprocesoFuncional());

                auxi = i;
                for (SubProceso sub : subProcesos) {
                    PdfPCell cellId;
                    if (auxi == i) {
                        cellId = new PdfPCell(new Phrase("" + i, fontNormal));
                    } else {
                        cellId = new PdfPCell(new Phrase(""));
                    }
                    if (auxi % 2 == 0) {
                        cellId.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    cellId.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellId);

                    PdfPCell cellPF = new PdfPCell(new Phrase(proceso.getNomPF(), fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellPF);

                    PdfPCell cellED = new PdfPCell(new Phrase(proceso.getEventoDes(), fontNormal));
                    cellED.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellED.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellPF);

                    UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
                    UsuarioFuncional usuario = ufjpa.findUsuarioFuncional(sub.getIdusuarioFuncional().getIdusuarioFuncional());
                    usuarioCtx = usuario;
                    PdfPCell cellUF = new PdfPCell(new Phrase(usuario.getNomUF(), fontNormal));
                    cellUF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellUF.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellUF);

                    PdfPCell cellSP = new PdfPCell(new Phrase(sub.getDescripcion(), fontNormal));
                    cellSP.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellSP.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellSP);

                    GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
                    GrupoDato grupoDato = gdjpa.findGrupoDato(sub.getIdgrupoDato().getIdgrupoDato());
                    PdfPCell cellGD = new PdfPCell(new Phrase(grupoDato.getNomGD(), fontNormal));
                    cellGD.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellGD.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellGD);

                    AccionJpaController acjpa = new AccionJpaController(EntityProvider.provider());
                    Accion accion = acjpa.findAccion(sub.getIdaccion().getIdaccion());
                    PdfPCell cellAc = new PdfPCell(new Phrase("" + accion.getMovDatos(), fontNormal));
                    cellAc.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellAc.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellAc);

                    PdfPCell cellCFP = new PdfPCell(new Phrase("1", fontNormal));
                    cellCFP.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellCFP.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellCFP);

                    PdfPCell cellSumaCFP = new PdfPCell(new Phrase(""));
                    if (auxi % 2 == 0) {
                        cellSumaCFP.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    table.addCell(cellSumaCFP);

                    auxi++;
                    //Inserciones en Histórico
                    HistoricoJpaController hjpac = new HistoricoJpaController(EntityProvider.provider());
                    Historico historico = new Historico();
                    historico.setIdProy(proy.getIdproyecto());
                    historico.setNombreProy(proy.getNomProy());
                    historico.setProposito(proy.getProposito());
                    historico.setAlcanceProy(proy.getAlcance());
                    historico.setNombrePF(proceso.getNomPF());
                    historico.setDescripcionPF(proceso.getDescripcion());
                    historico.setTamanioPF(proceso.getTamPF());
                    historico.setEventoDesPF(proceso.getEventoDes());
                    historico.setDescripcionSP(sub.getDescripcion());
                    Date fecha = new Date();
                    historico.setFecha(fecha);
                    historico.setNombreGD(grupoDato.getNomGD());
                    historico.setDescripcionGD(grupoDato.getDescripcion());
                    historico.setNombreUF(usuario.getNomUF());
                    historico.setDescripcionUF(usuario.getDescripcion());
                    historico.setUsuarioSistemaUF(usuario.getUsuarioSistema());
                    historico.setNombreAccion(accion.getNomAccion());
                    historico.setMovDatos(String.format("%c", accion.getMovDatos()));

                    hjpac.create(historico);
                    //Fin de Inserciones en Històrico
                }

                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                PdfPCell cellSuma = new PdfPCell(new Phrase("" + subProcesos.size(), fontNormal));
                cellSuma.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellSuma);

                suma += subProcesos.size();
                i++;
            }

            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");
            PdfPCell cellSuma = new PdfPCell(new Phrase("Total: " + suma, fontNormal));
            cellSuma.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSuma.setBackgroundColor(BaseColor.YELLOW);
            table.addCell(cellSuma);

            document.add(table);

            //Fin de creación de matriz
            //Fin Resumen Medición
            //Secci�n 3: Información Detalla Proceso Funcional (Nombre PF, Desc. PF, Diag. Act., Diag. Ctx., Diag. Sec.
            document.add(new Paragraph("  "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("  "));
            document.add(new Paragraph("    3. INFORMACI�N DETALLADA POR PROCESO FUNCIONAL", fontNormal2));
            document.add(new Paragraph("  "));

            for (ProcesoFuncional proc : listaPF) {
                document.newPage();
                document.add(tableh);
                document.add(imgUnam);
                document.add(new Paragraph("    Nombre: " + proc.getNomPF(), fontNormal2));
                document.add(new Paragraph("    Descripción: " + proc.getDescripcion(), fontNormal2));
                document.add(new Paragraph("   "));

                //Sumatoria de MD
                document.add(new Paragraph("    Sumatoria de Movimientos de Datos del Proceso Funcional", fontNormal2));
                document.add(new Paragraph("  "));
                PdfPTable tableResumenPF1 = new PdfPTable(5);
                tableResumenPF1.setTotalWidth(400f);
                tableResumenPF1.setLockedWidth(true);
                tableResumenPF1.setWidths(new float[]{1, 1, 1, 1, 1});

                PdfPCell cellRX1 = new PdfPCell(new Paragraph("X"));
                cellRX1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRX1.setBorderColor(BaseColor.BLUE);
                cellRX1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRX1);

                PdfPCell cellRL1 = new PdfPCell(new Paragraph("L"));
                cellRL1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRL1.setBorderColor(BaseColor.BLUE);
                cellRL1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRL1);

                PdfPCell cellRE1 = new PdfPCell(new Paragraph("E"));
                cellRE1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRE1.setBorderColor(BaseColor.BLUE);
                cellRE1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRE1);

                PdfPCell cellRW1 = new PdfPCell(new Paragraph("W"));
                cellRW1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRW1.setBorderColor(BaseColor.BLUE);
                cellRW1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRW1);

                PdfPCell cellTot1 = new PdfPCell(new Paragraph("Total"));
                cellTot1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTot1.setBorderColor(BaseColor.BLUE);
                cellTot1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellTot1);

                int sumaX1 = 0, sumaR1 = 0, sumaE1 = 0, sumaW1 = 0;
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proc.getIdprocesoFuncional());

                for (SubProceso sub : subProcesos) {
                    AccionJpaController acjpa = new AccionJpaController(EntityProvider.provider());
                    Accion accion = acjpa.findAccion(sub.getIdaccion().getIdaccion());

                    if (String.format("%s", accion.getMovDatos()).equals("E")) {
                        sumaE = sumaE + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("X")) {
                        sumaX = sumaX + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("R")) {
                        sumaR = sumaR + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("W")) {
                        sumaW = sumaW + 1;
                    }
                }
                PdfPCell cellSumX11 = new PdfPCell(new Paragraph("" + sumaX1));
                cellSumX11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumX11.setBorderColor(BaseColor.BLUE);
                cellSumX11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumX1);

                PdfPCell cellSumR11 = new PdfPCell(new Paragraph("" + sumaR1));
                cellSumR11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumR11.setBorderColor(BaseColor.BLUE);
                cellSumR11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumR11);

                PdfPCell cellSumE11 = new PdfPCell(new Paragraph("" + sumaE1));
                cellSumE11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumE11.setBorderColor(BaseColor.BLUE);
                cellSumE11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumE11);

                PdfPCell cellSumW11 = new PdfPCell(new Paragraph("" + sumaW1));
                cellSumW11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumW11.setBorderColor(BaseColor.BLUE);
                cellSumW11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumW11);

                int sumaTotal1 = sumaX1 + sumaR1 + sumaE1 + sumaW1;
                PdfPCell cellT1 = new PdfPCell(new Paragraph("" + sumaTotal1));
                cellT1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellT1.setBorderColor(BaseColor.BLUE);
                cellT1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellT1);

                DecimalFormat df1 = new DecimalFormat("#.00");
                PdfPCell cellSumX10 = new PdfPCell(new Paragraph("" + df.format((double) sumaX1 / (double) sumaTotal1 * 100) + "%"));
                cellSumX10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumX10.setBorderColor(BaseColor.BLUE);
                cellSumX10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumX10);

                PdfPCell cellSumR10 = new PdfPCell(new Paragraph("" + df.format((double) sumaR1 / (double) sumaTotal1 * 100) + "%"));
                cellSumR10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumR10.setBorderColor(BaseColor.BLUE);
                cellSumR10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumR10);

                PdfPCell cellSumE10 = new PdfPCell(new Paragraph("" + df.format((double) sumaE1 / (double) sumaTotal1 * 100) + "%"));
                cellSumE10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumE10.setBorderColor(BaseColor.BLUE);
                cellSumE10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumE10);

                PdfPCell cellSumW10 = new PdfPCell(new Paragraph("" + df.format((double) sumaW1 / (double) sumaTotal1 * 100) + "%"));
                cellSumW10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumW10.setBorderColor(BaseColor.BLUE);
                cellSumW10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumW10);

                PdfPCell cellSumT10 = new PdfPCell(new Paragraph("100.00 %"));
                cellSumT10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumT10.setBorderColor(BaseColor.BLUE);
                cellSumT10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumT10);

                document.add(tableResumenPF);
                //Fin Sumatoria MD

                //Diagrama de Actividades
                document.add(new Paragraph("  "));
                SubProcesoJpaController spjpa3 = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos3 = spjpa3.findSPByIdProcesoFuncionalR(proc.getIdprocesoFuncional());
                int posicionY = 318;
                int contSub = 1;
                for (SubProceso subP : subProcesos3) {
                    PdfPTable table1 = new PdfPTable(1);
                    table1.setTotalWidth(160f);
                    table1.setLockedWidth(true);

                    Phrase phrase = new Phrase(subP.getDescripcion(), fontNormal2);
                    PdfPCell cellAct = new PdfPCell(phrase);
                    cellAct.setNoWrap(false);
                    cellAct.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellAct.setBackgroundColor(BaseColor.YELLOW);
                    table1.addCell(cellAct);

                    document.add(table1);
                    document.add(new Paragraph("   "));
                    document.add(new Paragraph("   "));

                    if (subProcesos.size() != contSub) {
                        if (contSub == 1) {
                            posicionY = posicionY - (int) table1.getTotalHeight();
                        }
                        Image imgAct = Image.getInstance(arrowAct);
                        imgAct.setAbsolutePosition(410, posicionY);
                        document.add(imgAct);
                        posicionY -= (table1.getTotalHeight() + 36);
                    }
                    contSub++;
                }
                //Fin Diagrama de Actividades

                //Diagrama de Secuencia
                double sizeLine = (35.0 * subProcesos.size()) + 20.0;
                PdfContentByte under4 = writer.getDirectContentUnder();
                under4.setColorStroke(BaseColor.BLACK);
                under4.setLineWidth(3);
                under4.moveTo(170.0, 350.0);
                under4.lineTo(170.0, 350.0 - sizeLine);
                under4.stroke();

                int posYact = 320;
                int posMD = 325;
                for (SubProceso sub : subProcesos) {
                    under4.setColorStroke(BaseColor.BLACK);
                    under4.setLineWidth(1.5);
                    under4.setFontAndSize(bf_helv, 15);
                    under4.moveTo(170.0, posYact);

                    AccionJpaController acjpa = new AccionJpaController(EntityProvider.provider());
                    Accion accion = acjpa.findAccion(sub.getIdaccion().getIdaccion());
                    if (Objects.equals(accion.getMovDatos().toString(), "X") || Objects.equals(accion.getMovDatos().toString(), "E")) {
                        under4.lineTo(70.0, posYact);
                        under4.showTextAligned(Element.ALIGN_CENTER, accion.getMovDatos().toString(), 150, posMD, 0);
                    } else if (Objects.equals(accion.getMovDatos().toString(), "R") || Objects.equals(accion.getMovDatos().toString(), "W")) {
                        under4.lineTo(270.0, posYact);
                        under4.showTextAligned(Element.ALIGN_CENTER, accion.getMovDatos().toString(), 190, posMD, 0);
                    }
                    under4.stroke();
                    posYact -= 35;
                    posMD -= 35;
                }
                //Fin Diagrama de Secuencia

//                //Diagrama de Actividades
//                Image image = Image.getInstance(userFunc2);
//                image.setAbsolutePosition(630, 435);
//                document.add(image);
//
//                UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
//                UsuarioFuncional usuarioFunc = ufjpa.findUsuarioFuncional(subProcesos.get(0).getIdusuarioFuncional().getIdusuarioFuncional());
//                under4.saveState();
//                under4.setColorStroke(BaseColor.BLACK);
//                under4.roundRectangle(595, 400, 150, 25, 7);
//                under4.setLineWidth(1.5);
//                under4.stroke();
//                under4.setFontAndSize(bf_helv, 12);
//                under4.showTextAligned(Element.ALIGN_LEFT, usuarioFunc.getNomUF(), 605, 410, 0);
//                under4.restoreState();
//
//                Image image2 = Image.getInstance(arrowUpDown2);
//                image2.setAbsolutePosition(664, 355);
//                document.add(image2);
//
//                under4.saveState();
//                under4.setColorStroke(BaseColor.BLACK);
//                under4.roundRectangle(595, 270, 150, 70, 10);
//                under4.setLineWidth(1.5);
//                under4.stroke();
//                under4.setFontAndSize(bf_helv, 13);
//                under4.showTextAligned(Element.ALIGN_LEFT, proy.getNomProy(), 605, 300, 0);
//                under4.restoreState();
//                
//                Image image3 = Image.getInstance(arrowUpDown2);
//                image3.setAbsolutePosition(664, 227);
//                document.add(image3);
//                
//                under4.saveState();
//                under4.setColorStroke(BaseColor.BLACK);
//                under4.roundRectangle(595, 185, 150, 25, 7);
//                under4.setLineWidth(1.5);
//                under4.stroke();
//                under4.setFontAndSize(bf_helv, 12);
//                under4.showTextAligned(Element.ALIGN_LEFT, "Sistema de Pagos", 605, 194, 0);
//                under4.restoreState();
                //Fin Diagrama de Actividades
            }
            //Fin Información Detalla por Proceso Funcional
//                //Fin Diagrama de Actividades
//            }
//            //Fin Informacion Detalla por Proceso Funcional

            document.close();
            archivo.flush();
            archivo.close();
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Este es el error en el objeto " + ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
        Proyecto p = pjpa.findProyecto(idProyecto);

        HttpSession session = request.getSession(true);
        ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
        List<ProcesoFuncional> pf = pfjpa.findPFByIdProyectoActivo(idProyecto);

        GeneraReporte objeto = new GeneraReporte();
        try {
            objeto.generatePDF(p, pf);
        } catch (Exception ex) {
            System.out.println("Este es el error en el objeto 2: " + ex.getMessage());
        }

        File file = new File("C:\\Users\\jlope\\Documents\\NetBeansProjects\\SGPF\\SGPF\\results\\matriz.pdf");
        response.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"matriz.pdf\"");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}
