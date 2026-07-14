package com.joyce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoServiceTest {

    @Test
    void deveCriarProduto() {

        ProdutoService service = new ProdutoService();

        Produto produto =
                service.criarProduto("Notebook", 3500);

        assertEquals("Notebook", produto.getNome());
        assertEquals(3500, produto.getPreco());
    }

    @Test
    void deveListarProdutos() {

        ProdutoService service = new ProdutoService();

        service.criarProduto("Mouse", 50);
        service.criarProduto("Teclado", 100);

        assertEquals(
                2,
                service.listarProdutos().size()
        );
    }

    @Test
    void deveBuscarProdutoPorId() {

        ProdutoService service = new ProdutoService();

        Produto produto =
                service.criarProduto("Notebook", 3500);

        Produto encontrado =
                service.buscarPorId(produto.getId());

        assertNotNull(encontrado);
        assertEquals("Notebook", encontrado.getNome());
    }

    @Test
    void deveAtualizarProduto() {

        ProdutoService service = new ProdutoService();

        Produto produto =
                service.criarProduto("Notebook", 3500);

        boolean atualizado =
                service.atualizarProduto(
                        produto.getId(),
                        "Notebook Gamer",
                        5000
                );

        assertTrue(atualizado);

        Produto atualizadoProduto =
                service.buscarPorId(produto.getId());

        assertEquals(
                "Notebook Gamer",
                atualizadoProduto.getNome()
        );

        assertEquals(
                5000,
                atualizadoProduto.getPreco()
        );
    }

    @Test
    void deveDeletarProduto() {

        ProdutoService service = new ProdutoService();

        Produto produto =
                service.criarProduto("Notebook", 3500);

        boolean removido =
                service.deletarProduto(
                        produto.getId()
                );

        assertTrue(removido);

        assertNull(
                service.buscarPorId(
                        produto.getId()
                )
        );
    }
}