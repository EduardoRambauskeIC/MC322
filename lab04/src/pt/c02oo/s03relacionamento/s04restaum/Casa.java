package pt.c02oo.s03relacionamento.s04restaum;

public class Casa {
	int linha;
	int coluna;
	Peca peca;
	
	Casa(Peca peca,int linha, int coluna){
		this.peca = peca;
		this.linha = linha;
		this.coluna = coluna;
	}
	
}
