// Aqui está importando a biblioteca
import javax.swing.JFrame;
// Aqui está definindo a classe MenuTest
public class MenuTest
{
// Aqui está definindo o método executor main, com apenas um parâmetro, do tipo argumento de matriz tipo String, que será sem retorno, estático e importado
   public static void main(String[] args)
   { 
      MenuFrame menuFrame = new MenuFrame(); // Declaração de variável
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aqui está definindo o padrão de fechamento, sair ao fechar 
      menuFrame.setSize(500, 200); // Aqui está definindo o tamanho da largura(width) e altura(height)
      menuFrame.setVisible(true); // Aqui está definindo a visibilidade 
   } // Aqui fecha o método executor

} // Aqui fecha a classe




