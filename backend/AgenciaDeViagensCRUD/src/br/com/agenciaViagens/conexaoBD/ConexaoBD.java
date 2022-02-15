// Natasha da Silva Alves - Natasha.Alves@recode.org.br
package br.com.agenciaViagens.conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoBD {
	
	 //Nome do usu�rio do mysql
	   private static String USERNAME = "root";
	 
	   //Senha do mysql
	   private static String PASSWORD = "mysql";
	 
	   //Dados de caminho, porta e nome da base de dados que ser� feita a conex�o
	   private static String DATABASE_URL = "jdbc:mysql://localhost:3306/AgenciaDeViagens";
	   
	   
	   public static Connection createConnectionBD() throws Exception{
		   
		      //Faz com que a classe seja carregada pela Java Virtual Machine
		      Class.forName("com.mysql.jdbc.Driver"); 
		 
		      //Cria a conex�o com o banco de dados
		      Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		      return conexao;
		   }
	   
	   
	   public static void main(String[] args) throws Exception{
		   
		      //Recupera a conex�o com o banco de dados
		      Connection conexao = createConnectionBD();
		 
		      //Testa se a conex�o � nula
		      if(conexao != null){
		         System.out.println("Conex�o com o banco de dados efetuada com sucesso!" + conexao);
		         conexao.close();
		      }else {
		    	  System.out.println("Erro. N�o foi poss�vel conectar ao banco de dados!");
		      }
		 
		   }
	   

	

}
