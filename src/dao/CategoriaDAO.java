/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lsfo
 */
public class CategoriaDAO {
    
    private final Connection banco;
    
    public CategoriaDAO() throws ClassNotFoundException, SQLException{
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

    public int inserir(Categoria c) throws SQLException{

        PreparedStatement stmt = banco.prepareStatement("INSERT INTO categoria "
                + "(nome, classe) "
                + "VALUES(?,?)");
        
        stmt.setString(1,c.getNome());
        stmt.setInt(2, c.getClasse());
        
        return stmt.executeUpdate();
    }
    
    public int remover(Categoria c) throws SQLException{
        
        PreparedStatement stmt = banco.prepareStatement("DELETE FROM categoria "
                + "WHERE nome LIKE ?");
        
        stmt.setString(1, "%"+c.getNome()+"%");
        
        return stmt.executeUpdate();
    }
    
    public ArrayList listar() throws SQLException{
        
        PreparedStatement stmt = banco.prepareStatement("SELECT * FROM categoria");
        ArrayList <Categoria> lista = new ArrayList<>();
        
        ResultSet resultado = stmt.executeQuery();
              
        while(resultado.next()){
            Categoria cat = new Categoria();
            
            cat.setNome(resultado.getString("nome"));
            cat.setClasse(resultado.getInt("classe"));
            
            lista.add(cat);
        }
        
        return lista;
    }
}
