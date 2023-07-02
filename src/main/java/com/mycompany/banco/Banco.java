package com.mycompany.banco;

import java.util.Scanner;

public class Banco {
    Scanner ms = new Scanner(System.in);
    Scanner msDados = new Scanner(System.in);
    Scanner msCadastro = new Scanner(System.in);
    Scanner msDigitos = new Scanner(System.in);
    Scanner msOperacao = new Scanner(System.in);
    
    int resposta;
    int login;
    String nomeLogin;
    String senhaLogin;
    int contLogin = 3;
    String outraOperacao = "";
    
    public static void main(String[] args) {
        Banco banco = new Banco();
        
        System.out.println("Realize um cadastro se for seu primeiro acesso.");
        banco.LoginCadastro();
        
    }
    
    public void LoginCadastro(){
        Banco banco = new Banco();
        
        int contCadastro = 0;
        
        String n = "", c = "", e = "", cd = "", t = "", s = "";
        
        for (int i = 0; i < 20; i++) {
            if(contLogin != 0){
                System.out.println("(1) Fazer login (2) Realizar Cadastro (3) Sair");
                banco.login = banco.ms.nextInt();

                if(banco.login == 1){
                    do{System.out.println(+contLogin+" chances de acerto");
                        System.out.println("Nome completo ou email");
                        nomeLogin = banco.msDados.nextLine();
                        System.out.println("Senha");
                        senhaLogin = banco.msDados.nextLine();

                        if((nomeLogin.equals(Cliente.nomeCompleto) || nomeLogin.equals(Cliente.email)) && senhaLogin.equals(Cliente.senha)){
                            banco.Operacoes(c, n, s, t, cd, e);
                            break;
                        }else{
                            System.out.println("Informações inválidas!");
                            contLogin--;
                        }
                    }while(contLogin != 0);
                }else if((banco.login == 2) && (contCadastro < 1)){
                    System.out.println("Digite seus dados\nNome completo: ");
                    n = banco.msCadastro.nextLine();
                    System.out.println("CPF: ");
                    c = banco.msCadastro.nextLine();
                    System.out.println("Email: ");
                    e = banco.msCadastro.nextLine();
                    System.out.println("Cidade: ");
                    cd = banco.msCadastro.nextLine();
                    System.out.println("Telefone ou Celular: ");
                    t = banco.msCadastro.nextLine();
                    System.out.println("Cadastre uma senha: ");
                    s = banco.msCadastro.nextLine();
                    contCadastro++;

                    banco.Operacoes(c, n, s, t, cd, e);
                }else if(banco.login == 3){
                    System.out.println("Até mais!");
                    break;
                }
            }else{
                System.out.println("Conta bloqueada!");
                break;
            }
        }
        
    }
    
    public void Operacoes(String c, String n, String s, String t, String cd, String e){
        Banco banco = new Banco();
        CartaoDebito clienteDebito = new CartaoDebito(c, n, s, t, cd, e, 2000);
        CartaoCredito clienteCredito = new CartaoCredito(c, n, s, t, cd, e, 2000);
        
        int digito;
        int contOp = 0;
        
        for (int i = 0; i < 20; i++) {
            
            if(contOp == 0){
                contOp++;
                System.out.println("Olá, seja bem vindo ao nosso atendimento!");
                System.out.println("Para realizar alguma operação digite:");
                System.out.println("(1) Para Cartão Débito ou (2) Para Cartão de Crédito (3) Para finalizar operação");
                resposta = banco.ms.nextInt();
                
                if(resposta == 1){
                    System.out.println("1 - Saque\n2 - Depósito\n3 - Consulta Saldo\n4 - Consultar seu Dados\n5 - Alterar seus Dados");
                    digito = banco.msDigitos.nextInt();

                    switch (digito){
                        case 1 -> CartaoDebito.Saque();
                        case 2 -> CartaoDebito.Deposito();
                        case 3 -> CartaoDebito.ConsultaSaldo();
                        case 4 -> clienteDebito.ConsultaDados();
                        case 5 -> clienteDebito.AlterarDados();
                    }
                }else if(resposta == 2){
                    System.out.println("1 - Pagar Fatura\n2 - Parcelar Fatura\n3 - Consultar Fatura\n4 - Consultar seus Dados\n5 - Alterar seus Dados");
                    digito = banco.msDigitos.nextInt();

                    switch (digito){
                        case 1 -> CartaoCredito.PagaFatura();
                        case 2 -> CartaoCredito.ParcelarFatura();
                        case 3 -> CartaoCredito.ConsultaFatura();
                        case 4 -> clienteCredito.ConsultaDados();
                        case 5 -> clienteCredito.AlterarDados();
                    }
                }else if(resposta == 3){
                    System.out.println("Fim");
                    break;
                }
            }else{
                int digito2;
                
                System.out.println("Para realizar outra operação digite OUTRA, para sair digite SAIR");
                banco.outraOperacao = banco.msOperacao.nextLine();
                
                if(banco.outraOperacao.equalsIgnoreCase("SAIR")){
                    break;
                }else if (banco.outraOperacao.equalsIgnoreCase("OUTRA")){
                    System.out.println("(1) Para Cartão Débito ou (2) Para Cartão de Crédito (3) Para finalizar operação");
                    resposta = banco.ms.nextInt();

                    if(resposta == 1){
                        System.out.println("1 - Saque\n2 - Depósito\n3 - Consulta Saldo\n4 - Consultar seu Dados\n5 - Alterar seus Dados");
                        digito2 = banco.msDigitos.nextInt();

                        switch (digito2){
                            case 1 -> CartaoDebito.Saque();
                            case 2 -> CartaoDebito.Deposito();
                            case 3 -> CartaoDebito.ConsultaSaldo();
                            case 4 -> clienteDebito.ConsultaDados();
                            case 5 -> clienteDebito.AlterarDados();
                        }
                    }else if(resposta == 2){
                        System.out.println("1 - Pagar Fatura\n2 - Parcelar Fatura\n3 - Consultar Fatura\n4 - Consultar seus Dados\n5 - Alterar seus Dados");
                        digito2 = banco.msDigitos.nextInt();

                        switch (digito2){
                            case 1 -> CartaoCredito.PagaFatura();
                            case 2 -> CartaoCredito.ParcelarFatura();
                            case 3 -> CartaoCredito.ConsultaFatura();
                            case 4 -> clienteCredito.ConsultaDados();
                            case 5 -> clienteCredito.AlterarDados();
                        }
                    }else if(resposta == 3){
                        System.out.println("Fim");
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        
    }
    
}
