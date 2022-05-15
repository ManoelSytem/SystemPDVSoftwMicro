/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import business.VendaBS;
import dao.VendaDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.VendaModel;

/**
 *
 * @author IBBN
 */
public class Prototypos {
     VendaDAO vendaDAO;

    public  String AtualizaHoraParaPortugues(String data, int codVenda) {
        return vendaDAO.AtualizarDataPrototypo(data,codVenda);
    }

    public Prototypos() {
        vendaDAO  = new VendaDAO();
    }
    
    public static String ConvertParseStringDate(String date) {
        
        String dia = null, mes = null, ano = null;
        if (date.length() == 28) {
            dia = date.substring(8, 10);
            mes = date.substring(4, 7);
            ano = date.substring(24, 28);
        } else {
            dia = date.substring(8, 10);
            mes = date.substring(4, 7);
            ano = date.substring(25, 29);
        }
        if (mes.equals("Jan")) {
            mes = "01";
        }
        if (mes.equals("Feb")) {
            mes = "02";
        }
        if (mes.equals("Mar")) {
            mes = "03";
        }
        if (mes.equals("Apr")) {
            mes = "04";
        }
        if (mes.equals("May")) {
            mes = "05";
        }
        if (mes.equals("Jun")) {
           mes =  "06";
        }
        if (mes.equals("Jul")) {
            mes =  "07";
        }
        if (mes.equals("Aug")) {
            mes = "08";
        }
        if (mes.equals("Sep")) {
            mes = "09";
        }
        if (mes.equals("Oct")) {
            mes = "10";
        }
        if (mes.equals("Nov")) {
            mes = "11";
        }
        if (mes.equals("Dec")) {
            mes = "12";
        }

      return  dia + "/" + mes + "/" + ano;
    }
     
     public static long ObterNumerosDeDiasEntreDatas(String Date){
        
         Date date = new Date();
         SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
         Date d1 = null;
        try {
            d1 = formatador.parse(Date);
          
        } catch (ParseException ex) {
            Logger.getLogger(Prototypos.class.getName()).log(Level.SEVERE, null, ex);
        }
           long dias = (date.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
         
        
       return dias;
    }

    public String  MigracaoDataHoraVenda(VendaBS vendaBSMigracao, Iterator itVendasMig) throws ParseException {
        String retur = null;
           for (Iterator iterator = itVendasMig; iterator.hasNext();) {
                VendaModel nextMig = (VendaModel)  iterator.next();
                
             String Date = Prototypos.ConvertParseStringDate(nextMig.getHoraDaVenda());
             retur = AtualizaHoraParaPortugues(Date, nextMig.getCodVenda());
           
            } 
             return  retur;
    }
}
