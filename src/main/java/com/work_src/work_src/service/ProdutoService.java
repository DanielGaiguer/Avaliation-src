/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.work_src.work_src.service;

import com.work_src.work_src.model.ProdutoDTO;
import com.work_src.work_src.repository.ProdutoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoDAO repository;
    
    public List<ProdutoDTO> listarProdutos(){
        return repository.listarProdutos();
    }
    
    public void adicionarProduto(ProdutoDTO produto) {
        repository.adicionarProduto(produto);
    }
}
