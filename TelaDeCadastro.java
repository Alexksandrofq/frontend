// Aqui importa as biblitecas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

// Aqui está definindo a classe TelaDeCadastro que está herdando do JFrame
public class TelaDeCadastro extends JFrame
{   //Aqui está declarando as váriaveis 
    private final JLabel lblNome;
    private final JTextField txtNome;

    private final JLabel lblEmail;
    private final JTextField txtEmail;

    private final JLabel lblSenha;
    private final JPasswordField txtSenha;

    private final JButton btnCadastrar;

    private final JLabel lblNotificacoes;

    // Aqui define o construtor TelaDeCadastro
    public TelaDeCadastro() 
    {
        super("Tela De Cadastro");// Aqui Declara o título da aba
        setLayout(new GridLayout(4,2,5,5));// Aqui define o layout, linhas, colunas, 

        lblNome = new JLabel("Nome:");// Declaração de váriavel
        add(lblNome);
        txtNome = new JTextField(10);
        add(txtNome); //Adicione a váriavel

        lblEmail = new JLabel("Email:");
        add(lblEmail);
        txtEmail = new JTextField(10);
        add(txtEmail);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);
        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        // Aqui define o método que adiciona o escutador da ação 
        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                // Aqui define o método actionPerformed, nele foi definido as mensagens de notificações
                /**trim = remove os espaços em branco, setHtmlFormat = para deixa em formato html e quabra a mensagem, length = contador de caracteres*/
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente."));
                        txtNome.requestFocus();
                        return;
                    }
                    if (txtEmail.getText().trim().length() <=0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um email e tente novamente."));
                        txtEmail.requestFocus();
                        return;
                    }
                    // Aqui está transformando a senha em uma string, utilizando o valueOf
                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha para o cadastro. Por favor, digite uma senha e tente novamente."));
                        txtSenha.requestFocus();
                        return;
                    }
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtEmail.getText() + "';";
                        Statement stmSqlEmail = conexao.createStatement();
                        ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
                        if (rstSqlEmail.next()) {
                            lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digie outro email e tente novamente."));
                        } else {
                            lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro."));
                            String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtNome.getText() + "', '" + txtEmail.getText() + "', '" + String.valueOf(txtSenha.getPassword()) + "');";
                            Statement stmSqlCadastrar = conexao.createStatement();
                            stmSqlCadastrar.addBatch(strSqlCadastrar);
                            stmSqlCadastrar.executeBatch();
                            lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso."));
                        }
                        stmSqlEmail.close();
                    } catch (Exception e) {
                        lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente."));
                        System.err.println("Erro:" + e);
                    }// Aqui fecha o catch

                }// Aqui fecha o método actionPerformed

            }// Aqui fecha o novo objeto ActionListener

        );// Aqui fecha o parâmetro do addActionListener
        
        // Aqui define a width(largura) height(altura) e visibilidade 
        setSize(250, 600);
        setVisible(true);

    }// Aqui fecha o construtor TelaDeCadastro

    // Aqui Define o método html
    private String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }// Aqui fecha o método html

    // Aqui está definindo o método executor main, com 1 parâmentro, tipo argumento de matriz string, sem retorno, estático e será importado 
    public static void main (String[] args) {
        TelaDeCadastro appTelaDeCadastro = new TelaDeCadastro();// Declaração de variável 
        appTelaDeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);// Aqui Define o fechamento padrão, sair ao fechar 
    }// Aqui fecha o método executor

}// Aqui fecha a classe TelaDeCadastro
