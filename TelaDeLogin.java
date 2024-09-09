// Aqui importa as bibliotecas 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


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

    lblLogin = new JLabel("Login:"); // Declaração de váriavel, Login
    add(lblLogin);

    txtLogin = new JTextField(10); // Declaração de várivael, está definindo o tamanho da coluna
    add(txtLogin);

    lblSenha = new JLabel("Senha:"); // Declaração de várivael, senha
    add(lblSenha);

    txtSenha = new JPasswordField(10); // Declaração de váriavel, está definindo o tamanho da coluna
    add(txtSenha);

    btnEntrar = new JButton("Entrar"); // Declaração de váriavel, button
    add(btnEntrar);


    add(new JLabel(" "));
    lblNotificacoes = new JLabel("Notifiações"); // Declaração de váriavel notifacacoes
    add(lblNotificacoes);

    btnEntrar.addActionListener(
        // Aqui está definindo o novo objeto 
        new ActionListener() {
            @Override    
            // Aqui está definido o método actionPerformed     
            public void actionPerformed(ActionEvent event) { 
                try{
                    Connection conexao =  MySQLConnector.conectar();
                    String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtLogin.getText() + "' and `senha` = '" + String.valueOf(txtSenha.getPassword()) + "';";
                    Statement stmSqlLogin = conexao.createStatement();
                    ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
                    if (rstSqlLogin.next()) {
                        lblNotificacoes.setText(setHtmlFormat("Conectado com sucesso!"));
                    } else {
                        lblNotificacoes.setText(setHtmlFormat("Login e/ou senha não encontrados! Por favor, verifique o texto novamente"));
                    }
                    stmSqlLogin.close();   
                } catch (Exception e) { 
                    lblNotificacoes.setText(setHtmlFormat("Não foi possivel encontrar o login e/ou senha digitado/informado! Por favor, verifique o teste novamente. Veja o erro:" + e));  
                }

            }
        }
    );
    // Aqui está definindo o tamanho e visibilidade
    setSize(165, 200); 
    setVisible(true);   
}

private String setHtmlFormat(String strTexto) {
    return "<html><body>" + strTexto + "</body></html>";
}

//Aqui está definindo o método executor main, de 1 parâmetro, argumento, do tipo matriz de String, sem retorno(void), que é tipo estático(static), que será exportado(public)
    public static void main(String[] args) {
        // Aqui está declarando a variável 
        TelaDeLogin appTelaDeLogin = new TelaDeLogin(); 
        // Aqui está definindo o modo padrão de fechamento, sair ao fechar 
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}