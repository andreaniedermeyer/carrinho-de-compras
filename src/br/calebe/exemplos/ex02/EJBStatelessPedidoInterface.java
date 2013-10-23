/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex02;

/**
 *
 * @author 31200222
 */
import br.calebe.exemplos.ex01.Pedido;
import javax.ejb.Remote;

@Remote
public interface EJBStatelessPedidoInterface {
    
    String consultarStatus(Pedido pedido);
}