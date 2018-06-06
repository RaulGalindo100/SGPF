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
            Font fontNormal3 = new Font(FontFamily.HELVETICA, 11, Font.NORMAL, BaseColor.BLACK);
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

            cell = new PdfPCell(new Paragraph("Reporte", fontVer1));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);

            cell = new PdfPCell(new Paragraph("Medición de Software", fontVer1));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);

            cell = new PdfPCell(new Paragraph("Reporte de Aproximación de Tamaño Funcional para Proyecto '"
                    + proy.getNomProy() + "'", fontVer));
            cell.setColspan(1);
            cell.setRowspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh.addCell(cell);

            cell = new PdfPCell(new Paragraph(proy.getNomProy(), fontVer1));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);

            cell = new PdfPCell(new Paragraph(fechaActual, fontVer1));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh.addCell(cell);
            document.add(tableh);

            Image imgUnam = Image.getInstance(logoUnam);
            imgUnam.setAbsolutePosition(81, 510);
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
            BaseColor color = new BaseColor(44, 62, 80);
            BaseColor colorGris = new BaseColor(0, 0, 0, 0.05f);
            BaseColor colorAzul = new BaseColor(21, 60, 100);
            Font fuenteBlanca = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            Font fuenteAzul = new Font(FontFamily.TIMES_ROMAN, 16, Font.NORMAL, colorAzul);
            Font fuenteAzul2 = new Font(FontFamily.TIMES_ROMAN, 14, Font.NORMAL, colorAzul);

            document.add(new Paragraph("   "));
            document.add(new Paragraph("        1.  DATOS DEL PROYECTO", fuenteAzul));
            document.add(new Paragraph("   "));
            PdfPTable tableD = new PdfPTable(2);
            tableD.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableD.setTotalWidth(350f);
            tableD.setLockedWidth(true);
            tableD.setWidths(new float[]{1.1f, 1.9f});

            PdfPCell cellD = new PdfPCell(new Paragraph("Nombre:", fontNormal));
            cellD.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellD.setBackgroundColor(colorGris);
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);
            cellD = new PdfPCell(new Paragraph(" " + proy.getNomProy(), fontNormal));
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);

            cellD = new PdfPCell(new Paragraph("Número de PF:", fontNormal));
            cellD.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellD.setBackgroundColor(colorGris);
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);
            cellD = new PdfPCell(new Paragraph(" " + listaPF.size(), fontNormal));
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);

            cellD = new PdfPCell(new Paragraph("Propósito:", fontNormal));
            cellD.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellD.setBackgroundColor(colorGris);
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);
            cellD = new PdfPCell(new Paragraph(" " + proy.getProposito(), fontNormal));
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);

            cellD = new PdfPCell(new Paragraph("Alcance:", fontNormal));
            cellD.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellD.setBackgroundColor(colorGris);
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);
            cellD = new PdfPCell(new Paragraph(" " + proy.getAlcance(), fontNormal));
            cellD.setBorderColor(colorAzul);
            tableD.addCell(cellD);

            document.add(tableD);

            //document.add(new Paragraph("    Arquitectura del Proyecto: " + proy.getAlcance() ));
            document.add(new Paragraph("  "));
            //Fin Datos del Proyecto

            //Resumen Medición /#PF, #UF, #GD, MD Totales (tabla, porcentaje) , Diag Ctx Total, Matriz FP
            document.add(new Paragraph("        2.  RESUMEN DE MEDICIÓN", fuenteAzul));

            //# Procesos Funcionales
            document.add(new Paragraph("        Procesos Funcionales", fuenteAzul2));
            int pfCont = 1;
            for (ProcesoFuncional pf : listaPF) {

                document.add(new Paragraph("        " + pfCont + ") " + pf.getNomPF() + ". Descripción: " + pf.getDescripcion(), fontNormal2));

                pfCont++;
            }
            //Fin #Procesos Funcionales

            //#UF
            document.add(new Paragraph("  "));
            document.add(new Paragraph("        Usuarios Funcionales", fuenteAzul2));
            
            UsuarioFuncional userAdmin = new UsuarioFuncional();
            UsuarioFuncional userSistema = new UsuarioFuncional();
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
                if (listaFinal.getUsuarioSistema() == 0) {
                    userAdmin = listaFinal;
                } else {
                    userSistema = listaFinal;
                }
                pfCont++;
            }
            //Fin #UF

            //# GD
            document.add(new Paragraph("  "));
            document.add(new Paragraph("        Grupos de Datos", fuenteAzul2));

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

                    if (!yaEsta && !Objects.equals(sub.getIdgrupoDato().getNomGD(), "N/A")) {
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
            document.add(new Paragraph("  "));
            document.add(new Paragraph("        Sumatoria de Movimientos de Datos", fuenteAzul2));
            document.add(new Paragraph("  "));
            PdfPTable tableResumenPF = new PdfPTable(6);
            tableResumenPF.setTotalWidth(480f);
            tableResumenPF.setLockedWidth(true);
            tableResumenPF.setWidths(new float[]{1, 1, 1, 1, 1, 1});

            PdfPCell cellRX = new PdfPCell(new Paragraph("X"));
            cellRX.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRX.setBorderColor(colorAzul);
            cellRX.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRX);

            PdfPCell cellRL = new PdfPCell(new Paragraph("R"));
            cellRL.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRL.setBorderColor(colorAzul);
            cellRL.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRL);

            PdfPCell cellRE = new PdfPCell(new Paragraph("E"));
            cellRE.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRE.setBorderColor(colorAzul);
            cellRE.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRE);

            PdfPCell cellRW = new PdfPCell(new Paragraph("W"));
            cellRW.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellRW.setBorderColor(colorAzul);
            cellRW.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellRW);

            PdfPCell cellSW = new PdfPCell(new Paragraph("S"));
            cellSW.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSW.setBorderColor(colorAzul);
            cellSW.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSW);

            PdfPCell cellTot = new PdfPCell(new Paragraph("Total"));
            cellTot.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTot.setBorderColor(colorAzul);
            cellTot.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellTot);

            int sumaX = 0, sumaR = 0, sumaE = 0, sumaW = 0, sumaS = 0, sumaTotalS = 0;
            for (ProcesoFuncional proceso : listaPF) {
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proceso.getIdprocesoFuncional());
                sumaS = 0;
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
                    } else if (String.format("%s", accion.getMovDatos()).equals("S")) {
                        sumaS = 1;
                    }
                }
                sumaTotalS += sumaS;
            }
            PdfPCell cellSumX = new PdfPCell(new Paragraph("" + sumaX));
            cellSumX.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumX.setBorderColor(colorAzul);
            cellSumX.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumX);

            PdfPCell cellSumR = new PdfPCell(new Paragraph("" + sumaR));
            cellSumR.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumR.setBorderColor(colorAzul);
            cellSumR.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumR);

            PdfPCell cellSumE = new PdfPCell(new Paragraph("" + sumaE));
            cellSumE.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumE.setBorderColor(colorAzul);
            cellSumE.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumE);

            PdfPCell cellSumW = new PdfPCell(new Paragraph("" + sumaW));
            cellSumW.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumW.setBorderColor(colorAzul);
            cellSumW.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumW);

            PdfPCell cellSumS = new PdfPCell(new Paragraph("" + sumaTotalS));
            cellSumS.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumS.setBorderColor(colorAzul);
            cellSumS.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumS);

            int sumaTotal = sumaX + sumaR + sumaE + sumaW + sumaTotalS;
            PdfPCell cellT = new PdfPCell(new Paragraph("" + sumaTotal));
            cellT.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellT.setBorderColor(colorAzul);
            cellT.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellT);

            DecimalFormat df = new DecimalFormat("#.00");
            PdfPCell cellSumX1 = new PdfPCell(new Paragraph("" + df.format((double) sumaX / (double) sumaTotal * 100) + "%"));
            cellSumX1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumX1.setBorderColor(colorAzul);
            cellSumX1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumX1);

            PdfPCell cellSumR1 = new PdfPCell(new Paragraph("" + df.format((double) sumaR / (double) sumaTotal * 100) + "%"));
            cellSumR1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumR1.setBorderColor(colorAzul);
            cellSumR1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumR1);

            PdfPCell cellSumE1 = new PdfPCell(new Paragraph("" + df.format((double) sumaE / (double) sumaTotal * 100) + "%"));
            cellSumE1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumE1.setBorderColor(colorAzul);
            cellSumE1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumE1);

            PdfPCell cellSumW1 = new PdfPCell(new Paragraph("" + df.format((double) sumaW / (double) sumaTotal * 100) + "%"));
            cellSumW1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumW1.setBorderColor(colorAzul);
            cellSumW1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumW1);

            PdfPCell cellSumS1 = new PdfPCell(new Paragraph("" + df.format((double) sumaTotalS / (double) sumaTotal * 100) + "%"));
            cellSumS1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumS1.setBorderColor(colorAzul);
            cellSumS1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumS1);

            PdfPCell cellSumT1 = new PdfPCell(new Paragraph("100.00 %"));
            cellSumT1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellSumT1.setBorderColor(colorAzul);
            cellSumT1.setBorderWidth(1.5f);
            tableResumenPF.addCell(cellSumT1);

            document.add(tableResumenPF);
            //Fin Sumatoria MD

            //Diagrama de Contexto Total
            document.newPage();
            document.add(tableh);
            document.add(imgUnam);
            document.add(new Paragraph("   "));
            document.add(new Paragraph("        Diagrama Global de Contexto", fuenteAzul));
            Font helvetica = new Font(FontFamily.HELVETICA, 12);
            BaseFont bf_helv = helvetica.getCalculatedBaseFont(false);
            PdfContentByte under = writer.getDirectContentUnder();
            under.saveState();
            under.setColorStroke(colorAzul);
            under.roundRectangle(60, 239, 120, 22, 5);
            under.setLineWidth(2);
            under.stroke();
            under.setFontAndSize(bf_helv, 12);
            //under.showTextAligned(Element.ALIGN_LEFT, usuarioCtx.getNomUF(), 60, 315, 0);
            under.showTextAligned(Element.ALIGN_CENTER, userAdmin.getNomUF(), 120, 245, 0);
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
            under2.setColorStroke(colorAzul);
            under2.roundRectangle(355, 290, 150, 70, 7);
            under2.setLineWidth(2);
            under2.stroke();
            under2.setFontAndSize(bf_helv, 14);
            under2.showTextAligned(Element.ALIGN_CENTER, proy.getNomProy(), 430, 319, 0);
            under2.restoreState();

            PdfContentByte under3 = writer.getDirectContentUnder();
            under3.saveState();
            under3.setColorStroke(colorAzul);
            under3.roundRectangle(645, 310, 120, 25, 5);
            under3.setLineWidth(2);
            under3.stroke();
            under3.setFontAndSize(bf_helv, 12);
            if (userSistema.getNomUF() != null) {
                under3.showTextAligned(Element.ALIGN_CENTER, userSistema.getNomUF(), 705, 317, 0);
            }else{
                under3.showTextAligned(Element.ALIGN_CENTER, "Sistema", 705, 317, 0);
            }
            under3.restoreState();
            //Fin Diagrama de Contexto Total

            //Creacion de Matriz
            document.newPage();
            document.add(tableh);
            document.add(imgUnam);
            document.add(new Paragraph("   "));
            document.add(new Paragraph("                                                            Formato Para Medición y Rastreo de Requerimientos", fuenteAzul2));
            document.add(new Paragraph("  "));
            PdfPTable table = new PdfPTable(9);
            table.setTotalWidth(800f);
            table.setLockedWidth(true);
            table.setWidths(new float[]{0.5f, 2, 2.5f, 1.2f, 3, 1.2f, 0.5f, 0.5f, 0.6f});

            Phrase p3 = new Phrase("PF", fontVer1);
            PdfPCell cell3 = new PdfPCell(p3);
            cell3.setNoWrap(false);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setBackgroundColor(colorGris);
            table.addCell(cell3);

            Phrase p4 = new Phrase("Proceso Funcional", fontVer1);
            PdfPCell cell4 = new PdfPCell(p4);
            cell4.setNoWrap(false);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setBackgroundColor(colorGris);
            table.addCell(cell4);

            Phrase p5 = new Phrase("Evento Desencadenante", fontVer1);
            PdfPCell cell5 = new PdfPCell(p5);
            cell5.setNoWrap(false);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setBackgroundColor(colorGris);
            table.addCell(cell5);

            Phrase p6 = new Phrase("Actor", fontVer1);
            PdfPCell cell6 = new PdfPCell(p6);
            cell6.setNoWrap(false);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setBackgroundColor(colorGris);
            table.addCell(cell6);
            Phrase p7 = new Phrase("Descripción de Subproceso", fontVer1);
            PdfPCell cell7 = new PdfPCell(p7);
            cell7.setNoWrap(false);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell7.setBackgroundColor(colorGris);
            table.addCell(cell7);

            Phrase p8 = new Phrase("GD", fontVer1);
            PdfPCell cell8 = new PdfPCell(p8);
            cell8.setNoWrap(false);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setBackgroundColor(colorGris);
            table.addCell(cell8);

            Phrase p9 = new Phrase("MD", fontVer1);
            PdfPCell cell9 = new PdfPCell(p9);
            cell9.setNoWrap(false);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell9.setBackgroundColor(colorGris);
            table.addCell(cell9);

            Phrase p10 = new Phrase("CFP", fontVer1);
            PdfPCell cell10 = new PdfPCell(p10);
            cell10.setNoWrap(false);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setBackgroundColor(colorGris);
            table.addCell(cell10);

            Phrase p11 = new Phrase("Suma", fontVer1);
            PdfPCell cell11 = new PdfPCell(p11);
            cell11.setNoWrap(false);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setBackgroundColor(colorGris);
            table.addCell(cell11);

            int i = 1;
            int auxi = 0;
            int suma = 0;
            boolean isEse;
            int sumador = 0;
            for (ProcesoFuncional proceso : listaPF) {
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proceso.getIdprocesoFuncional());

                auxi = i;
                sumador = 0;
                isEse = false;
                for (SubProceso sub : subProcesos) {
                    AccionJpaController acjpa = new AccionJpaController(EntityProvider.provider());
                    Accion accion = acjpa.findAccion(sub.getIdaccion().getIdaccion());

                    if (!accion.getMovDatos().equals('S')) {
                        PdfPCell cellId;
                        if (auxi == i) {
                            cellId = new PdfPCell(new Phrase("" + i, fontNormal));
                        } else {
                            cellId = new PdfPCell(new Phrase(""));
                        }
                        if (auxi % 2 == 0) {
                            cellId.setBackgroundColor(colorGris);
                        }
                        cellId.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cellId);

                        PdfPCell cellPF = new PdfPCell(new Phrase(proceso.getNomPF(), fontNormal));
                        cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                        if (auxi % 2 == 0) {
                            cellPF.setBackgroundColor(colorGris);
                        }
                        table.addCell(cellPF);

                        PdfPCell cellED = new PdfPCell(new Phrase(proceso.getEventoDes(), fontNormal));
                        cellED.setHorizontalAlignment(Element.ALIGN_CENTER);
                        if (auxi % 2 == 0) {
                            cellED.setBackgroundColor(colorGris);
                        }
                        table.addCell(cellED);

                        UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
                        UsuarioFuncional usuario = ufjpa.findUsuarioFuncional(sub.getIdusuarioFuncional().getIdusuarioFuncional());

                        PdfPCell cellUF = new PdfPCell(new Phrase(usuario.getNomUF(), fontNormal));
                        cellUF.setHorizontalAlignment(Element.ALIGN_CENTER);
                        if (auxi % 2 == 0) {
                            cellUF.setBackgroundColor(colorGris);
                        }
                        table.addCell(cellUF);

                        PdfPCell cellSP = new PdfPCell(new Phrase(sub.getDescripcion(), fontNormal));
                        cellSP.setHorizontalAlignment(Element.ALIGN_CENTER);
                        if (auxi % 2 == 0) {
                            cellSP.setBackgroundColor(colorGris);
                        }
                        table.addCell(cellSP);

                        GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
                        GrupoDato grupoDato = gdjpa.findGrupoDato(sub.getIdgrupoDato().getIdgrupoDato());
                        PdfPCell cellGD = new PdfPCell(new Phrase(grupoDato.getNomGD(), fontNormal));
                        cellGD.setHorizontalAlignment(Element.ALIGN_CENTER);
                        if (auxi % 2 == 0) {
                            cellGD.setBackgroundColor(colorGris);
                        }
                        table.addCell(cellGD);

                        PdfPCell cellAc = new PdfPCell(new Phrase("" + accion.getMovDatos(), fontNormal));
                        cellAc.setHorizontalAlignment(Element.ALIGN_CENTER);
                        if (auxi % 2 == 0) {
                            cellAc.setBackgroundColor(colorGris);
                        }
                        table.addCell(cellAc);

                        String cfp = "1";
                        if (accion.getMovDatos().equals('-')) {
                            cfp = "0";
                        }
                        PdfPCell cellCFP = new PdfPCell(new Phrase(cfp, fontNormal));
                        cellCFP.setHorizontalAlignment(Element.ALIGN_CENTER);
                        if (auxi % 2 == 0) {
                            cellCFP.setBackgroundColor(colorGris);
                        }
                        table.addCell(cellCFP);

                        PdfPCell cellSumaCFP = new PdfPCell(new Phrase(""));
                        if (auxi % 2 == 0) {
                            cellSumaCFP.setBackgroundColor(colorGris);
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
                        historico.setTamanio(proceso.getTamPF());
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

                    if (accion.getMovDatos().equals('S')) {
                        isEse = true;
                    } else {
                        if (!accion.getMovDatos().equals('-')) {
                            sumador++;
                        }
                    }
                }
                //Cuando hay mensajes de error, solo se agrega una tupla al final
                if (isEse) {
                    PdfPCell cellPF = new PdfPCell(new Phrase("", fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    cellPF = new PdfPCell(new Phrase(proceso.getNomPF(), fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    cellPF = new PdfPCell(new Phrase(proceso.getEventoDes(), fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    cellPF = new PdfPCell(new Phrase("Sistema", fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    cellPF = new PdfPCell(new Phrase("Mensajes de error", fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    cellPF = new PdfPCell(new Phrase("N/A", fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    cellPF = new PdfPCell(new Phrase("S", fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);

                    cellPF = new PdfPCell(new Phrase("1", fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    cellPF = new PdfPCell(new Phrase("", fontNormal));
                    cellPF.setHorizontalAlignment(Element.ALIGN_CENTER);
                    if (auxi % 2 == 0) {
                        cellPF.setBackgroundColor(colorGris);
                    }
                    table.addCell(cellPF);
                    
                    sumador = sumador + 1;
                }

                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell("");
                PdfPCell cellSuma = new PdfPCell(new Phrase("" + sumador, fontNormal));
                cellSuma.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellSuma);

                suma += sumador;
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
            cellSuma.setBackgroundColor(colorGris);
            table.addCell(cellSuma);

            document.add(table);

            //Fin de creación de matriz
            //Fin Resumen Medición
            //Secci�n 3: Información Detalla Proceso Funcional (Nombre PF, Desc. PF, Diag. Act., Diag. Ctx., Diag. Sec.
            document.add(new Paragraph("  "));
            document.add(new Paragraph("        3. INFORMACIÓN DETALLADA POR PROCESO FUNCIONAL", fuenteAzul));
            document.add(new Paragraph("  "));

            for (ProcesoFuncional proc : listaPF) {
                document.newPage();
                document.add(tableh);
                document.add(imgUnam);
                document.add(new Paragraph("    Nombre: " + proc.getNomPF(), fontNormal2));
                document.add(new Paragraph("    Descripción: " + proc.getDescripcion(), fontNormal2));

                //Sumatoria de MD
                document.add(new Paragraph("    Sumatoria de Movimientos de Datos del Proceso Funcional", fuenteAzul2));
                document.add(new Paragraph("  "));
                PdfPTable tableResumenPF1 = new PdfPTable(6);
                tableResumenPF1.setTotalWidth(480f);
                tableResumenPF1.setLockedWidth(true);
                tableResumenPF1.setWidths(new float[]{1, 1, 1, 1, 1, 1});

                PdfPCell cellRX1 = new PdfPCell(new Paragraph("X"));
                cellRX1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRX1.setBorderColor(colorAzul);
                cellRX1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRX1);

                PdfPCell cellRL1 = new PdfPCell(new Paragraph("R"));
                cellRL1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRL1.setBorderColor(colorAzul);
                cellRL1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRL1);

                PdfPCell cellRE1 = new PdfPCell(new Paragraph("E"));
                cellRE1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRE1.setBorderColor(colorAzul);
                cellRE1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRE1);

                PdfPCell cellRW1 = new PdfPCell(new Paragraph("W"));
                cellRW1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRW1.setBorderColor(colorAzul);
                cellRW1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRW1);

                PdfPCell cellRS1 = new PdfPCell(new Paragraph("S"));
                cellRS1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellRS1.setBorderColor(colorAzul);
                cellRS1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellRS1);

                PdfPCell cellTot1 = new PdfPCell(new Paragraph("Total"));
                cellTot1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTot1.setBorderColor(colorAzul);
                cellTot1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellTot1);

                int sumaX1 = 0, sumaR1 = 0, sumaE1 = 0, sumaW1 = 0, sumaS1 = 0, sumaTotal1 = 0;
                SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos = spjpa.findSPByIdProcesoFuncionalR(proc.getIdprocesoFuncional());

                for (SubProceso sub : subProcesos) {
                    AccionJpaController acjpa = new AccionJpaController(EntityProvider.provider());
                    Accion accion = acjpa.findAccion(sub.getIdaccion().getIdaccion());
                    if (String.format("%s", accion.getMovDatos()).equals("E")) {
                        sumaE1 = sumaE1 + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("X")) {
                        sumaX1 = sumaX1 + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("R")) {
                        sumaR1 = sumaR1 + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("W")) {
                        sumaW1 = sumaW1 + 1;
                    } else if (String.format("%s", accion.getMovDatos()).equals("S")) {
                        sumaS1 = 1;
                    }
                }
                PdfPCell cellSumX11 = new PdfPCell(new Paragraph("" + sumaX1));
                cellSumX11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumX11.setBorderColor(colorAzul);
                cellSumX11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumX11);

                PdfPCell cellSumR11 = new PdfPCell(new Paragraph("" + sumaR1));
                cellSumR11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumR11.setBorderColor(colorAzul);
                cellSumR11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumR11);

                PdfPCell cellSumE11 = new PdfPCell(new Paragraph("" + sumaE1));
                cellSumE11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumE11.setBorderColor(colorAzul);
                cellSumE11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumE11);

                PdfPCell cellSumW11 = new PdfPCell(new Paragraph("" + sumaW1));
                cellSumW11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumW11.setBorderColor(colorAzul);
                cellSumW11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumW11);

                PdfPCell cellSumS11 = new PdfPCell(new Paragraph("" + sumaS1));
                cellSumS11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumS11.setBorderColor(colorAzul);
                cellSumS11.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumS11);

                sumaTotal1 = sumaX1 + sumaR1 + sumaE1 + sumaW1 + sumaS1;
                PdfPCell cellT1 = new PdfPCell(new Paragraph("" + sumaTotal1));
                cellT1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellT1.setBorderColor(colorAzul);
                cellT1.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellT1);

                PdfPCell cellSumX10 = new PdfPCell(new Paragraph("" + df.format((double) sumaX1 / (double) sumaTotal1 * 100) + "%"));
                cellSumX10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumX10.setBorderColor(colorAzul);
                cellSumX10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumX10);

                PdfPCell cellSumR10 = new PdfPCell(new Paragraph("" + df.format((double) sumaR1 / (double) sumaTotal1 * 100) + "%"));
                cellSumR10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumR10.setBorderColor(colorAzul);
                cellSumR10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumR10);

                PdfPCell cellSumE10 = new PdfPCell(new Paragraph("" + df.format((double) sumaE1 / (double) sumaTotal1 * 100) + "%"));
                cellSumE10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumE10.setBorderColor(colorAzul);
                cellSumE10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumE10);

                PdfPCell cellSumW10 = new PdfPCell(new Paragraph("" + df.format((double) sumaW1 / (double) sumaTotal1 * 100) + "%"));
                cellSumW10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumW10.setBorderColor(colorAzul);
                cellSumW10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumW10);

                PdfPCell cellSumS10 = new PdfPCell(new Paragraph("" + df.format((double) sumaS1 / (double) sumaTotal1 * 100) + "%"));
                cellSumS10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumS10.setBorderColor(colorAzul);
                cellSumS10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumS10);

                PdfPCell cellSumT10 = new PdfPCell(new Paragraph("100.00 %"));
                cellSumT10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellSumT10.setBorderColor(colorAzul);
                cellSumT10.setBorderWidth(1.5f);
                tableResumenPF1.addCell(cellSumT10);

                document.add(tableResumenPF1);
                //Fin Sumatoria MD

                //Diagrama de Actividades
                document.add(new Paragraph("  "));
                SubProcesoJpaController spjpa3 = new SubProcesoJpaController(EntityProvider.provider());
                List<SubProceso> subProcesos3 = spjpa3.findSPByIdProcesoFuncionalR(proc.getIdprocesoFuncional());
                int posicionY = 346;
                int contSub = 1;
                for (SubProceso subP : subProcesos3) {
                    PdfPTable table1 = new PdfPTable(1);
                    table1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table1.setTotalWidth(480f);
                    table1.setLockedWidth(true);

                    Phrase phrase = new Phrase(subP.getDescripcion(), fontNormal3);
                    PdfPCell cellAct = new PdfPCell(phrase);
                    cellAct.setNoWrap(false);
                    cellAct.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellAct.setBackgroundColor(colorGris);
                    table1.addCell(cellAct);

                    document.add(table1);
                    document.add(new Paragraph("   "));

                    if (subProcesos.size() != contSub) {
                        if (contSub == 1) {
                            posicionY = posicionY - (int) table1.getTotalHeight();
                        }
                        Image imgAct = Image.getInstance(arrowAct);
                        imgAct.setAbsolutePosition(550, posicionY);
                        document.add(imgAct);
                        posicionY -= (table1.getTotalHeight() + 18);
                    }
                    contSub++;
                }
                //Fin Diagrama de Actividades

                //Diagrama de Secuencia
                double sizeLine = (25.0 * subProcesos.size()) + 20.0;
                PdfContentByte under4 = writer.getDirectContentUnder();
                under4.setColorStroke(BaseColor.BLACK);
                under4.setLineWidth(3);
                under4.moveTo(170.0, 365.0);
                under4.lineTo(170.0, 365.0 - sizeLine);
                under4.stroke();

                int posYact = 335;
                int posMD = 340;
                for (SubProceso sub : subProcesos) {
                    under4.setColorStroke(BaseColor.BLACK);
                    under4.setLineWidth(1.5);
                    under4.setFontAndSize(bf_helv, 15);
                    under4.moveTo(170.0, posYact);

                    AccionJpaController acjpa = new AccionJpaController(EntityProvider.provider());
                    Accion accion = acjpa.findAccion(sub.getIdaccion().getIdaccion());
                    if (Objects.equals(accion.getMovDatos().toString(), "X") || Objects.equals(accion.getMovDatos().toString(), "E") || Objects.equals(accion.getMovDatos().toString(), "S")) {
                        under4.lineTo(70.0, posYact);
                        under4.showTextAligned(Element.ALIGN_CENTER, accion.getMovDatos().toString(), 150, posMD, 0);
                    } else if (Objects.equals(accion.getMovDatos().toString(), "R") || Objects.equals(accion.getMovDatos().toString(), "W")) {
                        under4.lineTo(270.0, posYact);
                        under4.showTextAligned(Element.ALIGN_CENTER, accion.getMovDatos().toString(), 190, posMD, 0);
                    }
                    under4.stroke();
                    posYact -= 25;
                    posMD -= 25;
                }
                //Fin Diagrama de Secuencia
            }
            //Fin Información Detalla por Proceso Funcional

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

        String SEP = File.separator; 
        String archivo = System.getProperty("user.dir") + SEP + "results" + SEP + "matriz.pdf";
        File file = new File(archivo);
        response.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"matriz.pdf\"");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}
