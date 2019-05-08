package com.fatec.mogiMirim.Controller;

import com.fatec.mogiMirim.Model.Aluno;
import com.fatec.mogiMirim.connection.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AlunoJDBC {
    private JDBCConnection con;


    public AlunoJDBC(){
        con = new JDBCConnection();
    }

    public boolean salvarNome(Aluno aluno) throws SQLException {
        Connection connection = con.getConnection();
        String sql = String.format("insert into nomes (nome) values (?)");
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1,aluno.getNome());
        boolean i = stmt.execute();
        stmt.close();
        con.closeConnection();
        return i ;
    }
}
