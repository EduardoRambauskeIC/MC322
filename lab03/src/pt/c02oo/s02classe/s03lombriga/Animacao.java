package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
    AquarioLombriga lombriga;
    int frame, tamAquario,tamLombriga,posCabeca;
    String[] comandos;

    Animacao(String animacao){
        // Constructor da animacao
        frame = 0;
        comandos = animacao.split("");
    }
    void passo(){
            // Passa frame da animacao da lombriga
            // Recebe os dados do aquario/lombriga dos 6 primeiros digitos
            if(frame == 0){
                tamAquario = Integer.parseInt(comandos[frame] + comandos[frame+1]);
                frame += 2;
            }
            else if(frame == 2){
                tamLombriga = Integer.parseInt(comandos[frame] + comandos[frame+1]);
                frame += 2;
            }
            else if(frame == 4){
                posCabeca = Integer.parseInt(comandos[frame] + comandos[frame+1]);
                frame += 2;
                lombriga = new AquarioLombriga(tamAquario, tamLombriga, posCabeca);
            }
            else{ // Le comandos subsequentes e executa acao da lombriga
                if(comandos[frame].equals("C")){
                    lombriga.crescer();
                    frame += 1; 
                } else if(comandos[frame].equals("V")){
                    lombriga.virar();
                    frame += 1; 
                } else if(comandos[frame].equals("M")){
                    lombriga.mover();
                    frame += 1; 
                }
            }
    }
    String apresenta(){
        // Retorna a string do aquario/lombriga
        return(lombriga.apresenta());
    }
}
