/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.work_src.work_src.repository;

import com.work_src.work_src.model.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO {
    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoDTO> lista = new ArrayList();
        
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM produto");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutoDTO produto = new ProdutoDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setEstoque(rs.getInt("estoque"));
                lista.add(produto);
            }

            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    } 
    
    public void adicionarProduto(ProdutoDTO produto) {
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
           stmt = conn.prepareStatement("INSERT INTO produto (nome, categoria, preco, estoque) VALUES (?, ?, ?, ?)");
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getEstoque());
            
            stmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
