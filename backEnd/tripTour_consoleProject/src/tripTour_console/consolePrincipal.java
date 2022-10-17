package tripTour_console;

import java.util.Scanner;

import dao.CompraDAO;
import model.Compra;

public class consolePrincipal {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		CompraDAO venda = new CompraDAO();
		
		System.out.println("Informe o código do pacote:");
		entrada.nextInt();
		Compra a1 = new Compra();
		venda.comprar(a1);
		System.out.println("Cadastrado.");
		entrada.close();
	}

}