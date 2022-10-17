package model;

public class Pacote {
	private int id_pacote;
	private String destino;
	private double valor;
	private String data_viagem;

	public int getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
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

	public String getData_viagem() {
		return data_viagem;
	}

	public void setData_viagem(String data_viagem) {
		this.data_viagem = data_viagem;
	}

	public Pacote() {

	}

	public Pacote(int id_pacote, String destino, double valor, String data_viagem) {
		this.id_pacote = id_pacote;
		this.destino = destino;
		this.valor = valor;
		this.data_viagem = data_viagem;
	}
}