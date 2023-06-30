package br.com.projeto_3.dao;

import java.sql.*;
import br.com.projeto_3.dto.LojaDTO;
public class LojaDAO {
    
    public LojaDAO(){
    }
    
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirLoja(LojaDTO lojaDTO){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into loja (cnpj_loja, "
                    + "rua_loja, tel_loja, num_loja, bairro_loja) values ( "
                    + "'" + lojaDTO.getCnpj_loja() + "', "
                    //+ "'" + lojaDTO.getCep_loja() + "', "
                    + "'" + lojaDTO.getRua_loja() + "', "
                    + "'" + lojaDTO.getTel_loja() + "', "
                    + "'" + lojaDTO.getNum_loja() + "', "
                    + "'" + lojaDTO.getBairro_loja() + "') ";
            
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
    
    public boolean atualizarLoja(LojaDTO lojaDTO){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Update loja set"
                    + "cnpj_loja = '" + lojaDTO.getCnpj_loja() + "', "
                    + "rua_loja = '" + lojaDTO.getRua_loja() + "', "
                    + "bairro_loja = '" + lojaDTO.getBairro_loja() + "', "
                    //+ "cep_loja = '" + lojaDTO.getCep_loja() + "', "
                    + "tel_loja = '" + lojaDTO.getTel_loja() + "', "
                    + "num_loja = '" + lojaDTO.getNum_loja() + "', "
                    + "where id_loja = " + lojaDTO.getId_loja();
            
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
    
    public boolean excluirLoja(LojaDTO lojaDTO){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Delete from loja where id_loja = "
                                + lojaDTO.getId_loja();
            
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
    
    public ResultSet consultarLoja(LojaDTO lojaDTO, int opcao){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "";
            
            switch(opcao){
                case 1:
                    comando = "Select l.* " +
                              "from loja l "+
                              "where l.cnpj_loja ilike '" + lojaDTO.getCnpj_loja() + "%' " +
                              "order by l.cnpj_loja";
                break;
                case 2:
                    comando = "Select l. * " +
                            "from loja l " + 
                            "where l.id_loja = " + lojaDTO.getId_loja();
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
    

