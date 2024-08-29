import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ComboBoxFrame extends JFrame // Aqui está definindo a classe ComboBoxFrame que estará herdando do JFrame
{ // Aqui inicia o começo do bloco de código 

   //Duas variáveis somente leitura que serão manipuladas no construtor
   private final JComboBox<String> imagesJComboBox; // hold icon names (reter nomes de ícones)
   private final JLabel label; // displays selected icon (exibe o ícone selecionado)

   //Variáveis que não serão manipuladas no construtor, já estão atribuidas  
   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { //Variável matriz do tipo icon com 4 vetores 
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   // ComboBoxFrame constructor adds JComboBox to JFrame (O construtor ComboBoxFrame adiciona JComboBox ao JFrame)
   public ComboBoxFrame()
   {
      super("Testing JComboBox"); // Aqui defini o título superior
      setLayout(new FlowLayout()); // set frame layout  (definir o layout do quadro)   // Aqui defini o layout, Flow que é reponsivo 

      imagesJComboBox = new JComboBox<String>(names); // set up JComboBox (configurar o JComboBox) // Aqui é declaração de variável, um novo objeto JComBox, matriz dentro de um tag
      imagesJComboBox.setMaximumRowCount(3); // display three rows (exibir três linhas) // Aqui está definindo o método, que diz a contagem máxima de linha (3), para exibir

      imagesJComboBox.addItemListener( // Aqui invoca o addItemListener e no parametro um novo objeto do mesmo tipo ItemListener 
         new ItemListener() // anonymous inner class (classe interna anônima)
         {
            // handle JComboBox event (lidar com evento JComboBox)
            @Override //Sobescrever 
            public void itemStateChanged(ItemEvent event) // Aqui define o método itemStateChanged
            {
               // determine whether item selected (determinar se o item foi selecionado)
               if (event.getStateChange() == ItemEvent.SELECTED) // Aqui pega o estado mudado, no caso a imagem e comparar com o próprio ItemEvent e ve se está selecionado 
                  label.setIcon(icons[ // Aqui define a label, setIcon, e no parâmetro será usado um dos vatores das matriz em cima
                     imagesJComboBox.getSelectedIndex()]); // Aqui é o vetor, pega o index(é o número/nomes dos vetores)
            } // Aqui fecha o método

         } // Aqui fecha o construtor

      ); // Aqui fecha o parâmetro 

      add(imagesJComboBox); // add combobox to JFrame (adicionar caixa de combinação ao JFrame)
      label = new JLabel(icons[0]); // display first icon (exibir o primeiro ícone) // declaração de variável, que começa com o primeiro vetor, a primeira imagem
      add(label); // add label to JFrame

   }// Aqui fecha o construtor ComboFrame

} // Aqui fecha a classe ComboBoxFrame


