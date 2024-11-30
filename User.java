package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    public Connection conectarBD() {  // (1) Início do método conectarBD
        Connection conn = null;  // (2) Inicialização da conexão
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();  // (3) Carregamento do driver
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";  // (4) Montagem da URL
            conn = DriverManager.getConnection(url);  // (5) Tentativa de conexão
        } catch (Exception e) {  // (6) Tratamento de exceção
        }
        return conn;  // (7) Retorno da conexão (null ou estabelecida)
    }

    public String nome = "";  // (8) Declaração de variável global nome
    public boolean result = false;  // (9) Declaração de variável global result

    public boolean verificarUsuario(String login, String senha) {  // (10) Início do método verificarUsuario
        String sql = "";  // (11) Inicialização da variável SQL
        Connection conn = conectarBD();  // (12) Chamada do método conectarBD
        sql += "select nome from usuarios ";  // (13) Construção da query
        sql += "where login = " + "'" + login + "'";  // (14) Inserção do login
        sql += " and senha = " + "'" + senha + "';";  // (15) Inserção da senha
        try {  // (16) Início do bloco try
            Statement st = conn.createStatement();  // (17) Criação do Statement
            ResultSet rs = st.executeQuery(sql);  // (18) Execução da query
            if (rs.next()) {  // (19) Verificação do resultado
                result = true;  // (20) Atualização do resultado
                nome = rs.getString("nome");  // (21) Recuperação do nome
            }
        } catch (Exception e) {  // (22) Tratamento de exceção
        }
        return result;  // (23) Retorno do resultado
    }
} // (24) Fim da classe
