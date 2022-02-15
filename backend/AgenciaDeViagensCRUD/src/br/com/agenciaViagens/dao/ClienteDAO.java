// Natasha da Silva Alves - Natasha.Alves@recode.org.br
package br.com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.agenciaViagens.conexaoBD.ConexaoBD;
import br.com.agenciaViagens.model.Cliente;



public class ClienteDAO {
	private int idCliente;
	
	public void saveCliente(Cliente cliente){
		
		System.out.println("Digite os seguintes dados: nome, CPF, e-mail e telefone: ");
		
		 //Adiciona os parâmetros no banco de dados através dos ? no insert
		 String sql = "INSERT INTO Cliente(idCliente,nome,cpf,email,telefone)" + " VALUES(?,?,?,?,?)";
		 
		 Connection conexao = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conexão com o banco de dados
		 conexao = ConexaoBD.createConnectionBD();
		 
		 //Cria um PreparedStatment
		 pstm = conexao.prepareStatement(sql);
		 
		 pstm.setInt(1, cliente.getIdCliente());
		 
		 //Adiciona o valor do primeiro parâmetro do insert
		 pstm.setString(2, cliente.getNome());
		 
		 //Adicionar o valor do segundo parâmetro do insert
		 pstm.setString(3, cliente.getCpf());
		 
		 //Adiciona o valor do terceiro parâmetro do insert
		 pstm.setString(4, cliente.getEmail());
		 
		//Adiciona o valor do quarto parâmetro do insert
		 pstm.setNString(5, cliente.getTelefone());
		 
		 //Executa a sql para inserir os dados no banco de dados
		 pstm.execute();
		 
		 System.out.println("Cadastro do cliente realizado com sucesso! ");
		 
		 //Exceções
		 } catch (Exception ex) {
			 System.out.println("Erro! Não foi possível realizar o cadastro.");
		    ex.printStackTrace();
		 }finally{
		 
		 //Fecha as conexões
		 try{
		 if(pstm != null){
		    pstm.close();
		 }
		 
		 if(conexao != null){
		    conexao.close();
		 }
		 
		 }catch(Exception ex){
		    ex.printStackTrace();
		 }
		 }
		 }
	
	
	
	
	public void updateCliente(Cliente cliente){
		
		
		//Atualiza os parâmetros no banco de dados através dos ? no update usando o idCliente
		 String sql = "UPDATE Cliente SET idCliente = ?, nome = ?, cpf = ?, email = ?, telefone = ?" + " WHERE idCliente = ?";
		 
		 Connection conexao = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conexão com o banco
		  conexao = ConexaoBD.createConnectionBD();
		 
		 //Cria um PreparedStatment
		 pstm = conexao.prepareStatement(sql);
		 
		 //Adiciona o valor do primeiro parâmetro do update
		 pstm.setString(1, cliente.getNome());
		 
		 //Adicionar o valor do segundo parâmetro do update
		 pstm.setString(2, cliente.getCpf());
		 
		 //Adiciona o valor do terceiro parâmetro do update
		 pstm.setString(3, cliente.getEmail());
		 
		//Adiciona o valor do quarto parâmetro do update
		 pstm.setString(4, cliente.getTelefone());
		 
		 pstm.setInt(5, cliente.getIdCliente());
		 
		 //Executa a sql para inserção dos dados
		 pstm.execute();
		 
		 //Exceções
		 } catch (Exception e) {
		     e.printStackTrace();
		 }finally{
		 
		 //Fecha as conexões
		 try{
		 if(pstm != null){
		    pstm.close();
		 }
		 
		 if(conexao != null){
		 conexao.close();
		 }
		 
		 }catch(Exception e){
		    e.printStackTrace();
		 }
		 }
		 }

	
	
	
	public void deleteCliente(){
		 
		
		//Deleta o cliente através do idCliente
		 String sql = "DELETE FROM Cliente WHERE idCliente = ?";
		 
		 Connection conexao = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conexão com o banco de dados	 
		 conexao = ConexaoBD.createConnectionBD();
		 
		 //Cria um PreparedStatment	 
		 pstm = conexao.prepareStatement(sql);
			 
		 pstm.setInt(1, idCliente);
		 
		 pstm.execute();
		 //Exceções
		 } catch (Exception e) {
		      e.printStackTrace();
		 }finally{
		 
		 try{
		 if(pstm != null){
		    pstm.close();
		 }
		 
		 if(conexao != null){
		    conexao.close();
		 }
		 
		 }catch(Exception e){
		    e.printStackTrace();
		 }
		 }
		 }
	
	
	
	public List<Cliente> consultaCliente(){
		 
		 //Recupera todos os registros da tabela Cliente
		 String sql = "SELECT * FROM Cliente";
		 
		 List<Cliente> clientes = new ArrayList<Cliente>();
		 
		 Connection conexao = null;
		 PreparedStatement pstm = null;
		 //Classe que vai recuperar os dados do banco de dados
		 ResultSet rsetselect = null;
		 
		 try {
		 conexao = ConexaoBD.createConnectionBD();
			 
		 pstm = conexao.prepareStatement(sql);
		 
		 rsetselect = pstm.executeQuery();
		 
		 //Enquanto tiver dados no banco de dados faça:
		 while(rsetselect.next()){
		 
		 Cliente cliente = new Cliente();
		 
		 //Recupera o id no banco e atribui ele ao objeto idCliente
		 cliente.setIdCliente(rsetselect.getInt("idCliente"));
		 
		 //Recupera o nome no banco e atribui ele ao objeto nome
		 cliente.setNome(rsetselect.getString("nome"));
		 
		 //Recupera o CPF no banco e atribui ele ao objeto cpf
		 cliente.setCpf(rsetselect.getString("cpf"));
		 
		 //Recupera o email no banco e atribui ele ao objeto email
		 cliente.setEmail(rsetselect.getString("email"));
		 
		 cliente.setTelefone(rsetselect.getString("telefone"));
		 
		 //Adiciona o cliente encontardo à lista de clientes
		 clientes.add(cliente);
		 }
		 } catch (Exception e) {
		     e.printStackTrace();
		 }finally{
		 
		 try{
		 if(rsetselect != null){
		    rsetselect.close();
		 }
		 
		 if(pstm != null){
		    pstm.close();
		 }
		 
		 if(conexao != null){
		    conexao.close();
		 }
		 
		 }catch(Exception e){
		    e.printStackTrace();
		 }
		 }
		 
		 return clientes;
		 }
	
}
