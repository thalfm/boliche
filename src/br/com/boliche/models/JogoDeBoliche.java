package br.com.boliche.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.boliche.services.CalculadoraPontuacaoBoliche;

public class JogoDeBoliche {
	private List<Rodada> rodadas = new ArrayList<>(10);
	
	public List<Rodada> getRodadas() {
		return Collections.unmodifiableList(this.rodadas);
	}

	public void adicionarRodada(Rodada rodada) {
		this.rodadas.add(rodada);
	}
	
	public int pontuacaoTotal() {
		return CalculadoraPontuacaoBoliche.pontuacaoDoJogo(this.rodadas);
	}
	
	public Builder getBuilder() {
		return new Builder(this);
	}
	
	public class Builder {
		private JogoDeBoliche jogo;
		Builder(JogoDeBoliche jogo) {
			this.jogo = jogo;
		}
		
		public JogoDeBoliche criaJogoComDezRodadas() {
			int listaRodadas[] = {1,2,3,4,5,6,7,8,9,10};

			Arrays.stream(listaRodadas).forEach(numeroRodada -> {
				this.jogo.adicionarRodada(new Rodada(numeroRodada));
			});
			return this.jogo;
		}
	}
}
