/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex02;

/**
 *
 * @author 31200222
 */
import br.calebe.exemplos.ex01.CartaoCredito;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EJBStatelessPagamentoInterface {

    String pagamentoRequisitado(CartaoCredito cartao, double totalPedido);
}
