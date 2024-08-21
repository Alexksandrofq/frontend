
import javax.swing.JFrame; // Aqui está importando uma biblioteca do javax, do tipo swing do camponente JFrame

public class TextFieldTest // Aqui está declarando uma class chamada TextFieldTest
{
   public static void main(String[] args) // Aqui é a declaração do método executor main, protegido, que não retorna valor, estatico somente leitura, que exporta, o recebimento de um parâmetro args do tipo string) 
   { 

      /**
       * TextFieldFrame: class
       * textFieldFrame: nome da variável
       * new TextFieldFrame:
       * EXIT_ON_CLOSE: sair ao fechar, para não ficar rodando em segundo plano 
       */
      TextFieldFrame textFieldFrame = new TextFieldFrame(); // Aqui está sendo declarado uma variável
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aqui está sendo definido a operação de fechar  
      textFieldFrame.setSize(350, 100); // Aqui está sendo definido a largura (width) e altura (height)
      textFieldFrame.setVisible(true); // Aqui está sendo definido a visibilidade

   } // Aqui fecha o método 
} // Aqui fecha a class

