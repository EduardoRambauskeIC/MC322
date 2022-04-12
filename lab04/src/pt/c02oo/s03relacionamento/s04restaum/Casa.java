package pt.c02oo.s03relacionamento.s04restaum;

public class Casa {
	boolean vazia;
	Peca peca;
	
	Casa(Peca peca){
		this.peca = peca;
		if(this.peca == null) {
			this.vazia = true;
		} else {
			this.vazia = false;
		}
	}
}
