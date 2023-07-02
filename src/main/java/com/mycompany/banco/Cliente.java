package com.mycompany.banco;

import java.util.Scanner;

public class Cliente {
    static Scanner alterar = new Scanner(System.in);
    static Scanner ms = new Scanner(System.in);
    
    public static String CPF;
    public static String nomeCompleto;
    public static String senha;
    public static String telefone;
    public static String cidade;
    public static String email;
    static int alt = 0;
    static String resposta = "";
    
    public Cliente(String c, String n, String s, String t, String cd, String e){
        CPF = c;
        nomeCompleto = n;
        senha = s;
        telefone = t;
        cidade = cd;
        email = e;
    }
    
    protected void ConsultaDados(){
        System.out.println("Nome: "+nomeCompleto+"\nE-mail: "+email+"\nTelefone: "+telefone+"\nCPF: "+CPF+"\nCidade: "+cidade);
    }
    
    protected void AlterarDados(){
        System.out.println("Deseja alterar qual informação?\n1 - Nome\n2 - E-mail\n3 - Telefone\n4 - CPF\n5 - Cidade\n6 - Cancelar");
        alt = alterar.nextInt();
        
        switch(alt){
            case 1 -> {
                System.out.println("Digite seu Nome Completo: ");
                resposta = ms.nextLine();
                nomeCompleto = resposta;
            }
            case 2 -> {
                System.out.println("Digite seu E-mail: ");
                resposta = ms.nextLine();
                email = resposta;
            }
            case 3 -> {
                System.out.println("Digite seu Telefone: ");
                resposta = ms.nextLine();
                telefone = resposta;
            }
            case 4 -> {
                System.out.println("Digite seu CPF: ");
                resposta = ms.nextLine();
                CPF = resposta;
            }
            case 5 -> {
                System.out.println("Digite seu Cidade: ");
                resposta = ms.nextLine();
                cidade = resposta;
            }
            case 6 -> {
                break;
            }
        }
    }
}
