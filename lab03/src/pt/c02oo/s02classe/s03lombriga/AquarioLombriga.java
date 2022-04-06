package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    int posCabeca, tamLombriga, tamAquario;
    int lado = 0; // Lado = 0: Cabeca pra esquerda / Lado = 1: Cabeca pra direita
    
    AquarioLombriga(int tamAquario,int tamLombriga,int posCabeca){
        // Construtor
        this.posCabeca = posCabeca;
        this.tamAquario = tamAquario;
        this.tamLombriga = tamLombriga;
    }
    void mover(){
        // Move 1 espaco do aquario se possivel a frente da posicao da cabeca, se nao e possivel -> vira
        if(lado == 0 && posCabeca > 1){
            posCabeca -= 1;
        } else if(lado == 1 && posCabeca < tamAquario){
            posCabeca += 1;
        } else{
            virar();
        }
    }
    void crescer(){
        // Cresce 1 se possivel atras do tamanho
        if(lado == 0 && posCabeca + tamLombriga - 1 < tamAquario){
            tamLombriga += 1;
        } else if(lado == 1 && posCabeca - tamLombriga > 0){
            tamLombriga += 1;
        }   
    }
    void virar(){
        // Troca a posicao da cabeca
        lado = lado == 0 ? 1 : 0;
        if(lado == 1){
            posCabeca += tamLombriga - 1;
        } else {
            posCabeca -= tamLombriga - 1;
        }
        
    }

    String apresenta(){
        // Retorna string de apresentacao do aquario/lombriga
        String apresentacao = "";
        for(int i = 1;i<=tamAquario;i++){ 
            if(lado == 0 && i == posCabeca){ // Lombriga do lado 0
                apresentacao += "O";
                for(int t = 0;t<tamLombriga-1;t++){
                    apresentacao += "@";
                    i++;
                }
            }
            else if(lado == 1 && i == posCabeca - tamLombriga + 1){ // Lombriga do lado 1
                for(int t = 0;t<tamLombriga-1;t++){
                    apresentacao += "@";
                    i++;
                }
                apresentacao += "O";
            }
            else { // Parte vazia do aquario
                apresentacao += "#";
            }
        }
        return(apresentacao); 
    }
}
