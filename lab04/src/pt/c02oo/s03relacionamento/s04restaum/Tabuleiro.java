package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	Casa posicao[][];
	
	void preencherTabuleiro() {
		for(int i = 0;i<7;i++) {
			for(int j = 0;j<7;j++) {
				if((i<2||i>4) && j < 5 && j > 1) {
					Peca peca = new Peca(i,j);
					posicao[i][j] = new Casa(peca);
				} else if ((i>=2 && i<=4 ) && (i!=3||j!=3)) {
					Peca peca = new Peca(i,j);
					posicao[i][j] = new Casa(peca);
				} else if(i == 3 && j == 3) {
					posicao[i][j] = new Casa(null);
				} else {
					posicao[i][j] = null;
				}
			}
		}
	}
	
	Tabuleiro(){
		preencherTabuleiro();
	}
	
	char[][] apresenta() {
		char representacao[][] = new char[7][7];
		
		for(int i = 0;i<7;i++) {
			for(int j = 0;j<7;j++) {
				if(posicao[i][j] == null) {
					representacao[i][j] = ' ';
				} else if(posicao[i][j].vazia == true) {
					representacao[i][j] = '-';
				} else {
					representacao[i][j] = 'P';
				}
			}
		}
		return representacao;
	}
}
