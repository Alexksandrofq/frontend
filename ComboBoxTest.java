
import javax.swing.JFrame; // Aqui importa a biblioteca javax

public class ComboBoxTest // Aqui está definindo a classe
{ // Ínicio do bloco de código, abertura
   public static void main(String[] args) // Aqui está definindo o método executor main, que não retorna valor. do tipo estático, com um parametro, argumento matriz, do tipo String 
   { 
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); // Aqui está declarando a variável
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aqui está definindo o padrão de fechamento, (sair ao fechar)
      comboBoxFrame.setSize(350, 150); // Aqui define a largura e altura
      comboBoxFrame.setVisible(true); // Aqui define a visibilidade, mostrar na tela
   } 
} // Aqui fecha a classe ComboBoxTest



