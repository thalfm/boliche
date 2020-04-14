package br.com.boliche;

import br.com.boliche.models.JogoDeBoliche;
import br.com.boliche.models.Rodada;

public class Main {
	public static void main(String[] args) {

		JogoDeBoliche jogo = new JogoDeBoliche()
				.getBuilder()
				.criaJogoComDezRodadas();

		for (int numeroRodada = 0; numeroRodada < jogo.getRodadas().size();) {

			Rodada rodada = jogo.getRodadas().get(numeroRodada);

			rodada.arremecoAleatorio();

			if (rodada.jogadaFinalizada()) {
				numeroRodada++;
			}
		}
		
		System.out.println(jogo.getRodadas());
		System.out.println("Pontuação todal: " + jogo.pontuacaoTotal());
	}
}
