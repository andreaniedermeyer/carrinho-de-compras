package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

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
        assertArrayEquals(new Object[]{null}, new Object[]{menor});
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        assertEquals(2, carrinho.numeroDeProdutos());
        assertTrue(carrinho.buscarProduto(livro));
        assertTrue(carrinho.buscarProduto(deitel));
      /*  Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});*/
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{copia});
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
                assertEquals(2, carrinho.numeroDeProdutos());
                assertEquals(produtos, carrinho.getList());
        }
    
    
    @Test
        public void removendoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		assertTrue(carrinho.remove(livro));
                assertEquals(0, carrinho.numeroDeProdutos());
	}
        
        @Test(expected = CarrinhoVazioExpected.class)
        public void removendoUmProdutoInexistente() throws CarrinhoVazioExpected{
                Produto deitel = new Produto("Java: como programar", 150.00);
                assertFalse(carrinho.remove(deitel));
        }
        
        @Test
        public void calculaTotalPedido() throws CarrinhoVazioExpected{
                Produto livro = new Produto("Java em 24 horas", 60.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 120.00);
		carrinho.add(deitel);
                Produto livroInfantil = new Produto("A branca de neve", 25.00);
                carrinho.add(livroInfantil);
                assertEquals(210.00, carrinho.calcularTotalPedido(), 1e-40);
                carrinho.remove(deitel);
                assertEquals(85.00, carrinho.calcularTotalPedido(), 1e-40);
                carrinho.add(deitel);
                assertEquals(210.00, carrinho.calcularTotalPedido(), 1e-40);
        }

}
