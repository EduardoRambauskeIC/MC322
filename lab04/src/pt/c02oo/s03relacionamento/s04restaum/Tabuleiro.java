package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Casa posicao[][];
	
	void preencherTabuleiro() {
		// Preenche o tabuleiro da forma inicial de um jogo como uma matriz de Casas
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
	
	public Tabuleiro(){
		// Constructor do tabuleiro, preenchendo da forma inicial
		posicao = new Casa[7][7];
		preencherTabuleiro();
	}
	
	public int[] acharCoord(String comando) {
		// Acha a coordenada de um comando
		int coord[] = new int[2];
		coord[0] = (Integer.parseInt(comando.split("")[1])) - 1;
		coord[1] = comando.charAt(0) - 97;
		return coord;
	}
	public int[] acharCoordIntermediaria(int[] atacante, int[] movimento) {
		// Acha a coordenada intermediaria entre dois comandos
		int coord[] = new int[2];
		coord[0] = atacante[0] + (movimento[0] - atacante[0])/2;
		coord[1] = atacante[1] + (movimento[1] - atacante[1])/2;
		return coord;
	}
	
	public String jogada(String src, String dest) {
		// Jogada a partir de um comando
		
		// Encontra a coordenada da origem e destino do comando
		int coordAtacante[] = acharCoord(src); //[0,1]
		Casa atacante = posicao[coordAtacante[0]][coordAtacante[1]];
		int coordMovimento[] = acharCoord(dest);
		Casa movimento = posicao[coordMovimento[0]][coordMovimento[1]];
		
		// Verifica se o movimento entre as duas coordenadas e valido
		int dir[] = new int[2];
		dir[0] =coordMovimento[0]-coordAtacante[0];
		dir[1] = coordMovimento[1]-coordAtacante[1];
		if((dir[0] == 0 && (dir[1] != 2 && dir[1] != -2)) || (dir[0] == -2 && dir[1] != 0) || (dir[0] == 2 && dir[1] != 0 )) {
			return("Movimento invalido para essa peca");
		}
		
		// Encontra a casa da peca a ser capturada pela coordenada intermediaria entre origem e destino
		int coordCapturada[] = acharCoordIntermediaria(coordAtacante, coordMovimento);
		Casa capturada = posicao[coordCapturada[0]][coordCapturada[1]];
		
		
		
		if(atacante.getPeca().getEmJogo() == true) {
			// Caso exista uma peca na coordenada de origem, tenta executar a captura
			
			int resposta = atacante.getPeca().captura(movimento,capturada);
			
			switch(resposta){
			// Respostas para a tentativa de captura
				case 1:
					return("Nao ha peca a ser capturada");
				case 2:
					return("Casa destino nao esta vazia");
				default:
					// Caso sem apresentar erros(0)
					return("source: "+src+"; target: "+dest);
			}
		} else {
			return("Peca atacante invalida");
		}

	}
	
	public char[][] apresenta() {
		// Com base no status de cada Casa na posicao, e retornado o tabuleiro como uma matrix de chars
		char representacao[][] = new char[7][7];
		
		for(int i = 0;i<7;i++) {
			for(int j = 0;j<7;j++) {
				if(posicao[i][j] == null) {
					representacao[i][j] = ' ';
				} else if(posicao[i][j].getPeca().getEmJogo() == false) {
					representacao[i][j] = '-';
				} else {
					representacao[i][j] = 'P';
				}
			}
		}
		return representacao;
	}
}
