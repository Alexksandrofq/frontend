import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    // Aqui define o método como estático para não ter vazamento de memória
    public static void pesquisar() {
    // try =  tentar
    // Statement = declaração 
    try {
        if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%';";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
          
            if (rstSqlPesquisa.next()) {// Aqui a função vai começa se achar algo e vai ir pra frente
                rstSqlPesquisa.last();// Vai para o ùltimo
                int rowNumbers = rstSqlPesquisa.getRow(); //Pega a quantidade de linhas
                rstSqlPesquisa.first();// Volta para primeiro

                lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s)" + rowNumbers + "resultados."));
                txtId.setText(rstSqlPesquisa.getString("id"));
                txtNome.setText(rstSqlPesquisa.getString("nome"));
                txtEmail.setText(rstSqlPesquisa.getString("email"));
                txtUsuario = txtPesquisa.getText();// Aqui irá pegar o que for digitado na pequisa e colocado na váriavel usuario
                btnPesquisar.setEnabled(false);// Aqui irá deixa bloqueado o botão pesquisar até termina a pesquisa
                if (rowNumbers > 1) {// Se a quantiodade de linhas forem maior que 1, irá habilitar os botôes
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
                }
            } else {
                txtUsuario = txtPesquisa.getText();
                btnPesquisar.setEnabled(false);
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            stmSqlPesquisa.close();
        }
    } catch (Exception e) {
        lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
        System.err.println("Erro: " + e);
        }
    }
    public static void primeiroRegistro() {
        pesqusar();

    }
    public static void registroAnterior() {
        
    }
    public static void proximoRegistro() {
        try {
            String iaAtual = txtId.getText();
            limparCampos();
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximo = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtProximo.getText() + "%' or `email` like '%" + txtProximo.getText() + "%') and `id` > " + idAtual + " order by `id` asc';";
            Statement stmSqlProximo = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlProximo = stmSqlProximo.executeQueryo);
          
            if (rstSqlPesquisa.next())
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    public static void ultimoRegistro() {
        
    }

}


