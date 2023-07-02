package com.mycompany.banco;

import java.util.Scanner;

public class CartaoCredito extends Cliente {
    static Scanner ms3 = new Scanner(System.in);
    
    private static double faturaCliente;
    static double pagamento;
    static int parcela;
    
    public CartaoCredito(String c, String n, String s, String t, String cd, String e, double fatura) {
        super(c, n, s, t, cd, e);
        faturaCliente = fatura;
    }
    
    public static void PagaFatura(){
        System.out.println("Fatura atual: "+faturaCliente);
        pagamento = ms3.nextDouble();
        
        if(pagamento == faturaCliente){
            faturaCliente -= pagamento;
            System.out.println("Fatura paga!");
        }else if(pagamento < faturaCliente){
            faturaCliente -= pagamento;
            System.out.println("Valor restante à pagar: "+faturaCliente);
        }else if(pagamento > faturaCliente){
            System.out.println("Erro! Valor maior, insira novamente!");
        }
    }
    
    public static void ParcelarFatura(){
        System.out.println("Fatura atual: "+faturaCliente);
        System.out.println("Possibilidade de 6 vezes, digite a quantidade de parcelas!");
        parcela = ms3.nextInt();
        
        switch(parcela){
            case 1 -> System.out.println("À Vista! "+faturaCliente);
            case 2 -> { 
                double duasVezes = faturaCliente / 2;
                System.out.println("2 parcelas: "+duasVezes);
            }
            case 3 -> { 
                double tresVezes = faturaCliente / 3;
                System.out.println("3 parcelas: "+tresVezes);
            }
            case 4 -> { 
                double quatroVezes = faturaCliente / 4;
                System.out.println("4 parcelas: "+quatroVezes);
            }
            case 5 -> { 
                double cincoVezes = faturaCliente / 5;
                System.out.println("5 parcelas: "+cincoVezes);
            }
            case 6 -> { 
                double seisVezes = faturaCliente / 6;
                System.out.println("6 parcelas: "+seisVezes);
            }
        }
    }
    
    public static void ConsultaFatura(){
        System.out.println("Fatura Atual: "+faturaCliente);
    }
    
}
