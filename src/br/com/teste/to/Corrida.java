package br.com.teste.to;

public class Corrida {
	private int id;
	private Motorista motorista;
	private Passageiro passageiro;
	private double valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
