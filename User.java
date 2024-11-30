package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável pela verificação de usuário no banco de dados. Esta classe
 * contém métodos para conectar ao banco de dados e verificar se um usuário
 * existe com login e senha válidos.
 */
public class User {

    /**
     * Método responsável por conectar ao banco de dados. Estabelece uma conexão
     * com o banco MySQL utilizando as credenciais informadas.
     *
     * @return Connection objeto de conexão com o banco de dados.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Em caso de falha na conexão, nenhum retorno é dado.
        }
        return conn;
    }

    /**
     * Nome do usuário encontrado no banco de dados.
     */
    public String nome = "";

    /**
     * Resultado da verificação, indicando se o usuário foi encontrado.
     */
    public boolean result = false;

    /**
     * Método responsável por verificar se o login e a senha fornecidos são
     * válidos. Realiza uma consulta SQL no banco de dados para verificar se o
     * usuário existe.
     *
     * @param login O login do usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return boolean indicando se o usuário foi encontrado ou não.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Em caso de erro durante a execução da consulta, nenhum retorno é dado.
        }
        return result;
    }
}
