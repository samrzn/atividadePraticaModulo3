package tripTour_console;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.PacoteDAO;
import model.Cliente;

public class consolePrincipal {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		CompraDAO compraDAO = new CompraDAO();
		Scanner input = new Scanner(System.in);
		int option;
		int option2;

		do {
			System.out.println(" === Sistema de Gerenciamento de Clientes | TripTour === \n");
			System.out.println("Informe a opção desejada:");
			System.out.println("1 - Gerenciar clientes  \t| \t 2 - Vendas \t | \t 0 - Sair");
			option = input.nextInt();
			input.nextLine();
			switch (option) {
			case 1:
				do {
					System.out.println(" ====== Gerenciamento de clientes: ====== \n");
					System.out.println("1 - Cadastrar cliente | 2 - Atualizar cadastro | 3 - Visualizar cadastros");
					System.out.println("4 - Página anterior");
					option2 = input.nextInt();
					input.nextLine();
					switch (option2) {
					case 1:
						Cliente c1 = new Cliente();
						System.out.println("Nome: ");
						c1.setNome(input.nextLine());
						System.out.println("Telefone (apenas números): ");
						c1.setTelefone(input.nextLine());
						System.out.println("E-mail: ");
						c1.setEmail(input.nextLine());
						System.out.println("CPF (apenas números): ");
						c1.setCpf(input.nextLine());
						clienteDAO.cadastrar(c1);
						System.out.println("Cadastro realizado.");
						break;
					case 2:
						Cliente c2 = new Cliente();
						System.out.println(
								"AVISO: Atualização de cadastro é permitida apenas para telefone e e-mail! \n");
						System.out.println("Informe o novo telefone: ");
						c2.setTelefone(input.nextLine());
						System.out.println("Informe o novo e-mail: ");
						c2.setEmail(input.nextLine());
						System.out.println("Informe CPF do cliente que deseja alterar os dados: ");
						c2.setCpf(input.nextLine());
						clienteDAO.atualizar(c2);
						System.out.println("Cadastro atualizado.");
						break;
					case 3:
						System.out.println("Exibindo clientes cadastrados: \n");
						for (Cliente c : clienteDAO.getClientes()) {
							System.out.println("ID Cliente: " + c.getId_cliente());
							System.out.println("Nome: " + c.getNome());
							System.out.println("Telefone: " + c.getTelefone());
							System.out.println("E-mail " + c.getEmail());
							System.out.println("CPF: " + c.getCpf() + "\n");
						}
						System.out.println("===============================================");
						break;
					default:
						System.out.println(option2 != 4 ? "Opção inválida." : "");
						break;
					}
				} while (option2 != 4);
			}
		} while (option != 0);
		input.close();
	}
}