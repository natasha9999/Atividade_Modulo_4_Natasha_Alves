// Natasha da Silva Alves - Natasha.Alves@recode.org.br
package br.com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.agenciaViagens.conexaoBD.ConexaoBD;
import br.com.agenciaViagens.model.Destino;



public class DestinoDAO {
	private int idDestino;
	
	
	public void saveDestino(Destino destino){
		 
		 //Adiciona os parâmetros no banco de dados através dos ? no insert
		 String sql = "INSERT INTO Destino(idDestino,origem,destino,dataIda,dataVolta,formaDePagamento)" + " VALUES(?,?,?,?,?,?)";
		 
		 Connection conexao = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conexão com o banco de dados
		 conexao = ConexaoBD.createConnectionBD();
		 
		 //Cria um PreparedStatment
		 pstm = conexao.prepareStatement(sql);
		 
		 //Adiciona o valor do primeiro parâmetro do insert
		 pstm.setInt(1, destino.getIdDestino());
		 
		 //Adiciona o valor do segundo parâmetro do insert
		 pstm.setString(2, destino.getOrigem());
		 
		 //Adicionar o valor do terceiro parâmetro do insert
		 pstm.setString(3, destino.getDestino());
		 
		 //Adiciona o valor do quarto parâmetro do insert
		 pstm.setString(4, destino.getDataIda());
		 
		//Adiciona o valor do quinto parâmetro do insert
		 pstm.setNString(5, destino.getDataVolta());
		 
		//Adiciona o valor do sexto parâmetro do insert
		 pstm.setNString(6, destino.getFormaDePagamento());
		 
		 //Executa a sql para inserir os dados no banco de dados
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
	
	
	
	
	public void updateDestino(Destino destino){
		
		//Atualiza os parâmetros no banco de dados através dos ? no update usando o idDestino
		 String sql = "UPDATE Destino SET idDestino = ?, origem = ?, destino = ?, dataIda = ?, dataVolta =?, formaDePagamento = ?" + " WHERE idDestino = ?";
		 
		 Connection conexao = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conexão com o banco
		  conexao = ConexaoBD.createConnectionBD();
		 
		 //Cria um PreparedStatment
		 pstm = conexao.prepareStatement(sql);
		 
		 //Adiciona o valor do primeiro parâmetro do update
		 pstm.setString(1, destino.getOrigem());
		 
		 //Adicionar o valor do segundo parâmetro do update
		 pstm.setString(2, destino.getDestino());
		 
		 //Adiciona o valor do terceiro parâmetro do update
		 pstm.setString(3, destino.getDataIda());
		 
		//Adiciona o valor do quarto parâmetro do update
		 pstm.setString(4, destino.getDataVolta());
		 
		//Adiciona o valor do quinto parâmetro do update
		 pstm.setString(4, destino.getFormaDePagamento());
		 
		 pstm.setInt(5, destino.getIdDestino());
		 
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

	
	
	
	public void deleteDestino(){
		 
		//Deleta o destino através do idDestino
		 String sql = "DELETE FROM Destino WHERE idDestino = ?";
		 
		 Connection conexao = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conexão com o banco de dados	 
		 conexao = ConexaoBD.createConnectionBD();
		 
		 //Cria um PreparedStatment	 
		 pstm = conexao.prepareStatement(sql);
			 
		 pstm.setInt(1, idDestino);
		 
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
	
	
	
	public List<Destino> consultaDestino(){
		 
		 //Recupera todos os registros da tabela Destino
		 String sql = "SELECT * FROM Destino";
		 
		 List<Destino> destinos = new ArrayList<Destino>();
		 
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
		 
		 Destino destino = new Destino();
		 
		 //Recupera o id do banco e atribui ele ao objeto idDestino
		 destino.setIdDestino(rsetselect.getInt("idDestino"));
		 
		 //Recupera a origem do banco e atribui ele ao objeto origem
		 destino.setOrigem(rsetselect.getString("origem"));
		 
		 //Recupera o destino do banco e atribui ele ao objeto destino
		 destino.setDestino(rsetselect.getString("destino"));
		 
		 //Recupera o dataIda do banco e atribui ele ao objeto dataIda
		 destino.setDataIda(rsetselect.getString("dataIda"));
		 
		 destino.setDataVolta(rsetselect.getString("dataVolta"));
		 
		 //Adiciona o destino encontrado à lista de destinos
		 destinos.add(destino);
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
		 
		 return destinos;
		 }
		

}
