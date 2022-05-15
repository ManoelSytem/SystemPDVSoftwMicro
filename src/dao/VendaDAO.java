/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelo.PagamentoModel;
import modelo.VendaModel;

/**
 *
 * @author IBBN
 */
public class VendaDAO {

    private ConexaoBD database = null;
    private PreparedStatement ps;
    private Connection con;
    private ResultSet rs;
    
    SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
    
    public VendaDAO() {
    }

    public String adicionarVenda(VendaModel NewVenda) {
    
        
        try {    //fazendo a conexao
   
            database = new ConexaoBD();
            con = database.getConexao();

            //preparando o comando de banco
            ps = con.prepareStatement("INSERT INTO MANOEL.VENDAS (CLIENTE,VALORPRODUTO,VALOENTRADA,VALORPENDENTE,DATAVENDA,HORAVENDA,FORMAPAGMTO,DESCOMPRA)"
                    + "VALUES (?,?,?,?,?,?,?,?)");
            //atribuindo valores aos parametros
            ps.setInt(1,NewVenda.getCodCliente());
            ps.setDouble(2, NewVenda.getValorProduto());
            ps.setDouble(3, NewVenda.getValorEntrada()); 
            ps.setDouble(4, NewVenda.getValorPedente());
            ps.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));  
            ps.setString(6, in.format(java.sql.Date.valueOf(java.time.LocalDate.now())));  
            ps.setString(7, NewVenda.getFormaPgmt());
            ps.setString(8, NewVenda.getDescricaoCompra());
            //executando o comando de banco
            ps.executeUpdate();
             
            ps = con.prepareStatement("SELECT max(CODVENDA) FROM MANOEL.VENDAS");
            
            rs = ps.executeQuery();
            
            ps = con.prepareStatement("INSERT INTO MANOEL.PAGAMENTO (COMPRA, VALORPEDENTE, VALORPAGO)"
                    + "VALUES (?,?,?)");
             while(rs.next())
            {
            ps.setDouble(1, rs.getInt("1"));
            }
            ps.setDouble(2, NewVenda.getValorPedente()); 
            ps.setDouble(3, NewVenda.getValorEntrada());

            ps.executeUpdate();
           
