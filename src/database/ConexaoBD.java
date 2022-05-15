package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



public class ConexaoBD implements IDatabase {

public static Connection con;
 

   public void carregarDriver(){
    try{   
       
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
       
   }
        catch ( ClassNotFoundException cnfe ) {
		System.out.println( "Driver JDBC n�o encontrado : " +
							   cnfe.getMessage() );
	}
    
		
		
   }
        
   public Connection getConexao(){
   
	
	try{
	/* Instanciando a classe do driver atrav�s do seu nome */
            //if (con==null)
             con = DriverManager.getConnection("jdbc:derby:CanalModa", "manoel","si");
             return  con;
                
	} catch(ClassCastException e){
        System.out.println( "Erro na conex�o ao Bando de Dados eeeeeeeeee: " +
							           e.getMessage() );
        }
	  catch ( SQLException sqle ) {
		System.out.println( "Erro na conex�o ao Bando de Dados 222222 : " +
							            sqle.getMessage() );
	}
	    return null;
	}
	
	public void fecharConexao(){
            
          try {
                    con.close();
	
	   }
	    catch ( SQLException sqle ) {
		System.out.println( "Erro na conex�o ao Bando de Dados : " +
							            sqle.getMessage() );
	    }
            
            
	
		
	}	
		
		
	
		
	
   
}
