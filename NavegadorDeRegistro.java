import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    // Aqui define o método como estático para não ter vazamento de memória
    public static void pesquisar() {
    try {
        if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl.senac` where `nome` like `%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%';";
            Statement stmSqlPesquisa = conexao.createStatement();
            ResultSet rtsSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rtsSqlPesquisa.next()) {
                lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram0 encontrado(s) resultado(s)."));
                txtId.setText(rtsSqlPesquisa.getString("id"));
                txtNome.setText(rtsSqlPesquisa.getString("nome"));
                txtEmail.setText(rtsSqlPesquisa.getString("email"));
                txtUsuario = txtPesquisa.getText();// Aqui irá pegar o que for digitado na pequisa e colocado na váriavel usuario
                btnPesquisar.setEnabled(false);// Aqui irá deixa bloqueado o botão pesquisar até termina a pesquisa
            } else {
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            stmSqlPesquisa.close();
        }
    } catch (Exception e) {
        lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
        System.err.println("Erro:" + e);
        }
    }

}


