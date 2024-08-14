/**
 * import: comando importara toda a biblioteca
 * javax: biblioteca visual do java, o x é para identificar a biblioteca de recurso visual frontend
 * .: invoca o modulo
 * swing: é modulo
 * .: invoca o camponente
 * JOptionPane: é o camponente
 */
import javax.swing.JOptionPane; 


/**
 * public: declaração que permite exporta 
 * class: declaração de classe, exporta o nome da classe
 * Addition: objeto
 * */

public class Addition //Aqui está sendo declarado uma class chamada Addition
{
   /**
   * static: para deixar o método somente leitura
   * void: não retorna valor, declaração de método protegido
   * main: método executor
   * (): parenteses serve para declarar parâmetro de um método
   * String: é o tipo
   * []: sigifica que é uma matriz
   * args: é o parâmetro
   * {("chave aberta"): serve para indicar o ínicio do código
   */
   public static void main(String[] args) // Aqui está sendo criado um método executor main 
   //(é a uma declaração do executor main, protegido, que não retorna valor, estatico somente leitura, que exporta, o recebimento de um parâmetro args do tipo string)
   {
     
      /**
       * String: declaração de tipo da variável 
       * firstNumber: nome da variavel 
       * String fistNumber: declaração de uma variávels, criação
       * "=": operador de atribuição
       * JOptionPane: classe. e um componente de um modolo da uma biblioteca
       * . : operador de invocação do input
       * showInputDialog: método , exibindo uma caixa de dialogo com uma entradada de dados
       * ("Enter first integer"): é a mensagem que aparesserá para o usuário
       * ";": fim de linha
       */
      String firstNumber = // Aqui é uma declaração de uma variável
         JOptionPane.showInputDialog("Enter first integer");
      String secondNumber = // Aqui é a declaração de uma variávels
         JOptionPane.showInputDialog("Enter second integer");

      /**
       * int: declaração do tipo da variável
       * number: nome da variável
       * int number: delaração de uma variável, que sera de número inteiro 
       * Integer: camponente
       * parseInt: método, serve para analisar número inteiro 
       * Integer.parseInt: transforma uma string em inteiro
       */
      int number1 = Integer.parseInt(firstNumber); // Aqui é uma declaração de variável que ira converte um número inteiro 
      int number2 = Integer.parseInt(secondNumber);


      /**
       * sum: nome da variável
       * +: operador de soma 
       
       */
      int sum = number1 + number2; // Aqui é uma declaração de variável que irá somar 

      /**
       * null: significa que não existe camponente pai
       * +: concatenador
       * sum: para conventer o que venho antes em string
       * ",": operador de separação
       */
      JOptionPane.showMessageDialog(null, "The sum is " + sum, 
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);

   } // Aqui fecha bloco de código do método executor

} // Aqui fecha a class Addition 



