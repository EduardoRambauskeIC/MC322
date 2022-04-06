package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start(); 
      
      String lombrigas[] = tk.recuperaLombrigas(); // Le lombrigas no csv
      
      for (int l = 0; l < lombrigas.length; l++) { // Realiza a animacao em cada lombriga do csv
        Animacao anima = new Animacao(lombrigas[l]);
      	for(int i = 0;i<lombrigas[l].length() - 3;i++){
          anima.passo();
          if(i == 2){ // Divisao de animacoes
             tk.gravaPasso("=====");
          }
          if(i > 2){
             tk.gravaPasso(anima.apresenta());
          }
      	}
      }
      tk.stop();
   }

}