            ps.close();

        } catch (Exception e) {
            return "Nao foi possivel realizar a venda ou houve algum erro. Erro de Sistema: " + e.getMessage();
        } finally {
            database.fecharConexao();

        }

        return "Venda Cadastrada com Sucesso! Consulte em Cliente>Lista de Cliente, \n a venda cadastrada.";

    }

   public Iterator ListaVendas(String venda) throws Exception {
         ArrayList ColecaoVendas = new ArrayList();
         ColecaoVendas.clear();
        try
        {
        
            String sql = null;

            database = new ConexaoBD();
            con = database.getConexao();

            if (venda.equals("A Prazo")) {
                sql = "SELECT A.CODCLIENTE, B.CODVENDA, A.NOME, B.VALORPRODUTO, B.VALOENTRADA, B.VALORPENDENTE,  B.DATAVENDA, B.HORAVENDA, B.FORMAPAGMTO, B.DESCOMPRA\n"
                        + "FROM MANOEL.CLIENTE A\n"
                        + "INNER JOIN MANOEL.VENDAS B ON B.CLIENTE = A.CODCLIENTE AND B.VALORPENDENTE > 0 ";
            } else if (venda.equals("A Vista")) {
                sql = "SELECT B.CODVENDA, B.VALORPRODUTO, B.VALOENTRADA, B.VALORPENDENTE, B.HORAVENDA, B.FORMAPAGMTO, B.DESCOMPRA\n"
                        + "  FROM MANOEL.VENDAS B WHERE B.CLIENTE = 0";
            } else {
                sql = "SELECT B. CLIENTE, B.CODVENDA, B.VALORPRODUTO, B.VALOENTRADA,  B.VALORPENDENTE, B.DATAVENDA, B.HORAVENDA, B.FORMAPAGMTO, B.DESCOMPRA\n"
                        + "   FROM \n"
                        + "  MANOEL.VENDAS B WHERE B.CLIENTE = (SELECT CODCLIENTE FROM  MANOEL.CLIENTE WHERE NOME LIKE '%" + venda + "%') AND B.VALORPENDENTE > 0";
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

         while(rs.next())
            {
            
            VendaModel ListadeVendas = new VendaModel();
            ListadeVendas.setCodVenda(rs.getInt("CODVENDA"));
            if(venda.equals("A Prazo")){
            ListadeVendas.setCodCliente(rs.getInt("CODCLIENTE"));
            ListadeVendas.setNomeCliente(rs.getString("NOME"));
            }
            ListadeVendas.setValorProduto(rs.getDouble("VALORPRODUTO"));
            ListadeVendas.setValorEntrada(rs.getDouble("VALOENTRADA"));
            ListadeVendas.setValorPedente(rs.getDouble("VALORPENDENTE"));
            ListadeVendas.setDatadaVenda(String.valueOf(rs.getString("DATAVENDA")));
            ListadeVendas.setHoraDaVenda(rs.getString("HORAVENDA"));
            ListadeVendas.setFormaPgmt(rs.getString("FORMAPAGMTO"));
            ListadeVendas.setDescricaoCompra(rs.getString("DESCOMPRA"));
             ColecaoVendas.add(ListadeVendas);
            }
         
            rs.close();
        }
        catch(Exception e)
        {    
            throw new Exception(e.getMessage());
        }
        finally
        {
            database.fecharConexao();
        }
        
        return ColecaoVendas.iterator();
        
    }

   public double volortotalcompras(String[] Datebetween) throws Exception {
         
         double total=0;
        try
        {  
           
            database = new ConexaoBD();
            con = database.getConexao();
            
             String sql = null;
             sql= "SELECT B.VALOENTRADA FROM MANOEL.VENDAS B WHERE  B.DATAVENDA between '"+Datebetween[0]+"' and '"+Datebetween[1]+"'";
             
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            VendaModel totalVendaMensal = new VendaModel();
           while(rs.next())
            {
             total += rs.getInt("VALOENTRADA");
            }
         
            rs.close();
        }
        catch(Exception e)
        {    
            throw new Exception(e.getMessage());
        }
        finally
        {
            database.fecharConexao();
        }
        
        return total;
        
    }

   public String ExcluirVenda(VendaModel ExcludeVenda) {
         try {    //fazendo a conexao
            database = new ConexaoBD();
            con = database.getConexao();

            //preparando o comando de banco
            
            ps = con.prepareStatement("DELETE FROM MANOEL.VENDAS WHERE CODVENDA = (?)");
            //atribuindo valores aos parametros
            ps.setInt(1,ExcludeVenda.getCodVenda());

            //executando o comando de banco
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            return "Nao foi possivel adicionar um novo Cliente. Cliente ja cadastrado ou houve algum erro. Erro de Sistema: " + e.getMessage();

        } finally {
            database.fecharConexao();

        }

        return "Venda Excluida com sucesso!";

    }

   public String Vendaupdate(VendaModel Update,double novaEntrada, Double pendenteAntigo) {
        
         try {    //fazendo a conexao
               String sql = null;
              Statement statement = null;
            database = new ConexaoBD();
            con = database.getConexao();
           
            sql = "UPDATE MANOEL.VENDAS SET VALOENTRADA="+Update.getValorEntrada()+", VALORPENDENTE="+Update.getValorPedente()+", "
                    + "HORAVENDA='"+in.format(java.sql.Date.valueOf(java.time.LocalDate.now()))+"' WHERE CODVENDA="+Update.getCodVenda()+"";
            
            statement = con.createStatement();
            statement.execute(sql);
            
            ps = con.prepareStatement("INSERT INTO MANOEL.PAGAMENTO (COMPRA, VALORPEDENTE, VALORPAGO)"
                    + "VALUES (?,?,?)");
            ps.setDouble(1, Update.getCodVenda());
            ps.setDouble(2, pendenteAntigo); 
            ps.setDouble(3, novaEntrada);

            ps.executeUpdate();
            statement.close();
            
        } catch (Exception e) {
            return "Nao foi possivel adicionar um novo Cliente. Cliente ja cadastrado ou houve algum erro. Erro de Sistema: " + e.getMessage();
        } finally {
            database.fecharConexao();
        }
        return "Venda Débitada com sucesso!";
    }

   public Iterator BucarVendaMes(String[]Datebetween, String tipo) throws Exception {
         ArrayList ColecaoVendas = new ArrayList();
         ColecaoVendas.clear();
        try
        {
        
            String sql = null;

            database = new ConexaoBD();
            con = database.getConexao();
          if(tipo.equals("A Vista")){
            sql= "SELECT B.CODVENDA, B.VALORPRODUTO, B.VALOENTRADA, B.VALORPENDENTE, B.HORAVENDA, B.FORMAPAGMTO, B.DESCOMPRA\n" +
            "  FROM MANOEL.VENDAS B WHERE B.CLIENTE = 0 AND B.DATAVENDA between '"+Datebetween[0]+"' and '"+Datebetween[1]+"'";}else{
            sql = "SELECT A.CODCLIENTE, B.CODVENDA, A.NOME, B.VALORPRODUTO, B.VALOENTRADA, B.VALORPENDENTE, B.HORAVENDA, B.FORMAPAGMTO, B.DESCOMPRA\n" +
                  "FROM MANOEL.CLIENTE A\n" +
                  "INNER JOIN MANOEL.VENDAS B ON B.CLIENTE = A.CODCLIENTE AND B.VALORPENDENTE > 0 AND B.DATAVENDA between '"+Datebetween[0]+"' and '"+Datebetween[1]+"'";;
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
         while(rs.next())
            {
            
            VendaModel ListadeVendas = new VendaModel();
            ListadeVendas.setCodVenda(rs.getInt("CODVENDA"));
            if(tipo.equals("A Prazo")){
            ListadeVendas.setCodCliente(rs.getInt("CODCLIENTE"));
            ListadeVendas.setNomeCliente(rs.getString("NOME"));
            }
            ListadeVendas.setValorProduto(rs.getDouble("VALORPRODUTO"));
            ListadeVendas.setValorEntrada(rs.getDouble("VALOENTRADA"));
            ListadeVendas.setValorPedente(rs.getDouble("VALORPENDENTE"));
            ListadeVendas.setHoraDaVenda(rs.getString("HORAVENDA"));
            ListadeVendas.setFormaPgmt(rs.getString("FORMAPAGMTO"));
            ListadeVendas.setDescricaoCompra(rs.getString("DESCOMPRA"));
             ColecaoVendas.add(ListadeVendas);
            }
         
            rs.close();
        }
        catch(Exception e)
        {    
            throw new Exception(e.getMessage());
        }
        finally
        {
            database.fecharConexao();
        }
        
        return ColecaoVendas.iterator();
        
    }
   
   public double volortotalpendente(String[] Databetween) throws Exception {
         
         double total=0;
        try
        {  
            
           
            String sql = null;

            database = new ConexaoBD();
            con = database.getConexao();
            
            sql= "SELECT B.VALORPENDENTE FROM MANOEL.VENDAS B  WHERE  B.DATAVENDA between '"+Databetween[0]+"' and '"+Databetween[1]+"' AND B.VALORPENDENTE > 0";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            VendaModel totalVendaMensal = new VendaModel();
           while(rs.next())
            {
             total += rs.getInt("VALORPENDENTE");
            }
         
            rs.close();
        }
        catch(Exception e)
        {    
            throw new Exception(e.getMessage());
        }
        finally
        {
            database.fecharConexao();
        }
        
        return total;
        
    }
   
    public  String AtualizarDataPrototypo(String data, int codVenda) {
       try {    //fazendo a conexao
           
            String sql = null;
            Statement statement = null;
            database = new ConexaoBD();
            con = database.getConexao();
           
            sql = "UPDATE MANOEL.VENDAS SET HORAVENDA='"+data+"' WHERE CODVENDA="+codVenda+"";
            
            statement = con.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (Exception e) {
           
        } finally {
            database.fecharConexao();
        }
       return "Atualizado..."+codVenda;
    }

    public Iterator VendasAll() throws Exception {
        ArrayList ColecaoVendas = new ArrayList();
         ColecaoVendas.clear();
        try
        {
        
            String sql = null;
            String sqlCreateTable = "";

            database = new ConexaoBD();
            con = database.getConexao();

            sqlCreateTable = "CREATE TABLE MANOEL.PAGAMENTO\n"
                    + "(\n"
                    + "Codpgto INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n"
                    + "Compra INTEGER NOT NULL,\n"
                    + "ValorPedente DOUBLE,\n"
                    + "ValorPago DOUBLE,\n"
                    + "CONSTRAINT Codpgto PRIMARY KEY (Codpgto)\n"
                    + ")";
            
            sql = "SELECT CODVENDA, HORAVENDA FROM MANOEL.VENDAS";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           

         while(rs.next())
            {
            
            VendaModel ListadeVendas = new VendaModel();
            ListadeVendas.setCodVenda(rs.getInt("CODVENDA"));
            ListadeVendas.setHoraDaVenda(rs.getString("HORAVENDA"));
            ColecaoVendas.add(ListadeVendas);
            }
              ps = con.prepareStatement(sqlCreateTable);
               ps.executeUpdate();
            rs.close();
        }
        catch(Exception e)
        {    
            throw new Exception(e.getMessage());
        }
        finally
        {
            database.fecharConexao();
        }
        
        return ColecaoVendas.iterator();
        
    }

    public Iterator ObterListaDePagamentoPorCodCliente(int codCliente) throws Exception {
       ArrayList ColecaoVendas = new ArrayList();
         ColecaoVendas.clear();
        try
        {
        
            String sql = null;

            database = new ConexaoBD();
            con = database.getConexao();

         
                sql = "SELECT VEND.DESCOMPRA, PAG.COMPRA,VEND.VALORPRODUTO, PAG.VALORPEDENTE,PAG.VALORPAGO, VEND.DATAVENDA, VEND.HORAVENDA FROM MANOEL.PAGAMENTO AS PAG\n" +
"JOIN MANOEL.VENDAS AS VEND ON VEND.CODVENDA = PAG.COMPRA\n" +
"WHERE VEND.CLIENTE ="+codCliente;
           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

         while(rs.next())
            {
            PagamentoModel HistoricoPagamentoModel = new PagamentoModel();
            HistoricoPagamentoModel.setDescCompra(rs.getString("DESCOMPRA"));
            HistoricoPagamentoModel.setCodigoCompra(rs.getInt("COMPRA"));
            HistoricoPagamentoModel.setValorProduto(rs.getDouble("VALORPRODUTO"));
            HistoricoPagamentoModel.setValorPendente(rs.getDouble("VALORPEDENTE"));
            HistoricoPagamentoModel.setValorPago(rs.getDouble("VALORPAGO"));
            HistoricoPagamentoModel.setDataVenda(rs.getString("DATAVENDA"));
            HistoricoPagamentoModel.setUltimoPagamento(rs.getString("HORAVENDA"));
            ColecaoVendas.add(HistoricoPagamentoModel);
            }
         
            rs.close();
        }
        catch(Exception e)
        {    
            throw new Exception(e.getMessage());
        }
        finally
        {
            database.fecharConexao();
        }
        
        return ColecaoVendas.iterator();
    }
   
   
}
