/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.work_src.work_src.controller;

import com.work_src.work_src.model.ProdutoDTO;
import com.work_src.work_src.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    
    @Autowired 
    private ProdutoService service;
        
    @GetMapping("/adicionar")
    public String adicionarProduto(Model model) {
        model.addAttribute("produto", new ProdutoDTO());
        return "adicionar";
    }
    
    @PostMapping("/adicionar")
    public String adicionarProduto(@ModelAttribute("produto") ProdutoDTO produto){
        service.adicionarProduto(produto);
        return "redirect:produtos";
    }
    
    @GetMapping("produtos")
    public String listarProdutos(Model model) {
        List<ProdutoDTO> listarProdutos = service.listarProdutos();
        model.addAttribute("lista", listarProdutos);
        return "/produtos";
    } 
    
//    @GetMapping
//    public String editarProduto(Model model) {
//        return "/editar";
//    } 
}
