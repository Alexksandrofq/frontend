
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RadioButtonFrame extends JFrame // Aqui é criado a classe princiapl RadioButtonFrame que está herdando do JFrame
{ //Aqui inicia o bloco de código

   private JTextField textField; // used to display font changes (usado para exibir alterações de fonte) //Aqui é o campo input
   //Aqui há 4 variaveis do tipo fonte
   private Font plainFont; // font for plain text (fonte para texto simples)
   private Font boldFont; // font for bold text (fonte para texto em negrito)
   private Font italicFont; // font for italic text (fonte para texto em itálico)
   private Font boldItalicFont; // font for bold and italic text (fonte para texto em negrito e itálico)

   private Color blueColor;
   private Color redColor;
   private Color yellowColor;
   private Color blackColor;
   

   //Aqui há 4 bottons de grupo
   private JRadioButton plainJRadioButton; // selects plain text (seleciona texto simples)
   private JRadioButton boldJRadioButton; // selects bold text (seleciona texto em negrito)
   private JRadioButton italicJRadioButton; // selects italic text (seleciona texto em itálico)
   private JRadioButton boldItalicJRadioButton; // bold and italic (negrito e itálico)

   private JRadioButton blueJRadioButton; 
   private JRadioButton redJRadioButton; 
   private JRadioButton yellowJRadioButton;
   private JRadioButton blackJRadioButton; 
   private ButtonGroup colorRadioGroup;




   //Aqui é o grupo radioGroup do tipo ButtonGroup
   private ButtonGroup radioGroup; // buttongroup to hold radio buttons (grupo de botões para segurar botões de opção)
 

   // RadioButtonFrame constructor adds JRadioButtons to JFrame
   public RadioButtonFrame() // Aqui é o construtor
   {
      super("RadioButton Test");// Aqui é o titulo
      setLayout(new FlowLayout()); // Definição do layout responsivo

      textField = new JTextField("Watch the font style change", 25); //Definido um novo objeto do tipo JTextField, é o que aparecerá no campo input(caixa de escrita)
      add(textField); // add textField to JFrame

      // create radio buttons (criar botões de opção) // Aqui está definindo os botões
      plainJRadioButton = new JRadioButton("Plain", true); // Aqui está definindo o plain como já marcado, já selecionado, ao rodar o código(true)
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      add(plainJRadioButton); // add plain button to JFrame (adicionar botão simples ao JFrame)
      add(boldJRadioButton); // add bold button to JFrame (adicionar botão em negrito ao JFrame)
      add(italicJRadioButton); // add italic button to JFrame (adicionar botão itálico ao JFrame)
      add(boldItalicJRadioButton); // add bold and italic button (adicionar botão negrito e itálico)

      blueJRadioButton = new JRadioButton("Blue", false); 
      redJRadioButton = new JRadioButton("Red", false);
      yellowJRadioButton = new JRadioButton("Yellow", false);
      blackJRadioButton = new JRadioButton("Black", true);
      add(blueJRadioButton); 
      add(redJRadioButton); 
      add(yellowJRadioButton); 
      add(blackJRadioButton);




      

      // create logical relationship between JRadioButtons (criar relacionamento lógico entre JRadioButtons) // Aqui está definindo o grupo deles o radio group
      radioGroup = new ButtonGroup(); // create ButtonGroup (criar ButtonGroup) // Aqui está definindo para que seja desmarcando os outros botões, ao selecionar outro botão
      radioGroup.add(plainJRadioButton); // add plain to group (adicionar simples ao grupo)
      radioGroup.add(boldJRadioButton); // add bold to group (adicionar negrito ao grupo)
      radioGroup.add(italicJRadioButton); // add italic to group (adicionar itálico ao grupo)
      radioGroup.add(boldItalicJRadioButton); // add bold and italic (adicione negrito e itálico)


      colorRadioGroup = new ButtonGroup(); 
      colorRadioGroup.add(blueJRadioButton);
      colorRadioGroup.add(redJRadioButton); 
      colorRadioGroup.add(yellowJRadioButton);
      colorRadioGroup.add(blackJRadioButton);



      // create font objects (criar objetos de fonte) // Aqui está definindo as fontes
      plainFont = new Font("Serif", Font.PLAIN, 14);
      boldFont = new Font("Serif", Font.BOLD, 14);
      italicFont = new Font("Serif", Font.ITALIC, 14);
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
      textField.setFont(plainFont); // Aqui está definindo o texto como plano inicialmente 

      blueColor = new Color(0,0,255);
      redColor = new Color (255,0,0);
      yellowColor = new Color (255,255,0);
      blackColor = new Color (0,0,0);




      // register events for JRadioButtons (registrar eventos para JRadioButtons) // Aqui está definindo as variaveis, os escutadores, no construtor está definindo direto a ação
      plainJRadioButton.addItemListener(
         new RadioButtonHandler(plainFont));
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont));
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont));
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont));


      blueJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blueColor));
      redJRadioButton.addItemListener(
         new ColorRadioButtonHandler(redColor));
      yellowJRadioButton.addItemListener(
         new ColorRadioButtonHandler(yellowColor));
      blackJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blackColor));




   } // Aqui fecha o construtor RadioButtonFrame()

   // private inner class to handle radio button events (classe interna privada para lidar com eventos de botão de opção)
   //Aqui é a subclasse está implementandno o ItemListemr que é o escutador
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // font associated with this listener (fonte associada a este ouvinte) // Aqui é variável

      public RadioButtonHandler(Font f)
      {
         font = f; // Aqui irá receber o valor de paramento que o usuário clicar
      } 
   
      // handle radio button events (lidar com eventos de botão de opção)
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setFont(font); // Aqui defini a fonte do textField
      } 
   }// Aqui fecha a class private RadioButtonHandler


   private class ColorRadioButtonHandler implements ItemListener 
   {
      private Color color;

      public ColorRadioButtonHandler(Color c)
      {
         color = c;
      } 
   
      
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setForeground(color); 
      } 
   }

  
} // Aqui fecha a class public RadioButtonFrame


