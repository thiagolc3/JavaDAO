/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author lsfo1
 */
public class Main {

    static Scanner tecla = new Scanner(System.in);
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {

        int op;
                do {                
                    System.out.println("\n\n*** Pessoas ***");
                    System.out.println("1-Inserir Pessoa");
                    System.out.println("2-Remover Pessoa");
                    System.out.println("3-Atualizar Pessoa");
                    System.out.println("4-Listar Pessoas");
                    System.out.println("5-Sair");
                    System.out.println("**********************");


                    System.out.print("Digite sua opção: ");
                    op = tecla.nextInt();
                    System.out.print('\n');

                    switch(op){
                        case 1: inserir(); break;
                        case 2: remover(); break;
                        case 3: atualizar(); break;
                        case 4: listar(); break;
                        case 5: break;
                    }
                } while (op!=5);
    }

    private static void inserir() throws ClassNotFoundException, SQLException, ParseException {
        Pessoa pessoa = new Pessoa();
        
        System.out.print("\nInsira nome: ");
        pessoa.setNome(tecla.next());
        
        System.out.print("Insira o email: ");
        pessoa.setEmail(tecla.next());
        
        System.out.print("Insira cpf: ");
        pessoa.setCpf(tecla.next());
        
        System.out.print("Insira o telefone: ");
        pessoa.setTelefone(tecla.next());
        
        System.out.print("Insira o sexo(m ou f): ");
        if("m".equals(tecla.next().substring(0, 1)))
            pessoa.setSexo(Boolean.TRUE);
        else
            pessoa.setSexo(Boolean.FALSE);
        
        System.out.print("Insira a data de nascimento no formato dd/mm/yyyy: ");        
        java.util.Date dataNasc = new SimpleDateFormat("dd/mm/yyyy").parse(tecla.next());
        pessoa.setDataNascimento(dataNasc);

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.inserir(pessoa);
    }

    private static void remover() {
        
    }

    private static void atualizar() {

    }

    private static void listar() {

    }
}
