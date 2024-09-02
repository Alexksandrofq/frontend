
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame // Aqui está definindo a classe MultipleSelectionFrame que está herdando do Jframe
{
   // Há 3 variáveis que irão ser manipuladas no construtor
   private final JList<String> colorJList; // list to hold color names (lista para conter nomes de cores)
   private final JList<String> copyJList; // list to hold copied names (lista para armazenar nomes copiados)
   private JButton copyJButton; // button to copy selected names (botão para copiar nomes selecionados)
   private JButton copyJButton2; 
   private final JList<String> copyJList2;

   //Variável já manipulada
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};

   // MultipleSelectionFrame constructor (Construtor MultipleSelectionFrame)
   public MultipleSelectionFrame() // Aqui está definindo o construtor
   {
      super("Multiple Selection Lists"); // Aqui está definindo o título, que irá aparecer em cima 
      setLayout(new FlowLayout()); // Aqui está definindo o layout responsivo, reponsivo por causa do Flow

      colorJList = new JList<String>(colorNames); // list of color names (lista de nomes de cores) // Declaração de variável com um novo objeto do tipo JList mariz do tipo String
      colorJList.setVisibleRowCount(5); // show five rows (mostrar cinco linhas) // Aqui está definindo o método, a visibiliade de contagem máximas de linhas que serão mostradas, 5
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Aqui está definindo o método de seleção. modelo de linha que será de SELEÇÃO DE MÚLTIPLOS INTERVALOS 
      add(new JScrollPane(colorJList)); // add list with scrollpane (adicionar lista com scrollpane) 

      copyJButton = new JButton("Copy >>>"); // Declaração de variável , nono objeto tipo butaõ com nome Copy>>>
      copyJButton.addActionListener( // Aqui está definindo o método, que invoca o addActionListenner
         new ActionListener() // 
         {  
            // handle button event (lidar com evento de botão)
            @Override // Sobescreves 
            public void actionPerformed(ActionEvent event)
            {
               // place selected values in copyJList (coloque os valores selecionados em copyJList)
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0])); // Aqui defini o método que ira definir ListData,na matriz Array
            }
         } 
      ); 

      add(copyJButton); // add copy button to JFrame

      copyJList = new JList<String>(); // list to hold copied color names (lista para armazenar nomes de cores copiados) // Declaração de variável 
      copyJList.setVisibleRowCount(5); // show 5 rows
      copyJList.setFixedCellWidth(100); // set width
      copyJList.setFixedCellHeight(15); // set height
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_SELECTION); // Aqui defini o método de seleção, modelo de seleção de uma SELEÇÃO ÚNICA
      add(new JScrollPane(copyJList)); // add list with scrollpane (adicionar lista com scrollpane)

      copyJButton2 = new JButton("Copy >>>"); 
      copyJButton2.addActionListener( 
         new ActionListener()  
         {  
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
               
               copyJList2.setListData(
                  copyJList.getSelectedValuesList().toArray(
                     new String[0])); 
            }
         } 
      );
      add(copyJButton2);

      copyJList2 = new JList<String>(); // list to hold copied color names (lista para armazenar nomes de cores copiados) // Declaração de variável 
      copyJList2.setVisibleRowCount(5); // show 5 rows.setVisibleRowCount(5); // show 5 rows
      copyJList2.setFixedCellWidth(100); // set width.setFixedCellWidth(100); // set width
      copyJList2.setFixedCellHeight(15); // set height.setFixedCellHeight(15); // set height
      copyJList2.setSelectionMode(
         ListSelectionModel.SINGLE_SELECTION); // Aqui defini o método de seleção, modelo de seleção de uma SELEÇÃO ÚNICA
      add(new JScrollPane(copyJList2)); // add list with scrollpane (adicionar lista com scrollpane) colorJList3

   } // Aqui fecha o construtor 

} // Aqui fecha a classe



