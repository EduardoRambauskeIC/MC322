package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	boolean em_jogo;
	
	Peca(boolean em_jogo){
		this.em_jogo = em_jogo;
	}
	
	void captura(Casa movimento,Casa capturada) {
		if(capturada.peca.em_jogo == true) {
			if(movimento.peca.em_jogo == false) {
				capturada.peca.capturar();
				this.em_jogo = false;
				movimento.peca.em_jogo = true;
			} else {
				System.out.println("Casa destino não está vazia");
			}
		}else{
			System.out.println("Não há peça a ser capturada");
		}
	}
	
	void capturar() {
		this.em_jogo = false;
	}
}
