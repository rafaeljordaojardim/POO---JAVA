package com.fatec.mogiMirim.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class JDBCConnection {


        private Connection con = null;

        private String hostName = null;
        private String userName = null;
        private String password = null;
        private String url = null;
        private String jdbcDriver = null;
        private String dataBaseName = null;
        private String dataBasePrefix = null;
        private String dabaBasePort = null;

    public JDBCConnection() {
        super();

        /**
         *Os dados setados abaixo servem para uma conexão em MySQL.
         *Altere de acordo com seu BD.
         *Aconselhamos carregar estes dados de um arquivo.
         */
        //"jdbc: mysql:/localhost:3306/meu_bd";
        hostName = "localhost";
        userName = "root";
        password = "P@ssw0rd";
        dataBaseName = "teste";
        dataBasePrefix = "jdbc:mysql:/";
        dabaBasePort = "3306";

       //  = dataBasePrefix + hostName + ":"+dabaBasePort+"/" + dataBaseName + "/";
        url = "jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC";

        /**
         *Exemplo de um URL completo para MySQL:
         *a concatenação acima deve ficar algo como:
         *jdbc:'mysql:/localhost:3306/meu_bd'
         */

    }


    /**
     *Retorna uma java.sql.Connection.
     *@return con
     */


    public Connection getConnection() {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, userName, password);
            } else if (con.isClosed()) {
                con = null;
                return getConnection();
            }
        } catch (ClassNotFoundException e) {

            //TODO: use um sistema de log apropriado.

            e.printStackTrace();
        } catch (SQLException e) {

            //TODO: use um sistema de log apropriado.

            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                e.printStackTrace();
            }
        }
    }

}
