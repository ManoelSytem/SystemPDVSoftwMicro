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
public class PagamentoModel {
    
    private String DescCompra;
    private int CodigoCompra;
    private double ValorProduto;

    public double getValorProduto() {
        return ValorProduto;
    }

    public void setValorProduto(double ValorProduto) {
        this.ValorProduto = ValorProduto;
    }
    private double ValorPendente;
    private double ValorPago;
    private String DataVenda;
    private String UltimoPagamento;

    public PagamentoModel(){}
    
    public String getDescCompra() {
        return DescCompra;
    }

    public void setDescCompra(String DescCompra) {
        this.DescCompra = DescCompra;
    }

    public int getCodigoCompra() {
        return CodigoCompra;
    }

    public void setCodigoCompra(int CodigoCompra) {
        this.CodigoCompra = CodigoCompra;
    }

    public double getValorPendente() {
        return ValorPendente;
    }

    public void setValorPendente(double ValorPendente) {
        this.ValorPendente = ValorPendente;
    }

    public double getValorPago() {
        return ValorPago;
    }

    public void setValorPago(double ValorPago) {
        this.ValorPago = ValorPago;
    }

    public String getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(String DataVenda) {
        this.DataVenda = DataVenda;
    }

    public String getUltimoPagamento() {
        return UltimoPagamento;
    }

    public void setUltimoPagamento(String UltimoPagamento) {
        this.UltimoPagamento = UltimoPagamento;
    }
    
   
}
