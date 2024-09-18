import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDePesquisa extends JFrame
{
    private final JLabel lblPesquisa;
    private final JTextField txtPesquisa;

    private final JLabel lblId;
    private final JTextField txtId;

    private final JLabel lblNome;
    private final JTextField txtNome;

    private final JLabel lblEmail;
    private final JTextField txtEmail;

    private final JButton btnPesquisar;
    private final JButton btnPrimeiro;
    private final JButton btnAnterior;
    private final JButton btnProximo;
    private final JButton btnUltimo;

    private final JLabel lblNotificacoes;

    public TelaDePesquisa()
    {
        super("Tela de Pesquisa");
        setLayout(new GridLayout(7, 2, 5, 5));

        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2));

        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER);
        linha_lblPesquisa.add(lblPesquisa);

        btnPesquisar = new JButton("🔎");
        btnPesquisar.setToolTipText("Pesquisar");
        linha_lblPesquisa.add(btnPesquisar);

        add(linha_lblPesquisa);

        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 2));


        txtPesquisa = new JTextField(20);
        linha_inputPesquisa.add(txtPesquisa);

        add(linha_inputPesquisa);

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("ID:", SwingConstants.CENTER);
        linha_id.add(lblId);
        txtId = new JTextField(20);
        linha_id.add(txtId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:");
        linha_nome.add(lblNome);
        txtNome = new JTextField(20);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:");
        linha_email.add(lblEmail);
        txtEmail = new JTextField(20);
        linha_email.add(txtEmail);

        add(linha_email);


        JPanel linha_botoes = new JPanel(new GridLayout(3, 4));

        
        btnPrimeiro = new JButton("<<");
        linha_botoes.add(btnPrimeiro);

        btnAnterior = new JButton("<");
        linha_botoes.add(btnAnterior);
        btnProximo = new JButton(">");
        linha_botoes.add(btnProximo);
        btnUltimo = new JButton(">>");
        linha_botoes.add(btnUltimo);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(3, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtPesquisa.getText().trim() <= 0) {
                        lblNotificacoes
                    }









                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlPesquisa = "select * from `db_senac`.`tbl.senac` where `nome` like `&`" + txtPesquisa.getText() + "'& or `email` like '&" + txtPesquisa.getText() + "'&";
                        Statement stmSqlPesquisa = conexao.createStatement();
                        ResultSet rtsSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
                        if (rtsSqlPesquisa.next()) {
                            lblNotificacoes.setText(setHtmlFormat("Ops! Usúario não encontrado"));
                        } else {
                            lblNotificacoes.setText(setHtmlFormat("Pesquisa realizada com sucesso!"));
                            String strSqlPesquisar = "insert into `db_senac`.`tbl_senac` (`nome`, email) values ('" + txtNome.getText() + "','" + txtEmail.getText() + "');";
                            Statement stmSqlPesquisar = conexao.createStatement();
                            stmSqlPesquisa.addBatch(strSqlPesquisar);
                            stmSqlPesquisar.execute
                        }
                    }

                }
                
            }

         );



        setSize(250, 600);
        setVisible(true);    
        
    {
        private String setHtmlFormat(String strTexto) {
            return "<html><body>" + strTexto + "</body></html>";
        }
    }


    }
    public static void main(String[] args) {
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}