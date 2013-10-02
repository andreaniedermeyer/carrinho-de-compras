package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        Assert.assertEquals(0,carrinho.numeroDeProdutos());
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Assert.assertEquals(1,carrinho.numeroDeProdutos());
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Assert.assertEquals(2, carrinho.numeroDeProdutos());
        Assert.assertTrue(carrinho.buscarProduto(livro));
        Assert.assertTrue(carrinho.buscarProduto(deitel));
   
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        Assert.assertEquals(original, copia);
    }
    
    @Test
        public void listaTodosProdutos() throws CarrinhoVazioExpected {
                List<Produto> produtos = new ArrayList<>();
                Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
                produtos.add(livro);
                produtos.add(deitel);
                Assert.assertEquals(2, carrinho.numeroDeProdutos());
                Assert.assertEquals(produtos, carrinho.getList());
        }
    
    
    @Test
        public void removendoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Assert.assertTrue(carrinho.remove(livro));
                Assert.assertEquals(0, carrinho.numeroDeProdutos());
	}
        
        @Test(expected = CarrinhoVazioExpected.class)
        public void removendoUmProdutoInexistente() throws CarrinhoVazioExpected{
                Produto deitel2 = new Produto("Java: como programar", 150.00);
                Assert.assertFalse(carrinho.remove(deitel2));
        }
        
        @Test
        public void calculaTotalPedido() throws CarrinhoVazioExpected{
                Produto livro = new Produto("Java em 24 horas", 60.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 120.00);
		carrinho.add(deitel);
                Produto livroInfantil = new Produto("A branca de neve", 25.00);
                carrinho.add(livroInfantil);
                Assert.assertEquals(205.00, carrinho.calcularTotalPedido());
                carrinho.remove(deitel);
                Assert.assertEquals(85.00, carrinho.calcularTotalPedido());
                carrinho.add(deitel);
                Assert.assertEquals(205.00, carrinho.calcularTotalPedido());
        }

}
