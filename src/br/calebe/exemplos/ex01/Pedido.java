/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

/**
 *
 * @author 31200222
 */
import br.calebe.exemplos.ex02.controller.PedidoController;
import java.util.ArrayList;
import java.util.List;


public class Pedido {
    
    private PedidoController controller;
    private List<ItemPedido> itens;
    private int idPedido;
    private String status;
    private String dataPedido;
    private double totalPedido;
 
    
    public Pedido(int idPedido, String dataPedido) throws Exception{
        List<ItemPedido> itens = new ArrayList<>();
        this.idPedido = idPedido;
        this.status = "Aguardando Pagamento";
        this.dataPedido = dataPedido;
        this.totalPedido = 0;
        controller = new PedidoController();
    }
    
    public void addProdutoPedido(ItemPedido i){
        itens.add(i);
    }
    
    public void removeProdutoPedido(ItemPedido i){
         if(!buscarProdutoPedido(i)){
            System.out.println("Produto inexistente");
        }
        else 
            itens.remove(i);
    }

    public double getTotalPedido(){
        if (itens.isEmpty()) 
            return 0;
        else{
            for(ItemPedido item: itens)
                totalPedido += item.getValorUnitario() * item.getQuantidadeProduto();
        }
        return totalPedido;
    }
    
    public boolean buscarProdutoPedido(ItemPedido i){
          for(ItemPedido item: itens)  
              if(item.equals(i))
                  return true;
          return false;
    }
    
    public void run(double totalPedido) {
        status = controller.pagamentoRequisitado(getCartao(), totalPedido);
    }
    
    public String getAnswer() {
        return status;
    }
}