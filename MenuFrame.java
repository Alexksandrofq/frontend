// Aqui est´pa importando as bibliotecas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Aqui está definindo a classe MenuFrame que stá herdando do JFrame
public class MenuFrame extends JFrame 
{ // Aqui está definindo as váriaveis que serão manipuladas no consrutor
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};  // Aqui está definindo os vetores  na matriz
   private final JRadioButtonMenuItem[] colorItems; // color menu items (itens do menu de cores)
   private final JRadioButtonMenuItem[] fonts; // font menu items (itens do menu de fontes)
   private final JRadioButtonMenuItem[] tamanhos;
   private final JCheckBoxMenuItem[] styleItems; // font style menu items (itens de menu de estilo de fonte)
   private final JLabel displayJLabel; // displays sample text (exibe texto de exemplo)
   private final ButtonGroup fontButtonGroup; // manages font menu items (gerencia itens do menu de fontes)
   private final ButtonGroup colorButtonGroup; // manages color menu items (gerencia itens de menu de cores)
   private final ButtonGroup tamanhoButtonGroup;
   private int style; // used to create style for font (usado para criar estilo para fonte)

   // no-argument constructor set up GUI (GUI de configuração de construtor sem argumentos)
   public MenuFrame() // Aqui está definindo o construtor
   {
      super("Using JMenus");  // Aqui está definindo o título   

      JMenu fileMenu = new JMenu("File"); // create file menu (criar menu de arquivo) // Declaração de variável
      fileMenu.setMnemonic('F'); // set mnemonic to F (definir mnemônico para F) // Aqui está definindo o método mnemonic que é alt + f para selecionar o File sem usar o mouse

      // create About... menu item (criar Sobre... item de menu)
      JMenuItem aboutItem = new JMenuItem("About..."); // Declaração de variável 
      aboutItem.setMnemonic('A'); // set mnemonic to A (definir mnemônico para A) // Aqui está definindo o método mnemonic que é alt + a para selecionar o About sem usar o mouse
      fileMenu.add(aboutItem); // add about item to file menu (adicionar sobre o item ao menu de arquivo)
      // Aqui invoca o Action Lisyener que é escutador
      aboutItem.addActionListener(
         new ActionListener() // Aqui está definindo o construtor
         {  
            // display message dialog when user selects About... (exibir caixa de diálogo de mensagem quando o usuário seleciona Sobre...)
            @Override
            public void actionPerformed(ActionEvent event) // Aqui define o método actionPerformed
            {
               JOptionPane.showMessageDialog(MenuFrame.this, // Aqui define a mensagem que aparecera ao clica em about 
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } // Aqui fecha o método
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); // create exit item (criar item de saída) // Declaração de variável
      exitItem.setMnemonic('x'); // set mnemonic to x (definir mnemônico para x)  Aqui está definindo o método mnemonic que é alt + x para selecionar o Exit sem usar o mouse
      fileMenu.add(exitItem); // add exit item to file menu (adicionar item de saída ao menu arquivo)
      exitItem.addActionListener( // Aqui definin o excutador 
         new ActionListener() // Aqui está definindo o construtor
         {  
            // terminate application when user clicks exitItem (encerrar o aplicativo quando o usuário clicar em exitItem)
            @Override
            public void actionPerformed(ActionEvent event) // Aqui define o método actionPerformed
            {
               System.exit(0); // exit application (sair do aplicativo)
            } // Aqui fecha o método   

         }// Aqui fecha o consrutor

      ); // Aqui fecha o escutador 

      JMenuBar bar = new JMenuBar(); // create menu bar (criar barra de menu) // Declaração de variável
      setJMenuBar(bar); // add menu bar to application (adicionar barra de menu ao aplicativo)
      bar.add(fileMenu); // add file menu to menu bar (adicionar menu de arquivo à barra de menu)

      JMenu formatMenu = new JMenu("Format"); // create format menu (criar menu de formato)
      formatMenu.setMnemonic('r'); // set mnemonic to r (definir mnemônico para r) // Aqui está definindo o método mnemonic que é alt + r para selecionar Format sem usar o mouse

      // array listing string colors (array listando cores de strings)
      String[] colors = {"Black", "Blue", "Red", "Green"}; // Aqui está definindo a matriz de String das cores com o vetores 

      JMenu colorMenu = new JMenu("Color"); // create color menu (criar menu de cores) // Declaração de variável
      colorMenu.setMnemonic('C'); // set mnemonic to C (definir mnemônico para C) // Aqui está definindo o método mnemonic que é alt + c para selecionar o Color sem usar o mouse

      // create radio button menu items for colors (criar itens de menu de botão de opção para cores)
      colorItems = new JRadioButtonMenuItem[colors.length]; // Declaração de variável que está definindo a quantidade de cores que está na matriz e só permite selecionar um item JRadioButtonMenuItem
      colorButtonGroup = new ButtonGroup(); // manages colors (gerencia cores) // Declaração de variável que está definindo o grupo 
      ItemHandler itemHandler = new ItemHandler(); // handler for colors (manipulador de cores) // Declaração de variável, que está definindo o manipulador

      // create color radio button menu items (criar itens de menu de botão de opção coloridos) // Criaçáo do laço de repetição 
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // create item (criar item) // Aqui está definindo o button que irá coloca o nome de cada vetor e só permite selecionar um item JRadioButtonMenuItem
         colorMenu.add(colorItems[count]); // add item to color menu (adicionar item ao menu de cores)
         colorButtonGroup.add(colorItems[count]); // add to group (adicionar ao grupo)
         colorItems[count].addActionListener(itemHandler); // Aqui está adicionando o excutador ActionListener
      }

      colorItems[0].setSelected(true); // select first Color item (selecione o primeiro item de cor) // Aqui está invocando o método Selected, para selecionar a primeira cor do vetor(black)

      formatMenu.add(colorMenu); // add color menu to format menu (adicionar menu de cores ao menu de formatação) // Aqui está definindo o método
      formatMenu.addSeparator(); // add separator in menu (adicionar separador no menu) // Aqui está definindo o método 

      // array listing font names (matriz listando nomes de fontes)
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"}; // Aqui a matriz fontNames está recebendo 3 vetores 
      JMenu fontMenu = new JMenu("Font"); // create font menu (criar menu de fontes)
      fontMenu.setMnemonic('n'); // set mnemonic to n (definir mnemônico para n) // Aqui está definindo o método mnemonic que é alt + n para selecionar o Font sem usar o mouse


      // create radio button menu items for font names (crie itens de menu de botão de opção para nomes de fontes)
      fonts = new JRadioButtonMenuItem[fontNames.length]; // Declaração de variável que está definindo a quantidade de fontes que está na matriz 
      fontButtonGroup = new ButtonGroup(); // manages font names (gerencia nomes de fontes) // Declaração de variável que está definindo o grupo 

      // create Font radio button menu items (criar itens de menu do botão de opção Fonte) // Laço de repetição
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]); // Declaração de variável , button 
         fontMenu.add(fonts[count]); // add font to font menu (adicionar fonte ao menu de fontes)
         fontButtonGroup.add(fonts[count]); // add to button group (adicionar ao grupo de botões)
         fonts[count].addActionListener(itemHandler); // Aqui está adicionando o excutador ActionListener
      } 

      fonts[0].setSelected(true); // select first Font menu item (selecione o primeiro item do menu Fonte)  // Aqui está invocando o método Selected, para selecionar a primeira fonte do vetor(serif)
      fontMenu.addSeparator(); // add separator bar to font menu (adicionar barra separadora ao menu de fontes)

      String[] styleNames = {"Bold", "Italic"}; // names of styles (nomes de estilos) // Aqui a matriz styleNames está recebendo 2 vetores 
      styleItems = new JCheckBoxMenuItem[styleNames.length]; // Declaração de variável que está definindo a quantidade de style, estilo, que está na matriz e permite selecionar os dois  
      StyleHandler styleHandler = new StyleHandler(); // style handler (manipulador de estilo)

      // create style checkbox menu items (criar itens de menu de caixa de seleção de estilo) //Laço de repetição
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // for style (para estilo) // declaração de variável, que a JCheckBoxMenuItem permite selecionar os dois
         fontMenu.add(styleItems[count]); // add to font menu (adicionar ao menu de fontes)
         styleItems[count].addItemListener(styleHandler); // Aqui está adicionando o excutador ItemListener
      }

      formatMenu.add(fontMenu); // add Font menu to Format menu (adicione o menu Fonte ao menu Formatar)
      bar.add(formatMenu); // add Format menu to menu bar (adicione o menu Formatar à barra de menu)
 
      formatMenu.addSeparator();

      int[] tamanhoint = {72, 52, 22}; 
      JMenu tamanhoMenu = new JMenu("Tamanho"); 
      tamanhoMenu.setMnemonic('T'); 

      tamanhos = new JRadioButtonMenuItem[tamanhoint.length]; 
      tamanhoButtonGroup = new ButtonGroup(); 


      for (int count = 0; count < tamanhos.length; count++) 
      {
         tamanhos[count] = new JRadioButtonMenuItem(String.valueOf(tamanhoint[count])); 
         tamanhoMenu.add(tamanhos[count]); 
         tamanhoButtonGroup.add(tamanhos[count]); 
         tamanhos[count].addActionListener(itemHandler); 
      }

      tamanhos[0].setSelected(true);
      formatMenu.add(tamanhoMenu);
      
      // set up label to display text (configurar rótulo para exibir texto) // Definição da escrita, cor, fonte e tamanho de ínicio 
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER); // Declaração de variável, que definie a mensagem "Sample Text" e ficará no centro
      displayJLabel.setForeground(colorValues[0]); // Aqui define a primeira cor será o vetor 0, black
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72)); // Aqui defini a fonte de começo que será serif, que sera plana do tamanho 72(size)
      
      getContentPane().setBackground(Color.CYAN); // set background (definir plano de fundo) // Aqui está definindo o contentpane que está invocando o método 
      add(displayJLabel, BorderLayout.CENTER); // add displayJLabel // Aqui irá adicionar e centralizar o layout
   } // Aqui fecha o construtor MenuFrame

   // inner class to handle action events from menu items (classe interna para lidar com eventos de ação de itens de menu)
   private class ItemHandler implements ActionListener // Aqui está definindo a classe ItemHandler que implementará / invocando o objeto ActionListener
   {
      // process color and font selections (cores de processo e seleções de fonte)
      @Override
      public void actionPerformed(ActionEvent event) // Aqui estpa definindo o método actionPerformed
      {
         // process color selection (processo de seleção de fonte) // Laço de repetição, irá verifica a cor que  estiver selecionado 
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } // Aqui fecha o laço de cor

         // process font selection (processo de seleção de fonte) // Laço de repetição, irá verifica se a fonte que estiver selecionado 
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         } // Aqui fecha o laço de fonte

         for (int count = 0; count < tamanhos.length; count++) 
         {
            if (event.getSource() == tamanhos[count])
            {
               int size = Integer.parseInt(tamanhos[count].getText());
               displayJLabel.setFont(displayJLabel.getFont().deriveFont((float) size));
            }
         }

         repaint(); // redraw application

      } // Aqui fecha o método actionPerformed

   } // Aqui fecha a classe ItemHandler

   // inner class to handle item events from checkbox menu items (classe interna para lidar com eventos de itens de itens de menu de caixa de seleção)
   private class StyleHandler implements ItemListener // Aqui está definindo a classe StyleHandler que implementará / invocando o objeto ItemListener
   {
      // process font style selections (processar seleções de estilo de fonte)
      @Override
      public void itemStateChanged(ItemEvent e) // Aqui está definindo o método  itemStateChanged, sem retorno
      {
         String name = displayJLabel.getFont().getName(); // current Font (nova fonte baseada nas preferências do usuário) 
         Font font; // new font based on user selections (nova fonte baseada nas seleções do usuário)

         // determine which CheckBoxes are checked and create Font (determinar quais CheckBoxes estão marcadas e criar Font) // Aqui está definindo o validador 
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint(); // redraw application (redesenhar aplicativo)

      } // Aqui fecha o método itemStateChanged

   } // Aqui fecha a classe StyleHandler

} // Aqui fecha a classe MenuFrame



