// Natasha da Silva Alves - Natasha.Alves@recode.org.br
import br.com.agenciaViagens.model.Cliente;
import br.com.agenciaViagens.model.Destino;
import br.com.agenciaViagens.dao.ClienteDAO;
import br.com.agenciaViagens.dao.DestinoDAO;



public class TesteAgenciaViagens {
	
	public static void main(String args[]){
		
		//----------------------------------------------------------------------------------------
		//Cliente no banco de dados
		 
		 ClienteDAO clienteDAO = new ClienteDAO();
		 
		
		 //Cria um cliente e salva no banco de dados
		 Cliente cliente = new Cliente();
		 cliente.setNome("Edivaldo");
		 cliente.setCpf("13351690762");
		 cliente.setEmail("valdo@gmail.com");
		 cliente.setTelefone("21123456789");
		
		 clienteDAO.saveCliente(cliente);
		 
		 
		 
		 //Atualiza o registro do cliente com id = 1 do objeto cliente1
		 Cliente cliente1 = new Cliente();
		 cliente1.setIdCliente(1);
		 cliente1.setNome("Crisvianno");
		 cliente1.setCpf("14851620768");
		 cliente1.setEmail("cris@gmail.com");
		 cliente1.setTelefone("21123006719");
		 
		 clienteDAO.updateCliente(cliente1);
		 
		 
		 
		 
		 //Deleta o registro do cliente com o id = 1
		 Cliente client = new Cliente();
		 client.setIdCliente(1);
		 clienteDAO.deleteCliente();
		 
	
		 
		 
		 //Lista todos os clientes do banco de dados
		 for(Cliente clientes : clienteDAO.consultaCliente()){
		     System.out.println("Nome: " + clientes.getNome());
		 }
		 
		 
		 
		//----------------------------------------------------------------------------------------
		//Destino no banco de dados
		 
		 DestinoDAO destinoDAO = new DestinoDAO();
		 
			
		 //Cria um destino e salva no banco de dados
		 Destino destino = new Destino();
		 destino.setOrigem("Maranhão");
		 destino.setDestino("Bahia");
		 destino.setDataIda("28/02/2022");
		 destino.setDataVolta("10/03/2022");
		 destino.setFormaDePagamento("Pix");
		 destinoDAO.saveDestino(destino);
		 
		 
		 //Atualiza o registro do destino com id = 1 do objeto destino1
		 Destino destino1 = new Destino();
		 destino1.setIdDestino(1);
		 destino1.setOrigem("Acre");
		 destino1.setDestino("Rio de Janeiro");
		 destino1.setDataIda("26/02/2022");
		 destino.setDataVolta("16/03/2022");
		 destino.setFormaDePagamento("Cartão de crédito");
		 destinoDAO.updateDestino(destino1);
		 
		 
		 //Deleta o registro do destino com o id = 1
		 //destinoDAO.deleteDestino(1);
		 Destino destin = new Destino();
		 destin.setIdDestino(1);
		 destinoDAO.deleteDestino();
		 
		 
		 //Lista todos os destinos do banco de dados
		 for(Destino destinos : destinoDAO.consultaDestino()){
		     System.out.println("Origem: " + destinos.getOrigem());
		 }
		 }

}
