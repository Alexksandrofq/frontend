import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class ListFrame extends JFrame // Aqui está definindo a classe Listframe que herdará da JFrame
{// Aqui serve para iniciar o bloco de código

   
   private final JList<String> colorJList; // list to display colors (lista para exibir cores) // Variável que será manipulada no construtor e não será mais alterada (final)

   //Variaveis já manipuladas, estão não serão manipuladas no construtor e não serão mais alteradas
   private static final String[] colorNames = {"Black", "Blue", "Cyan", // Matriz de nome de cores, é String
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow"};
   private static final Color[] colors = {Color.BLACK, Color.BLUE, // Matriz de cores
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};
     
      private final JList<String> sizeJList;
      private static final String[] sizeNames = {"samll", "Medium", "Big"};



   // ListFrame constructor add JScrollPane containing JList to JFrame (Construtor ListFrame adiciona JScrollPane contendo JList a JFrame)
   public ListFrame() // Aqui está definindo o construtor
   {
      super("List Test"); // Aqui está definido o título que aparecerá em cima 
      setLayout(new FlowLayout()); // Aqui está definindo o layout que será responsivo, por causa do Flow
      

      colorJList = new JList<String>(colorNames); // list of colorNames (lista de nomes de cores) // Declaração de variável, atribuirá um novo objeto JList, que será matriz, tipo String, dentro da tag
      colorJList.setVisibleRowCount(5); // display five rows at once (exibir cinco linhas de uma vez) // Aqui defini o método, a visibilidade  de contagem de máxima de linhas que serão mostradas, 5 total
      
      // do not allow multiple selections (não permitir seleções múltiplas)
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Aqui definie o método modo de seleção, modelo de lista que será de seleção única  

      // add a JScrollPane containing JList to frame (adicione um JScrollPane contendo JList ao quadro)
      add(new JScrollPane(colorJList));

   

      sizeJList = new JList<String>(sizeNames);
      sizeJList.setVisibleRowCount(3);
      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      add(new JScrollPane(sizeJList));

      colorJList.addListSelectionListener( // Aqui invoca o addListSelectionListener, que é um excutador 

         new ListSelectionListener() // anonymous inner class (classe interna anônima) // Aqui é um novo objeto
         {   
            // handle list selection events (lidar com eventos de seleção de lista)
            @Override // Sobescrever
            public void valueChanged(ListSelectionEvent event) // Aqui define o método valueChanged
            {
               getContentPane().setBackground( // Aqui define o getContentPane, o quadro de fundo e depois define o background 
                  colors[colorJList.getSelectedIndex()]); // Aqui irá pegar a cor selecionada, atráves do index, o número do vetor de dentro 
            } 
         } // Aqui fecha o construtor ListSelectionListener

      ); // Aqui fecha o parâmetro
      
   
      sizeJList.addListSelectionListener( 
         new ListSelectionListener() 
         {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               switch (sizeJList.getSelectedIndex()) {
                  case  0:
                     setSize(350,150);
                     break;

                  case  1:
                  setSize(550,350);                 
                  break;

                  case  2:
                  setSize(750,550);                 
                  break;

                  default:
                  setSize(350,150);
                     break;
               }
            }

         }
   
      );

   } // Aqui fecha o construtor ListFrame


} // Aqui fecha a classe ListFrame


