/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author lsfo
 */
public class Categoria {

    private String nome;
    private int classe;
    
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setClasse(int classe){
        this.classe = classe;
    }
    
    public int getClasse(){
        return this.classe;
    }
}
