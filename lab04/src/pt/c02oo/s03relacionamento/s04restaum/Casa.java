package pt.c02oo.s03relacionamento.s04restaum;

public class Casa {
	// Classe da Casa que possui uma coordenada linha coluna e uma peca
	private int linha;
	private int coluna;
	private Peca peca;
	
	// Interface
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public Peca getPeca() {
		return peca;
	}
	
	public Casa(Peca peca,int linha, int coluna){
		// Constructor de uma Casa
		this.peca = peca;
		this.linha = linha;
		this.coluna = coluna;
	}
	
}
