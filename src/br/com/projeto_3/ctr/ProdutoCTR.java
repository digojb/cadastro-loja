/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.ctr;
import java.sql.ResultSet;
import br.com.projeto_3.dao.ProdutoDAO;
import br.com.projeto_3.dto.ProdutoDTO;
import br.com.projeto_3.dao.ConexaoDAO;
import javax.swing.JOptionPane;

public class ProdutoCTR {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    ProdutoDTO produtoDTO = new ProdutoDTO();
    
    public ProdutoCTR(){
    }
    
    public String inserirProduto(ProdutoDTO produtoDTO){
        try{
            if(produtoDAO.inserirProduto(produtoDTO)){
                return "Produto Cadastrado com Sucesso!!";
            } else{
                return "Produto Não Cadastrado!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return"Produto Não Cadastrado!!";
        }
    }
    
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){
        ResultSet rs = null;
        
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
    public String atualizarProduto(ProdutoDTO produtoDTO){
        try{
            if(produtoDAO.alterarProduto(produtoDTO)){
                return "Produto Alterado com Sucesso!!";
            } else{
                return "Produto Não Atualizado!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto Não Alterado!!";
        }
    }
    
    public String excluirProduto(ProdutoDTO produtoDTO){
        try{
            if(produtoDAO.excluirProduto(produtoDTO)){
                return "Produto Excluído com Sucesso!!";
            } else{
                return "Produto Não Excluído!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto Não Excluído!!";
        }
    }
    
}
