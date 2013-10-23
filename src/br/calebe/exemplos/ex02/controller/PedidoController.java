/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex02.controller;

/**
 *
 * @author 31200222
 */
import br.calebe.exemplos.ex01.Pedido;
import br.calebe.exemplos.ex02.EJBStatelessPedidoInterface;
import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;

public class PedidoController implements EJBStatelessPedidoInterface {
    
    private EJBStatelessPedidoInterface ejb;

    public PedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        ejb = (EJBStatelessPedidoInterface) ctx.lookup("ejb/EJBStatelessExemplo");
    }

    @Override
    public String consultarStatus(Pedido pedido) {
        return ejb.consultarStatus(pedido);
    }
}