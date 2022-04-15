package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	// Atributo que define se a Peca de uma Casa esta em jogo
	private boolean emJogo;
	
	// Interface
	public boolean getEmJogo() {
		return emJogo;
	}
	private void setEmJogo(boolean emJogo) {
		this.emJogo = emJogo;
	}
	
	public Peca(boolean em_jogo){
		// Constructor da Peca
		this.emJogo = em_jogo;
	}
	
	public int captura(Casa movimento,Casa capturada) {
		// A peca recebe a casa para o destino do movimento e a casa onde tem a peca a ser capturada e realiza a captura
		
		// Verifica se existe a peca intermediaria que seria capturada
		if(capturada.getPeca().emJogo == true) {
			// Verifica se nao existe uma peca no espaco para ser movida
			if(movimento.getPeca().emJogo == false) {
				capturada.getPeca().setEmJogo(false);
				this.emJogo = false;
				movimento.getPeca().emJogo = true;
				return 0;
			} else {
				// Se nao tiver vazio a casa de movimento retorna 2
				System.out.println("Casa destino nao esta vazia");
				return 2;
			}
		}else{
			// Retorna 1 se n tiver peca a ser capturada
			System.out.println("Nao ha peca a ser capturada");
			return 1;
		}
	}
	
	
}
