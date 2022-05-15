/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dao.ClienteDAO;
import dao.VendaDAO;
import java.util.Iterator;
import modelo.VendaModel;

/**
 *
 * @author IBBN
 */
public class VendaBS {

    
       
     VendaDAO vendaDAO;
    
    public VendaBS()
    {
        vendaDAO  = new VendaDAO();
    }
    
   
    public void CadastrarVenda(VendaModel NewVenda) throws Exception {
        String retorno = vendaDAO.adicionarVenda(NewVenda);
        NewVenda.setMesagem(retorno);
    }

    public Iterator ListaVendas(String venda) throws Exception {
        return vendaDAO.ListaVendas(venda);
    }

    public double vendaMensal(String[] DataPeriodo) throws Exception {
        return vendaDAO.volortotalcompras(DataPeriodo);
    }
    
    public double totalpendente(String[] DataPeriodo) throws Exception{
     return vendaDAO.volortotalpendente(DataPeriodo);
    }

    public void Excluirvenda(VendaModel ExcludeVenda) throws Exception {
        String retorno = vendaDAO.ExcluirVenda(ExcludeVenda);
        ExcludeVenda.setMesagem(retorno);
    }

    public void vendaupdate(VendaModel NewVenda, double novaEntrada, Double pendenteAntigo) {
        String retorno = vendaDAO.Vendaupdate(NewVenda,novaEntrada,pendenteAntigo);
        NewVenda.setMesagem(retorno);
    }

    public Iterator BuscaVendaMes(String[] mes, String venda) throws Exception {
        return vendaDAO.BucarVendaMes(mes,venda);
    }

    public Iterator  ObterVendas() throws Exception{
        return vendaDAO.VendasAll();
    }
    public static boolean VerificaClienteAtrasado(Long dias) {
        if (dias >= 45) {
            return true;
        } else {
            return false;
        }
    }

    public Iterator ObterHistoricoPagamentoCliente(int codCliente) throws Exception {
      return vendaDAO.ObterListaDePagamentoPorCodCliente(codCliente);
    }
}