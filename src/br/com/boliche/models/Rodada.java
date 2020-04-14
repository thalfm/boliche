package br.com.boliche.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rodada {
	private static int NUMERO_MAXIMO_ARREMECOS = 2;

	private int numeroRodada;
	private int numeroDePinos = 10;
	private List<Integer> arremecos = new ArrayList<>();

	public Rodada(int numeroRodada) {
		this.numeroRodada = numeroRodada;
	}

	public void arremecoAleatorio() {
		int arremeco = new Random().nextInt(this.numeroDePinos + 1);
		this.arremecar(arremeco);
	}

	public void arremecar(int arremeco) {
		this.subtraiNumeroDePinos(arremeco);
		this.arremecos.add(arremeco);
	}

	public int numeroDeArremecos() {
		return this.arremecos.size();
	}

	public boolean jogadaFinalizada() {
		return this.chegouNoNumeroMaximoDeArremecos() || this.fezStrike();
	}

	public List<Integer> getArremecos() {
		return this.arremecos;
	}

	public int pontuacaoDaRodada() {
		return this.getArremecos().stream().reduce(0, Integer::sum);
	}
	
	public TipoBonus getBonus() {
		if (this.fezStrike()) {
			return TipoBonus.STRIKE;
		}

		if (this.fezSpare()) {
			return TipoBonus.SPARE;
		}

		return TipoBonus.NENHUM;
	}

	@Override
	public String toString() {
		return "Rodada nº " + this.numeroRodada + " - Pinos derrubados: " + this.arremecos + " - bônus: " + getBonus() + " \n";
	}

	private void subtraiNumeroDePinos(int numero) {
		this.numeroDePinos = this.numeroDePinos - numero;
	}

	private boolean chegouNoNumeroMaximoDeArremecos() {
		return this.numeroDeArremecos() == Rodada.NUMERO_MAXIMO_ARREMECOS;
	}

	private boolean fezStrike() {
		return this.numeroDeArremecos() == 1 && this.numeroDePinos == 0;
	}

	private boolean fezSpare() {
		return this.numeroDeArremecos() > 1 && this.numeroDePinos == 0;
	}
}
