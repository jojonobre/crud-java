package com.joyce;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public Produto criarProduto(String nome, double preco) {

        Produto produto =
                new Produto(proximoId++, nome, preco);

        produtos.add(produto);

        return produto;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarPorId(int id) {

        for (Produto produto : produtos) {

            if (produto.getId() == id) {
                return produto;
            }
        }

        return null;
    }

    public boolean atualizarProduto(
            int id,
            String novoNome,
            double novoPreco) {

        Produto produto = buscarPorId(id);

        if (produto == null) {
            return false;
        }

        produto.setNome(novoNome);
        produto.setPreco(novoPreco);

        return true;
    }

    public boolean deletarProduto(int id) {

        Produto produto = buscarPorId(id);

        if (produto == null) {
            return false;
        }

        produtos.remove(produto);

        return true;
    }
}