package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	Casa posicao[][];
	
	void preencherTabuleiro() {
		for(int i = 0;i<7;i++) {
			for(int j = 0;j<7;j++) {
				if((i<2||i>4) && j < 5 && j > 1) {
					Peca peca = new Peca(true);
					posicao[i][j] = new Casa(peca,i,j);
				} else if ((i>=2 && i<=4 ) && (i!=3||j!=3)) {
					Peca peca = new Peca(true);
					posicao[i][j] = new Casa(peca,i,j);
				} else if(i == 3 && j == 3) {
					Peca peca = new Peca(false);
					posicao[i][j] = new Casa(peca,i,j);
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
		coord[0] = (Integer.parseInt(comando.split("")[1])) - 1;
		coord[1] = comando.charAt(0) - 97;
		return coord;
	}
	int[] acharCoordIntermediaria(int[] atacante, int[] movimento) {
		int coord[] = new int[2];
		coord[0] = atacante[0] + (movimento[0] - atacante[0])/2;
		coord[1] = atacante[1] + (movimento[1] - atacante[1])/2;
		return coord;
	}
	
	String jogada(String src, String dest) {
		int coordAtacante[] = acharCoord(src); //[0,1]
		Casa atacante = posicao[coordAtacante[0]][coordAtacante[1]];
		int coordMovimento[] = acharCoord(dest);
		Casa movimento = posicao[coordMovimento[0]][coordMovimento[1]];
		int coordCapturada[] = acharCoordIntermediaria(coordAtacante, coordMovimento);
		Casa capturada = posicao[coordCapturada[0]][coordCapturada[1]];
		
		if(atacante.peca.em_jogo == true) {
			System.out.println("Peça atacante escolhida");
			atacante.peca.captura(movimento,capturada);
			return("source: "+src+"; target: "+dest);
			
		} else {
			return("Peça atacante invalida");
			
		}
		
		/*System.out.print(coordAtacante[0]);System.out.println(coordAtacante[1]);
		System.out.print(coordCapturada[0]);System.out.println(coordCapturada[1]);
		System.out.print(coordMovimento[0]);System.out.println(coordMovimento[1]);*/
	}
	
	char[][] apresenta() {
		char representacao[][] = new char[7][7];
		
		for(int i = 0;i<7;i++) {
			for(int j = 0;j<7;j++) {
				if(posicao[i][j] == null) {
					representacao[i][j] = ' ';
				} else if(posicao[i][j].peca.em_jogo == false) {
					representacao[i][j] = '-';
				} else {
					representacao[i][j] = 'P';
				}
			}
		}
		return representacao;
	}
}
