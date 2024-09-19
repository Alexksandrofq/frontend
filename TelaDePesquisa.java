// Aqui importa as bibliotecas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

// Aqui define a classe TelaDePesquisa que herderá do JFrame
public class TelaDePesquisa extends JFrame
{
    // Aqui há 14 váriaveis que serão manipuladas no construtor 
    public static JLabel lblPesquisa;
    public static JTextField txtPesquisa;

    public static JLabel lblId;
    public static JTextField txtId;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JButton btnPesquisar;
    public static JButton btnPrimeiro;
    public static JButton btnAnterior;
    public static JButton btnProximo;
    public static JButton btnUltimo;

    public static JLabel lblNotificacoes;

    public int tamanhoInputs = 20;

    public static String txtUsuario = "";

    // Aqui define o construtor TelaDePesquisa()
    public TelaDePesquisa()
    {
        super("Tela de Pesquisa");// Aqui define o título que aparecerá
        setLayout(new GridLayout(7, 2, 5, 5));// Aqui define as linhas. colunas, tamanho horizontal e vertical 

        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2)); // Declaração de váriavel
        /*JPanel = define a linha e coluna de cada variável*/

        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER);
        linha_lblPesquisa.add(lblPesquisa);

        btnPesquisar = new JButton("🔎");
        btnPesquisar.setToolTipText("Pesquisar");
        linha_lblPesquisa.add(btnPesquisar);

        /*add sozinho = está adicionando ao construtor */
        add(linha_lblPesquisa);

        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 2));


        txtPesquisa = new JTextField(tamanhoInputs);// Declaração de várivael 
        linha_inputPesquisa.add(txtPesquisa);// Aqui vai adicionar a linha_inputPesquisa

        add(linha_inputPesquisa);

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("ID:", SwingConstants.CENTER);
        linha_id.add(lblId);// Aqui vai adicionar a linha_id ao lblId
        txtId = new JTextField(tamanhoInputs);
        txtId.setEnabled(false);
        linha_id.add(txtId);// Aqui vai adicionar a linha_id ao txtId

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:");
        linha_nome.add(lblNome);
        txtNome = new JTextField(tamanhoInputs);
        txtNome.setEditable(false);
        linha_nome.add(txtNome);// Aqui vai adicionar a linha_nome

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:");
        linha_email.add(lblEmail);// Aqui vai adicionar a linha_email
        txtEmail = new JTextField(tamanhoInputs);
        txtEmail.setEditable(false);
        linha_email.add(txtEmail);// Aqui vai adicionar a linha_email

        add(linha_email);


        JPanel linha_botoes = new JPanel(new GridLayout(3, 4));

        
        btnPrimeiro = new JButton("<<");
        linha_botoes.add(btnPrimeiro);// Aqui vai adicionar a linha_botoes
        btnAnterior = new JButton("<");
        linha_botoes.add(btnAnterior);
        btnProximo = new JButton(">");
        linha_botoes.add(btnProximo);
        btnUltimo = new JButton(">>");
        linha_botoes.add(btnUltimo);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        // Aqui define o método que adiciona o escutador da ação 
        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtPesquisa.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente."));
                        txtPesquisa.requestFocus();// RequestFocus serve para conduzir o usuário a focar no campo de texto
                        return;
                    }
                    NavegadorDeRegistro.pesquisar();

                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

         );// Aqui fecha o parâmetro do método que adiciona o excutador da ação

        txtPesquisa.addKeyListener( //Escutador chave, iremos sobescrever, incluir no método KeyReleased que ja existe denro do objeto KeyAdapter
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) { //KeyListener serve para quando o usuário soltar
                    if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
                        btnPesquisar.setEnabled(true);
                    } else {
                        btnPesquisar.setEnabled(false);
                    }
                }
            }
        );

        setSize(250, 600);// Aqui define a width(largura) e height(altura)
        setVisible(true);// Aqui define a visibilidade, para aparecer a tela  
        txtPesquisa.requestFocus();  

    }// Aqui fecha o construtor TelaDePesquisa  

    // Aqui define o método para deixa a escrita da notificação em html
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    } 

    // Aqui define o método executor main, de 1 parâmetro, argumento do tipo matriz de string, sem retorno, estatico, que sera importado
    public static void main(String[] args) {
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }// Aqui fecha o método executor

}// Aqui fecha a classe TelaDePesqusa