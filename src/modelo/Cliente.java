/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;


/**
 *
 * @author IBBN
 */

public class Cliente {
    
    private int CodCliente;
    private String Nome;
    private String Telefone;
    private String Cpf;
    private String Endereco;
    private String DatadeCadastro;
    private String Mensagem;
    public Cliente() {
       
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

   

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }


    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

  

    public String getDatadeCadastro() {
        return DatadeCadastro;
    }

    public void setDatadeCadastro(String DatadeCadastro) {
        this.DatadeCadastro = DatadeCadastro;
    }

    public void ValidaSeCompraExiste(boolean retorno)throws Exception {
        if(retorno == true){
                 throw new Exception("Existe Compras pendente para este cliente, favor excluir a Compra ou realizar o pagamento."); //To change body of generated methods, choose Tools | Templates.
        }else{
        
        }
    }
    
    
}
