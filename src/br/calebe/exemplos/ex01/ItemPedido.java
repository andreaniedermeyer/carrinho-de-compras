/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

/**
 *
 * @author 31200222
 */
public class ItemPedido {
    
    private Produto produto;
    private int quantidadeProduto;
    
    public ItemPedido(Produto produto, int quantidadeProduto){
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorUnitario() {
        return produto.getPreco();
    }

    public void setValorUnitario(double valorUnitario) {
        produto.setPreco(valorUnitario);
    }

}
