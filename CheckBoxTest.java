//Aqui está importando o Jframe
import javax.swing.JFrame;

public class CheckBoxTest //Criada a classe
{
   public static void main(String[] args) //método executor main
   { 
      //Aqui é criado o objeto
      /**
       * CheckBoxFrame: tipo
       */
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); 
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //definido ao sair fechar
      checkBoxFrame.setSize(275, 100); //Definição de tamanho
      checkBoxFrame.setVisible(true); //Aqui rederiza
   } //Aqui fecha o método
} //Aqui fecha a class

