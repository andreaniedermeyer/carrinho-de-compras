/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

/**
 *
 * @author 31200222
 */

import br.calebe.exemplos.ex02.controller.PagamentoController;

public class Pagamento {
    
    private PagamentoController controller;
    private CartaoCredito cartao;
    private String respostaTransacao;
    
    public Pagamento(CartaoCredito cartao) throws Exception {
        this.cartao = cartao;
        controller = new PagamentoController();
    }

    public void run(double totalPedido) {
        respostaTransacao = controller.pagamentoRequisitado(getCartao(), totalPedido);
    }
    
    public String getAnswer() {
        return respostaTransacao;
    }
    
    public CartaoCredito getCartao() {
        return cartao;
    }
    public void setCartao(CartaoCredito cartao) {
        this.cartao = cartao;
    }
    
    
}