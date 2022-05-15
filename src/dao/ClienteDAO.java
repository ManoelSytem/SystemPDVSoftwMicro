

package dao;


import database.*;
import java.util.*;
import java.sql.*;


import modelo.Cliente;
 
public class ClienteDAO {
    
   private ConexaoBD database = null;
   private PreparedStatement ps;
   private Connection con;
   private ResultSet rs;
    
    
    public ClienteDAO()
    {  }
    
    /**
   * M�todo para adicionar os dados de ponto de coleta.
   *
   */
    public String adicionarCliente(Cliente cliente) throws Exception
    {
  
        try
        {    //fazendo a conexao
             database = new ConexaoBD();
             con = database.getConexao();
             
             //preparando o comando de banco
             ps = con.prepareStatement("insert into MANOEL.CLIENTE (NOME, ENDERECO,TELEFONE, CPF,DATACADASTRO) values (?,?,?,?,?)");
             //atribuindo valores aos parametros
             ps.setString(1,cliente.getNome());
             ps.setString(2,cliente.getEndereco());
             ps.setString(3,cliente.getTelefone());
             ps.setString(4,cliente.getCpf());
             ps.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
             
            //executando o comando de banco
             ps.executeUpdate();
             ps.close();
           
                
        }
        catch(Exception e)
        {    
          return "Nao foi possivel adicionar um novo Cliente. Cliente ja cadastrado ou houve algum erro. Erro de Sistema: " + e.getMessage();
        
        }
        finally
         {
            database.fecharConexao();
           
         }     
       
        return  "Cliente Cadastrado com sucesso ! Consulte na lista de Clientes";        
      
       } 
    
     public Iterator ListaClinte() throws Exception
    {
        ArrayList ColecaoCliente = new ArrayList();
        ColecaoCliente.clear();
        try
        {
        
            String sql = null;

            database = new ConexaoBD();
            con = database.getConexao();
        
            
            sql = "SELECT * FROM MANOEL.CLIENTE" ;
            
            ps = con.prepareStatement(sql);
           
            rs = ps.executeQuery();
         while(rs.next())
            {
            Cliente ListaCliente = new Cliente();
            ListaCliente.setCodCliente(rs.getInt("CodCliente"));
            ListaCliente.setNome(rs.getString("Nome"));
            ListaCliente.setCpf(rs.getString("Cpf"));
            ListaCliente.setEndereco(rs.getString("Endereco"));
            ListaCliente.setTelefone(rs.getString("Telefone"));
            ListaCliente.setDatadeCadastro(rs.getString("DataCadastro"));
            ColecaoCliente.add(ListaCliente);
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
        
        return ColecaoCliente.iterator();
        
    }

    public String ExcluirCliente(Cliente Cliente) {
         try {    //fazendo a conexao
            database = new ConexaoBD();
            con = database.getConexao();

            //preparando o comando de banco
            ps = con.prepareStatement("DELETE FROM MANOEL.CLIENTE WHERE CODCLIENTE = (?)");
            //atribuindo valores aos parametros
            ps.setInt(1,Cliente.getCodCliente());

            //executando o comando de banco
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            return "Nao foi possivel adicionar um novo Cliente. Cliente ja cadastrado ou houve algum erro. Erro de Sistema: " + e.getMessage();

        } finally {
            database.fecharConexao();

        }

        return "Cliente Excluido com sucesso!";

    }

    public boolean ObterCompraClientePorId(int codCliente) {
        try {    //fazendo a conexao
             int retorno = 0;
            database = new ConexaoBD();
            con = database.getConexao();
            String sql = null;

            //preparando o comando de banco
            sql = "SELECT * FROM MANOEL.VENDAS AS V\n"
                    + "WHERE V.CLIENTE = " + codCliente + " AND V.VALORPENDENTE > 0";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             while(rs.next())
            {
                retorno +=1;
            }
            if (retorno > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;

        } finally {
            database.fecharConexao();
        }

    }
       
    }
 



