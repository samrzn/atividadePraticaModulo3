package tripTour_console;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.PacoteDAO;
import model.Cliente;
import model.Compra;
import model.Pacote;

public class consolePrincipal {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		CompraDAO compraDAO = new CompraDAO();
		Scanner input = new Scanner(System.in);
		int option;
		int option2;
		int option3;
		int option3_1;

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
						System.out.println(" =============================================== ");
						break;
					default:
						System.out.println(option2 != 4 ? "Opção inválida." : "");
						break;
					}
				} while (option2 != 4);
				break;
			case 2:
				do {
					System.out.println(" ====== Gerenciamento de vendas: ====== \n");
					System.out.println("1 - Nova venda | 2 - Cancelar venda | 3 - Visualizar vendas");
					System.out.println("4 - Página anterior");
					option3 = input.nextInt();
					input.nextLine();
					switch (option3) {
					case 1:
						System.out.println("Exibindo pacotes disponíveis: \n");
						for (Pacote p : pacoteDAO.getPacote()) {
							System.out.println("ID Pacote: " + p.getId_pacote());
							System.out.println("Destino: " + p.getDestino());
							System.out.println("Valor: " + p.getValor());
							System.out.println("Data viagem: " + p.getData_viagem() + "\n");
						}
						do {
							System.out.println("AVISO: Antes de iniciar o registro da venda, certifique-se");
							System.out.println("de possuir o ID do Cliente em mãos. Caso não tenha, selecione");
							System.out.println("a opção 'número 2' abaixo para visualizar o registro de clientes. \n");
							System.out.println(" ========= Deseja iniciar registro da venda? ========= ");
							System.out.println("1 - Sim | 2 - Não | 3 - Voltar ao menu anterior");
							option3_1 = input.nextInt();
							input.nextLine();
							switch (option3_1) {
							case 1:
								System.out.println("Exibindo pacotes disponíveis: \n");
								for (Pacote p : pacoteDAO.getPacote()) {
									System.out.println("ID Pacote: " + p.getId_pacote());
									System.out.println("Destino: " + p.getDestino());
									System.out.println("Valor: " + p.getValor());
									System.out.println("Data viagem: " + p.getData_viagem() + "\n");
								}
								Compra cp = new Compra();
								System.out.println("Informe os dados solicitados. \n");
								System.out.println("Destino: ");
								cp.setDestino(input.nextLine());
								System.out.println("Valor: ");
								cp.setValor(input.nextDouble());
								System.out.println("ID do Cliente: ");
								cp.setId_cliente(input.nextInt());
								System.out.println("Nº do pacote: ");
								cp.setId_pacote(input.nextInt());
								compraDAO.comprar(cp);
								System.out.println("Venda realizada.");
								break;
							case 2:
								System.out.println("Exibindo clientes cadastrados: \n");
								for (Cliente c : clienteDAO.getClientes()) {
									System.out.println("ID Cliente: " + c.getId_cliente());
									System.out.println("Nome: " + c.getNome());
									System.out.println("Telefone: " + c.getTelefone());
									System.out.println("E-mail " + c.getEmail());
									System.out.println("CPF: " + c.getCpf() + "\n");
								}
								System.out.println(" =============================================== ");
								break;
							default:
								System.out.println(option3_1 != 3 ? "Opção inválida." : "");
								break;
							}
						} while (option3_1 != 3);
						break;
					case 2:
						System.out.println("Informe o ID da venda que será cancelada: ");
						int IdCompra = input.nextInt();
						compraDAO.deleteById(IdCompra);
						System.out.println("Venda cancelada.");
						break;
					case 3:
						System.out.println("Exibindo vendas realizadas: \n");
						for (Compra vFin : compraDAO.getCompras()) {
							System.out.println("ID Compra: " + vFin.getId_compra());
							System.out.println("Destino: " + vFin.getDestino());
							System.out.println("Valor: " + vFin.getValor());
							System.out.println("ID Cliente: " + vFin.getId_cliente());
							System.out.println("ID Pacote: " + vFin.getId_pacote() + "\n");
						}
						System.out.println(" =============================================== ");
						break;
					default:
						System.out.println(option3 != 4 ? "Opção inválida." : "");
						break;
					}
				} while (option3 != 4);
			default:
				System.out.println(option != 0 ? "Opção inválida." : "");
				break;
			}
		} while (option != 0);
		System.out.println("Sistema finalizado pelo usuário.");
		input.close();
	}
}