
import javax.swing.JFrame; // Aqui importa a biblioteca 

public class MultipleSelectionTest // Aqui está definindo a classe MultipleSelectionTest 

{ // Aqui abre o bloco de código 
   public static void main(String[] args) // Aqui está definindo o método executor main, que será exportado, de modo estático, sem retorno, com 1 parâmetro. argumento  matriz do tipo String
   { 
      MultipleSelectionFrame multipleSelectionFrame = 
         new MultipleSelectionFrame(); // Aqui está declarando uma variável
      multipleSelectionFrame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE); // Aqui está definindo o padrão de fechamento, sair ao fechar 
      multipleSelectionFrame.setSize(550, 150); // Aqui está definindo a largura (width) e altura (height)
      multipleSelectionFrame.setVisible(true); // Aqui está definido a visibilidade, para mostrar na tela
   } 

} // Aqui fecha o bloco de código 



