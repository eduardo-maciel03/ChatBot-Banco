package com.mycompany.banco;

import java.util.Scanner;

public class CartaoDebito extends Cliente {
    static Scanner ms2 = new Scanner(System.in);
    
    private static double saldoCliente;
    static double saque;
    static double deposito;
    
    public CartaoDebito(String c, String n, String s, String t, String cd, String e, double saldo) {
        super(c, n, s, t, cd, e);
        saldoCliente = saldo;
    }

    public static void Saque(){
        System.out.println("Valor a sacar: ");
        saque = ms2.nextDouble();
        if(saque > saldoCliente){
            System.out.println("Saldo insuficiente");
        }else{
            saldoCliente -= saque;
            System.out.println("Saldo restante: "+saldoCliente);
        }
        
    }
    
    public static void Deposito(){
        System.out.println("Valor a depositar");
        deposito = ms2.nextDouble();
        if(deposito < 0){
            System.out.println("Valor inválido");
        }else{
            saldoCliente += deposito;
            System.out.println("Saldo atual: "+saldoCliente);
        }
    }
    
    public static void ConsultaSaldo(){
        System.out.println("Saldo atual: "+saldoCliente);
    }
    
}
