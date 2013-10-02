/*Andréa Niedermeyer TIA: 31200222
 * Thabita Shimizu TIA: 31011810
 */

package br.calebe.exemplos.ex01;

public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        if (preco < 0 ){
            throw new IllegalArgumentException();
        }
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object obj) {
        return equals((Produto) obj);
    }

    public boolean equals(Produto obj) {
        return nome.equals(obj.nome);
    }
    
    public String getNome(){
                return nome;
        }
}
