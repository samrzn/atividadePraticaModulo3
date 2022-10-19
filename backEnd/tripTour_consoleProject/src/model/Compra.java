package model;

public class Compra {
	private int id_compra;
	private String destino;
	private double valor;

	private int id_cliente;
	private int id_pacote;

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
	}

	public Compra() {

	}

	public Compra(int id_compra, String destino, double valor, int id_cliente, int id_pacote) {
		this.id_compra = id_compra;
		this.destino = destino;
		this.valor = valor;
		this.id_cliente = id_cliente;
		this.id_pacote = id_pacote;
	}

	public void setFk_id_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
}