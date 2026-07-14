package com.joyce;

public class Main {

    public static void main(String[] args) {

        ProdutoService service = new ProdutoService();

        service.criarProduto("Notebook", 3500);
        service.criarProduto("Mouse", 50);

        System.out.println("=== PRODUTOS ===");

        for (Produto produto : service.listarProdutos()) {
            System.out.println(produto);
        }
    }
}
