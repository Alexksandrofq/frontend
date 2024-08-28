
import javax.swing.JFrame;

public class RadioButtonTest  // Aqui está declarando uma classe
{// Aqui inicia o bloco de código
   public static void main(String[] args) // Aqui está declarando o método executor, com paramentro de matriz("[]") tipo string
   {
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame(); // Aqui é a declaração de variável
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aqui está definindo que irá fechar e parar de rodar
      radioButtonFrame.setSize(300, 135); // Aqui defini a largura e altura 
      radioButtonFrame.setVisible(true); 
   } 
} // Aqui encerra a classe

