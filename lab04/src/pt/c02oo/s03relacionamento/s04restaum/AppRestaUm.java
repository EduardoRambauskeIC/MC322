package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
          
      Tabuleiro board = new Tabuleiro();
     
      tk.writeBoard("Tabuleiro inicial", board.apresenta());
      for (int l = 0; l < commands.length; l++) {
    	  String comando[] = commands[l].split(":");
    	  board.jogada(comando[0],comando[1]);
      }
              
      tk.stop();
   }

}