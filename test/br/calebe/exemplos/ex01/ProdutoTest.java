/*Andréa Niedermeyer TIA: 31200222
 * Thabita Shimizu TIA: 31011810
 */

package br.calebe.exemplos.ex01;

import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author 31200222
 */
public class ProdutoTest {
   
    
    @Test
    public void criarProduto(){
        String nome = "Enciclopedia";
        Double preco = 150.99;
        Produto prod = new Produto(nome, preco);
        Assert.assertEquals(preco, prod.getPreco(),0d);
    }
    
    @Test
    public void verificarProduto(){
        Produto prod1 = new Produto("Enciclopedia",150.99);
        Produto prod2 = new Produto("Enciclopedia",150.99);
        Assert.assertEquals(prod1, prod2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nomeVazio(){
        Produto prod1 = new Produto(" ", 150.99);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void precoInvalido(){
        Produto prod1;
        prod1 = new Produto("Enciclopedia", -150.00);
    }
}
