/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lsfo
 */
public class PessoaDAO {

    private final Connection banco;

    public PessoaDAO() throws ClassNotFoundException, SQLException {
        FabricaConexoes fabrica = new FabricaConexoes();
        banco = fabrica.Conexao();
    }

    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws SQLException, Throwable
    {
        try {
            banco.close();
        } finally {
            super.finalize();
        }
    }
    
    public boolean inserir(Pessoa p) throws ClassNotFoundException, SQLException {

        PreparedStatement stmt = banco.prepareStatement(
                "insert into pessoa"
                        + "(nome, email, cpf, telefone, sexo, datanascimento)"
                        + "VALUES (?,?,?,?,?,?);"
        );

        java.util.Date data = p.getDataNascimento();
        java.sql.Date dataSQL = new java.sql.Date(data.getTime());        
        
        stmt.setString  (1, p.getNome());
        stmt.setString  (2, p.getEmail());
        stmt.setString  (3, p.getCpf());
        stmt.setString  (4, p.getTelefone());
        stmt.setBoolean (5, p.getSexo());
        stmt.setDate    (6, dataSQL);

        return stmt.execute();
    }
}
