
import javax.swing.JFrame; // Aqui importa a biblioteca 

public class ListTest // Aqui é a criação da classe ListTest
{// Aqui é para dar início ao bloco e código
   public static void main(String[] args) // Aqui está definindo o método executor main, que será exportado(public), do tipo estático(static) sem returno(void), com 1 parâmetro, argumento do tipo  matriz"[]" String
   { 
      ListFrame listFrame = new ListFrame(); // create ListFrame (criar ListFrame) // Aquiestá declarando uma variável
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aqui está definindo o padrão de fechamento, sair ao fechar
      listFrame.setSize(350, 150); // Aqui define o tamanho, largura (width) e altura(height)
      listFrame.setVisible(true); // Aqui define a visibilidade, para mostrar na tela 
   } 
} // Aqui fecha a classe ListTest


