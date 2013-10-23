/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

/**
 *
 * @author 31200222
 */

public class CartaoCredito{
    
    private int numeroDoCartao;
    private String senha;
    private String nomeTitular;
    private String codigoSeguranca;
    private String validade;
    private String bandeira;
    
    public CartaoCredito(int numeroDoCartao, String senha, String nomeTitular, String codigoSeguranca, String validade, String bandeira){
        this.numeroDoCartao = numeroDoCartao;
        this.senha = senha;
        this.nomeTitular = nomeTitular;
        this.codigoSeguranca = codigoSeguranca;
        this.validade = validade;
        this.bandeira = bandeira;
    }
}
