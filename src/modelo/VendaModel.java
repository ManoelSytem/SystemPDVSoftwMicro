/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author IBBN
 */
public class VendaModel {

   
    
    private String NomeCliente;
    private int CodVenda;
    private int CodCliente;
    private double ValorProduto;
    private double ValorEntrada;
    private String DatadaVenda;
    private String horaDaVenda;
    private String formaPgmt;
    private double valorPedente;
    private int codusuario;
    private String DescricaoCompra;
    private String mesagem;
    private double vendatotoalmensal;
    
    public double getVendatotoalmensal() {
        return vendatotoalmensal;
    }

    public void setVendatotoalmensal(double vendatotoalmensal) {
        this.vendatotoalmensal = vendatotoalmensal;
    }
    public int getCodVenda() {
        return CodVenda;
    }

     public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }
    public String getMesagem() {
        return mesagem;
    }

    public void setMesagem(String mesagem) {
        this.mesagem = mesagem;
    }

    public void setCodVenda(int CodVenda) {
        this.CodVenda = CodVenda;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    public double getValorProduto() {
        return ValorProduto;
    }

    public void setValorProduto(double ValorProduto) {
        this.ValorProduto = ValorProduto;
    }

    public double getValorEntrada() {
        return ValorEntrada;
    }

    public void setValorEntrada(double ValorEntrada) {
        this.ValorEntrada = ValorEntrada;
    }

    public String getDatadaVenda() {
        return DatadaVenda;
    }

    public void setDatadaVenda(String DatadaVenda) {
        this.DatadaVenda = DatadaVenda;
    }

    public String getHoraDaVenda() {
        return horaDaVenda;
    }

    public void setHoraDaVenda(String horaDaVenda) {
        this.horaDaVenda = horaDaVenda;
    }

    public String getFormaPgmt() {
        return formaPgmt;
    }

    public void setFormaPgmt(String formaPgmt) {
        this.formaPgmt = formaPgmt;
    }

    public double getValorPedente() {
        return valorPedente;
    }

    public void setValorPedente(double valorPedente) {
        this.valorPedente = valorPedente;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public String getDescricaoCompra() {
        return DescricaoCompra;
    }

    public void setDescricaoCompra(String DescricaoCompra) {
        this.DescricaoCompra = DescricaoCompra;
    }
    
    
    
}
