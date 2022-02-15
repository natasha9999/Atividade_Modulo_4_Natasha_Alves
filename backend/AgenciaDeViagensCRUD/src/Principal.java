// Natasha da Silva Alves - Natasha.Alves@recode.org.br
import java.util.List;
import java.util.Scanner;

import br.com.agenciaViagens.model.Cliente;
import br.com.agenciaViagens.model.Destino;
import br.com.agenciaViagens.dao.*;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteDAO cliente = new ClienteDAO();
		DestinoDAO destino = new DestinoDAO();
		
		Scanner entradaDeDados = new Scanner(System.in);
		
		int opcaoMenu;
		
		do {
			
			opcaoMenu = 0;
			System.out.println("-----------------------------------------------");
			System.out.println("|               Seja Bem Vindo(a)!            |");
			System.out.println("|              O que deseja fazer?            |");
			System.out.println("|      Para cadastrar um cliente, digite 1    |");
			System.out.println("|     Para cadastrar um destino, digite 2     |");
			System.out.println("|     Para consultar um cliente, digite 3     |");
			System.out.println("|      Para consultar um destino, digite 4    |");
			System.out.println("|  Para atualizar dados de cliente, digite 5  |");
			System.out.println("|  Para atualizar dados de destino, digite 6  |");
			System.out.println("|   Para deletar dados de cliente, digite 7   |");
			System.out.println("|   Para deletar dados de destino, digite 8   |");
			System.out.println("|              Para sair, digite 9            |");
			System.out.println("-----------------------------------------------");
			System.out.println(" ");
			opcaoMenu = entradaDeDados.nextInt();
			System.out.println(" ");
			
		
		
			switch(opcaoMenu) {
			case 1:
				cliente.saveCliente(null);
				break;
			case 2:
				destino.saveDestino(null);
				break;
			case 3:
				cliente.consultaCliente();
				break;
			case 4:
				destino.consultaDestino();
				break;
			case 5:
				cliente.updateCliente(null);
				break;
			case 6:
				destino.updateDestino(null);
				break;	
			case 7:
				cliente.deleteCliente();
				break;
			case 8:
				destino.deleteDestino();
				break;
			case 9:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Número incorreto!");
				break;
			}
			}while(opcaoMenu != 9);
		
		    entradaDeDados.close();
		}
	
	
	}


