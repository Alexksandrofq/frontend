import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

    private final JTextField textField1;
    private final JTextField textField2;

    private final JLabel label1;
    private final JLabel label2; 

    private final JButton btnCalcular;
    private final JLabel lblNotificacao;
    
    public Calculator()
    {
      /**
       * //row:3, cols:2, hgap:5, hgap:5
       * linha, coluna,
       */
       super("Calculadora de soma"); //Aqui é o título
       setLayout(new GridLayout(3,2,5,5)); //Aqui está difinido o layout

       /**
        * Criação das colunas/ linhas e do butão
        */
 
       label1 = new JLabel("Digite o número 1:", SwingConstants.RIGHT);
       add(label1);
       textField1 = new JTextField(10); 
       add(textField1); 
 
       label2 = new JLabel("Digite o número 2:", SwingConstants.RIGHT);
       add(label2);
       textField2 = new JTextField(10);
       add(textField2); 

       btnCalcular = new JButton("Calcular");
       add(btnCalcular);

       lblNotificacao = new JLabel ("Resultado:");
       add(lblNotificacao);
       
       
       TextFieldHandler handler = new TextFieldHandler();
       btnCalcular.addActionListener(handler);
    }
 
    private class TextFieldHandler implements ActionListener 
    {
       
       @Override 
       public void actionPerformed(ActionEvent event)
       {
        
         /**
          * gettext: pegar o texto
          * trim: remover os espaços 
          *length: conta os caracteres 
          */
         if (textField1.getText().trim().length() == 0) {
            //notificar usuário que o campo 1 está vazio
            lblNotificacao.setText("O campo 1 está vazio");
            textField1.requestFocus();
         } else {
            if (textField2.getText().trim().length() == 0) {
               //notificar usuário que o campo 2 está vazio
               lblNotificacao.setText("O campo 2 está vazio");
               textField1.requestFocus();
            } else {
               //aqui será feita a soma
               try {
                  int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());             
                  lblNotificacao.setText(String.format("Resultado: %s", soma));
               } catch (Exception e) {
                  lblNotificacao.setText("<html><body>Ops! Parece que foi digitado algo errado, favor revisar a digitação, pois pode ser digitado apenas números inteiros.</body></html>");
               }
            }
         }       
      }
    }
    public static void main(String[] args)
    { 

        Calculator calculator = new Calculator(); 
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        calculator.setSize(450, 350); //Width, height
        calculator.setVisible(true); 
    } 
}
