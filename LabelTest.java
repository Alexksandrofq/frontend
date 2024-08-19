/**
 * import: irá importa 
 * javax: biblioteca visual
 * swing: modulo
 * JFrame: camponente ou class
 */

import javax.swing.JFrame; // Aqui está importado um abiblioteca do tipo swing


public class LabelTest // Aqui está sendo declarado a class chamda LabelTest
{
   /**
    * 
    *LabelFrame: class
    *labelFrame: nome da variável
    * EXIT_ON_CLOSE: sair ao fechar, para não ficar rodando em segundo plano ao clicar no x
    */
   public static void main(String[] args) // Aqui está sendo criado o método (main), sem retorno (void), somente leitura (static), exportado (public)
   { 
      LabelFrame labelFrame = new LabelFrame(); // Aqui é criado a variável
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aqui foi declarado definir operação de fechamento padrão
      labelFrame.setSize(360, 280); // Aqui está definindo a largura(width) e altura (height)
      labelFrame.setVisible(true); // Aqui está definindo a visibilidade
   } // Aqui fecha o código do metodo executor 
} // Aqui fecha a classe


