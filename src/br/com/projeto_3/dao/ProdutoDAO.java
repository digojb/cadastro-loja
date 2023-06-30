package br.com.projeto_3.dao;

import java.sql.*;
import br.com.projeto_3.dto.ProdutoDTO;

public class ProdutoDAO {
    
    public ProdutoDAO(){
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirProduto(ProdutoDTO produtoDTO){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into produto (nome_prod, desc_prod, cod_prod, "
                    + "p_prod) values ( "
                    + "'" + produtoDTO.getNome_prod() + "', "
                    + "'" + produtoDTO.getDesc_prod() + "', "
                    + "'" + produtoDTO.getCod_prod() + "', "
                    + produtoDTO.getP_prod() + ") ";
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean alterarProduto(ProdutoDTO produtoDTO){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Update produto set "
                    + "nome_prod = '" + produtoDTO.getNome_prod() + "', "
                    + "desc_prod = '" + produtoDTO.getDesc_prod() + "', "
                    + "cod_bar_prod = '" + produtoDTO.getCod_prod() + "', "
                    + "p_custo_prod = " + produtoDTO.getP_prod() + ", "
                    + "where id_prod = " + produtoDTO.getId_prod();
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean excluirProduto(ProdutoDTO produtoDTO){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Delete from produto where id_prod = "
                                + produtoDTO.getId_prod();
            
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "";
            
            switch(opcao){
                case 1:
                    comando = "Select p.* " + 
                            "from produto p " + 
                            "where p.nome_prod ilike '" + produtoDTO.getNome_prod() + "%' " +
                            "order by p.nome_prod";
                break;
                case 2:
                    comando = "Select p. * " +
                            "from produto p " + 
                            "where p.id_prod = " + produtoDTO.getId_prod();
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
}

    

