// Aqui importa as bibliotecas 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Aqui está definindo a classe TelaDeLogin que está herdando do JFrame
public class TelaDeLogin extends JFrame 
{

// Aqui está definindo as variáveis que serão manipuladas no construtor 
    private final JLabel lblLogin;
    private final JTextField txtLogin;

    private final JLabel lblSenha;
    private final JPasswordField txtSenha;

    private final JButton btnEntrar;

    private final JLabel lblNotificacoes;



// Aqui está definindo o construtor e dentro dele as variáveis
public TelaDeLogin() 
{
    
    super("Tela de Login"); // Aqui está definindo o título que aparecerá em cima 
    setLayout(new FlowLayout()); // Aqui para definir o layout, que será responsivo, por causa do flow

    lblLogin = new JLabel("Login:");
    add(lblLogin);

    txtLogin = new JTextField(10);
    add(txtLogin);

    lblSenha = new JLabel("Senha:");
    add(lblSenha);

    txtSenha = new JPasswordField(10);
    add(txtSenha);

    btnEntrar = new JButton("Entrar");
    add(btnEntrar);


    add(new JLabel(" "));
    lblNotificacoes = new JLabel("Notifiações");
    add(lblNotificacoes);

    setSize(150, 200);
    setVisible(true);

    MySQLConnector.conectar();
}

//Aqui está definindo o método executor main, de 1 parâmetro, argumento, do tipo matriz de String, sem retorno(void), que é tipo estático(static), que será exportado(public)
    public static void main(String[] args) {
        // Aqui está declarando a variável 
        TelaDeLogin appTelaDeLogin = new TelaDeLogin(); 
        // Aqui está definindo o modo padrão de fechamento, sair ao fechar 
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}