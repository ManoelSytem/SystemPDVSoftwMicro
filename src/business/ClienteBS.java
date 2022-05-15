package business;

import dao.ClienteDAO;
import java.util.*;
import modelo.Cliente;

/**
 * Esta classe eh responsavel pela camada de negócio.
 *
 * @author Helder Aragao
 *
 */
public class ClienteBS {

    ClienteDAO ClienteDAO;

    public ClienteBS() {
        ClienteDAO = new ClienteDAO();
    }

    /*
  	 *validarDados eh responsável por fazer a validacao dos dados a serem cadastrados no sistema.
  	 *Verifica se o usu�rio preencheu todos os campos nao-nulos.
  	 *
     */
 /*
  	 *adicionar - responsavel por inserir os valores dos campos a serem cadastrados apas a validcao dos dados.
  	 *Invoca o m�todo adicionarAnaliseBacteriologica do DAO.
     */
    public void adicionarCliente(Cliente cliente) throws Exception {

        String retorno = ClienteDAO.adicionarCliente(cliente);
        cliente.setMensagem(retorno);
    }

    public Iterator ListadeClientes() throws Exception {
        return ClienteDAO.ListaClinte();
    }

    public void ExcluirCliente(Cliente Cliente) throws Exception {
        String retorno = ClienteDAO.ExcluirCliente(Cliente);
        Cliente.setMensagem(retorno);
    }

    public boolean VerificarCompraPendenteCliente(int codCliente) {
        return ClienteDAO.ObterCompraClientePorId(codCliente);
    }

}
