import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    // Aqui define o método como estático para não ter vazamento de memória
    public static void pesquisar() {
    // try =  tentar
    // Statement = declaração 
    try {
        if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
            limparCampos("");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
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
                btnHistorico.setEnabled(true);
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
        try {
            limparCampos("Você está no primeiro registro.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                txtId.setText(rstSqlPesquisa.getString("id"));
                txtNome.setText(rstSqlPesquisa.getString("nome"));
                txtEmail.setText(rstSqlPesquisa.getString("email"));
                btnPesquisar.setEnabled(false);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtUsuario = txtPesquisa.getText();
                btnPesquisar.setEnabled(false);
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            stmSqlPesquisa.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }

    }
    public static void registroAnterior() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("Registro anterior posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` < " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao primeiro registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        } 
        
    }
    public static void proximoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("Próximo registro posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
          
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);

            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
            
        }
        
    }
    public static void ultimoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
          
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
            
        }
        
    }

}


