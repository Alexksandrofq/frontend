
import java.awt.*; // specifies how components are arranged (especifica como os componentes são organizados)
//import javax.swing.JFrame; // provides basic window features (fornece recursos básicos de janela)
//import javax.swing.JLabel; // displays text and images (exibe texto e imagens)
//import javax.swing.SwingConstants; // common constants used with Swing (constantes comuns usadas com Swing)
//import javax.swing.Icon; // interface used to manipulate images (interface usada para manipular imagens)
import javax.swing.*; // loads images (carrega imagens) // carrega todos os camponents do módulo swing da biblioteca javax

public class LabelFrame extends JFrame // Aqui está sendo declarado uma class, que está herdando o camponente JFrame
{
   /**
    * private: privado, para uso somente dentro class
    *final: somente leitura, usado somente em varaável
    *JLabel: é um tipo
    *label: nome da variável
    * declaração de variaveis do tipo JLabel, somente leitura para uso exclusivo da classe LabelFrame
    **/
   private final JLabel label1; // JLabel with just text (JLabel com apenas texto) // Aqui está sendo criado uma variável que será usado apenas na classe, pois está privado
   private final JLabel label2; // JLabel constructed with text and icon (JLabel construído com texto e ícone)
   private final JLabel label3; // JLabel with added text and icon (JLabel com texto e ícone adicionados)

   // LabelFrame constructor adds JLabels to JFrame (O construtor LabelFrame adiciona JLabels ao JFrame)
   public LabelFrame() // Aqui está sendo declarado um construtor, pois tem o mesmo nome do arquivo, da class
   {
      /**
       * super: está definindo o titulo da janela, metodo herdado do JFrame
       * setLayout: metodo e função
       * FlowLayout: objeto
       */
      super("Testing JLabel");
      setLayout(new FlowLayout()); // set frame layout (definir o layout do quadro) // Aqui irá definir o layout 
      

      // JLabel constructor with a string argument (Construtor JLabel com argumento de string)
      /**
       * label1: nome da variável
       * new JLabel: novo objeto
       * ToolTipText: ferramenta de dica
       */
      label1 = new JLabel("Label with text");//Aqui está sendo declarado a variável
      label1.setToolTipText("This is label1");//Aqui esta sendo definido um método de farramenta de dica 
      add(label1); // add label1 to JFrame (adicione rótulo ao JFrame) // Adicionar a variável, adicionado um camponente, a variável do JFrame

      // JLabel constructor with string, Icon and alignment arguments (Construtor JLabel com argumentos de string, ícone e alinhamento)
      /**
       * Icon: Definição de tipo
       * getClass: Invocar a class do JFrame, verificando se há uma instância em aberto
       * getResource: Pegando recurso
       * SwingConstantes: Tipo, para definir o alinhamento
       */
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));//Aqui é a declaração de variável do tipo icon(aicon)
      label2 = new JLabel("Label with text and icon", bug, 
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2");
      add(label2); // add label2 to JFrame (adicione label2 ao JFrame)

      

      label3 = new JLabel(); // JLabel constructor no arguments (adicione label2 ao construtor JFrameJLabel sem argumentos) //Aqui está sendo declarado uma variável 
      label3.setText("Label with icon and text at bottom");// Aqui está sendo definido o texto
      label3.setIcon(bug); // add icon to JLabel (adicionar ícone ao JLabel)
      label3.setHorizontalTextPosition(SwingConstants.CENTER);//Aqui está sendo definido a posição horizontal do texto
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);//Aqui está sendo definido a posição vertical do texto
      label3.setToolTipText("This is label3");// Aqui está sendo definido a farramenta de dica 
      add(label3); // add label3 to JFrame (adicione label3 ao JFrame)
   } // Aqui fecha o construtor
} // end class LabelFrame // Aqui fecha a class LabelFrame


