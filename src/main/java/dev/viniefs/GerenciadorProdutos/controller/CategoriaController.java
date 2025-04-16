package dev.viniefs.GerenciadorProdutos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @GetMapping("/teste")
    public String testeCategoria() {
        return "Testando controller da categoria";
    }
}
