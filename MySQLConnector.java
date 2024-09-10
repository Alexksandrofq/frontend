import java.sql.*; // Aqui está importando a biblioteca

// Aqui está definindo a classe MySQLConnector
public class MySQLConnector {
    // Aqui está definindo um método que pode gerar exceção 
    public static Connection conectar() throws Exception{
        String status = "Nada aconteceu ainda...";
        String mysqlHost = "127.0.0.1";
        String mysqlDb = "db_senac";
        String mysqlUser = "root";
        String mysqlPassword = "senac@02";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com sucesso!";
        } catch (Exception e) {
            status = "Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! Mensagem do servidor:" + e;
        }
       System.out.println(status);
        return conn;
    }

}
