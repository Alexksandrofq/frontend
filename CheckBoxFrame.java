
import java.awt.*;
import java.awt.font.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;


public class CheckBoxFrame extends JFrame // Definição da classe, CheckBoxFrame está herdando o JFrame(biblioteca)
{
   private final JTextField textField; // displays text in changing fonts (exibe texto em mudança de fontes)
   private final JCheckBox boldJCheckBox; // to select/deselect bold (para selecionar/desmarcar negrito)
   private final JCheckBox italicJCheckBox; // to select/deselect italic (para selecionar/desmarcar itálico)
   private final JCheckBox underlineJCheckBox;

   // CheckBoxFrame constructor adds JCheckBoxes to JFrame
   public CheckBoxFrame()
   {
      super("JCheckBox Test"); // Aqui é o título
      setLayout(new FlowLayout()); // Aqui defina o layout

      // set up JTextField and set its font (configure JTextField e defina sua fonte)
      textField = new JTextField("Watch the font style change", 20); // Declaração de variável
      textField.setFont(new Font("Serif", Font.PLAIN, 14)); // Invocação do método setfont
      add(textField); 

      boldJCheckBox = new JCheckBox("Bold"); // Declaração de variável
      italicJCheckBox = new JCheckBox("Italic"); // Declaração de variável
      underlineJCheckBox = new JCheckBox("Underline");
      add(boldJCheckBox); // add bold checkbox to JFrame (adicione caixa de seleção em negrito ao JFrame) // Adicionando variável 
      add(italicJCheckBox); // add italic checkbox to JFrame (adicionar caixa de seleção em itálico ao JFrame)
      add(underlineJCheckBox);

      // register listeners for JCheckBoxes (registrar ouvintes para JCheckBoxes)
      /**
       * handler: manipulador
       */
      CheckBoxHandler handler = new CheckBoxHandler();
      /**
       * os dois objetos foram adicionados ao handler CheckBoxFrame()
       */
      boldJCheckBox.addItemListener(handler);
      italicJCheckBox.addItemListener(handler);
      underlineJCheckBox.addItemListener(handler);


   } // Aqui fecha o construtor  

   // private inner class for ItemListener event handling (classe interna privada para manipulação de eventos ItemListener)
   private class CheckBoxHandler implements ItemListener 
   {
      // respond to checkbox events
      @Override
      public void itemStateChanged(ItemEvent event) // Aqui está definindo o método publico, sem retorno 
      {
         Font font = null; // stores the new Font (armazena a nova fonte) // Definição de variável que receberá valor nulo

         // determine which CheckBoxes are checked and create Font (determinar quais CheckBoxes estão marcadas e criar Font)
         //Aqui é definido o validador 
         /**
          * +: o +(mais) significa concatenar "colocar junto"
          * isSelected: método, "está selecionado"
          *&&: "e"
          */
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
         else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14);
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);
         else
            font = new Font("Serif", Font.PLAIN, 14);
         
            textField.setFont(font);
      
         if (underlineJCheckBox.isSelected()) {
            font = textField.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            textField.setFont(font.deriveFont(attributes));
            font = new Font(attributes);

         }
         
     } // Aqui fecha o método itemStateChanged
   } // Aqui fecha a class CheckBoxHandler 
} // Aqui fecha a class CheckBoxFrame

