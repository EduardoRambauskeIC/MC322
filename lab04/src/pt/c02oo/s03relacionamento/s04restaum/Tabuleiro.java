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
		posicao = new Casa[7][7];
		preencherTabuleiro();
	}
	
	int[] acharCoord(String comando) {
		int coord[] = new int[2];
		coord[0] = comando.charAt(0) - 97;
		coord[1] = Integer.parseInt(comando.split("")[1]);
		return coord;
	}
	
	void jogada(String src, String dest) {
		int coordAtacante[] = acharCoord(src); //[0,1]
		int coordMovimento[] = acharCoord(dest);
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
