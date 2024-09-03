import javax.swing.JFrame; // Aqui está importando a biblioteca 

public class MouseTracker // Aqui está definindo a classe MouseTracker
{
   public static void main(String[] args) // Aqui está definindo o método executor main, que será exportado, de modo estático, sem retorno, com 1 parâmetro. argumento  matriz do tipo String
   { 
      MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame(); // Aqui está declarando uma variável
      mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aqui está definindo o padrão de fechamento, sair ao fechar 
      mouseTrackerFrame.setSize(300, 100); //  Aqui está definindo a largura (width) e altura (height)
      mouseTrackerFrame.setVisible(true); //  Aqui está definido a visibilidade, para mostrar na tela
   } 
} // Aqui fecha a classe

