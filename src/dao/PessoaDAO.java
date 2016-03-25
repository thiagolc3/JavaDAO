/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lsfo
 */
public class PessoaDAO {
    
    public boolean inserir(Pessoa p) throws ClassNotFoundException, SQLException {

        FabricaConexoes fabrica = new FabricaConexoes();
        
        PreparedStatement stmt = fabrica.Conexao().prepareStatement(
                "insert into pessoa"
                        + "(nome, email, cpf, telefone, sexo, datanascimento)"
                        + "VALUES (?,?,?,?,?,?);"
        );
        
//INSERT INTO agenda (pessoa) VALUES (?)
        
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEmail());
        stmt.setString(3, p.getCpf());
        stmt.setString(4, p.getTelefone());
        stmt.setString(5, p.getSexo());
        stmt.setDate  (6, p.getDataNascimento());
       
        return stmt.execute();
    }
}
