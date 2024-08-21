
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldFrame extends JFrame 
{
   /**
    * Aqu está sendo declarado variáveis, de somente leitura
    */
   private final JTextField textField1; // text field with set size (campo de texto com tamanho definido)
   private final JTextField textField2; // text field with text (campo de texto com texto)
   private final JTextField textField3; // text field with text and size (campo de texto com texto e tamanho)
   private final JPasswordField passwordField; // password field with text(campo de senha com texto)

   // TextFieldFrame constructor adds JTextFields to JFrame (O construtor TextFieldFrame adiciona JTextFields ao JFrame)
   public TextFieldFrame()
   {
      super("Testing JTextField and JPasswordField"); //Aqui está definindo o titulo
      setLayout(new FlowLayout());

      // construct textfield with 10 columns (construir campo de texto com 10 colunas)
      textField1 = new JTextField(10); // Aqui está definindo o tamanho da caixa, 10 colunas
      add(textField1); // add textField1 to JFrame

      // construct textfield with default text (construir campo de texto com texto padrão)
      textField2 = new JTextField("Enter your text here now");// Aqui está definindo a caixa com a escrita que irá aparecer dentro
      add(textField2); // add textField2 to JFrame

      // construct textfield with default text and 21 columns (construir campo de texto com texto padrão e 21 colunas)
      textField3 = new JTextField("Uneditable text field", 21);// Aqui está definindo a mensagem que ira aparecer 
      textField3.setEditable(false); // disable editing () //Aqui está impedindo uma edição
      add(textField3); // add textField3 to JFrame (adicione textField3 ao JFrame)

      // construct passwordfield with default text (construir campo de senha com texto padrão)
      /**
       * JPasswordField: tipo 
       */
      passwordField = new JPasswordField("Hidden text"); // Aqui está definindo que irá aparecer bolinhas invés de letras 
      add(passwordField); // add passwordField to JFrame
      /*Aqui é criado uma variável, uma subclass
       *  handler: manipulador
       */
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler);
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler);
   } // Fecha o construtor

   // private inner class for event handling (classe interna privada para manipulação de eventos)
   private class TextFieldHandler implements ActionListener 
   {
      // process textfield events (processar eventos de campo de texto)
      @Override //Para injetar dados
      public void actionPerformed(ActionEvent event)//Aqui está sendo criado um método, a ação do botão , do input
      {
         /***
          * ActionCommand: texto digitado pelo usuário , input
          gatActionCommand: captura o valor do objeto e transforma em string
          */
         String string = ""; 
         // user pressed Enter in JTextField textField1 (usuário pressionou Enter em JTextField textField1)
         if (event.getSource() == textField1)//
            string = String.format("textField1: %s",//Aqui decla o formato, %s é formato de String
               event.getActionCommand());//O texto digitado
        
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());

         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // display JTextField content (exibir conteúdo JTextField)
         JOptionPane.showMessageDialog(null, string); 
      } //Fecha a ação
   } // Fecha a subclass TextFieldHandler
} // Fecha a class TextFieldFrame


