package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
	  // Inicializa o Toolkit
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      // Recebe os comando do arquivo .csv em um vetor
      String commands[] = tk.retrieveCommands();
      
      // Inicializa um tabuleiro
      Tabuleiro board = new Tabuleiro();
      
      // Apresenta Tabuleiro inicial
      tk.writeBoard("Tabuleiro inicial", board.apresenta());
      
      // Loop passa por cada comando e apresenta tabuleiro apos jogada
      for (int l = 0; l < commands.length; l++) {
    	  String comando[] = commands[l].split(":");
    	  String jogada = board.jogada(comando[0],comando[1]);
    	  tk.writeBoard(jogada, board.apresenta());
      }
      
      // Encerra o Toolkit
      tk.stop();
   }

}