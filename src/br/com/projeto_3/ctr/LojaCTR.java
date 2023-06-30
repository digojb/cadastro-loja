package br.com.projeto_3.ctr;
import java.sql.ResultSet;
import br.com.projeto_3.dto.LojaDTO;
import br.com.projeto_3.dao.LojaDAO;
import br.com.projeto_3.dao.ConexaoDAO;
import javax.swing.JOptionPane;

public class LojaCTR {
    LojaDAO lojaDAO = new LojaDAO();
    LojaDTO lojaDTO = new LojaDTO();
    
    public LojaCTR(){
    }
    
    public String inserirLoja(LojaDTO lojaDTO){
        try{
            if(lojaDAO.inserirLoja(lojaDTO)){
                return "Loja Cadastrado com Sucesso!!";
            } else{
                return "Loja Não Cadastrado!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return"LOja Não Cadastrado!!";
        }
    }
    
    public ResultSet consultarLoja(LojaDTO lojaDTO, int opcao){
        ResultSet rs = null;
        
        rs = lojaDAO.consultarLoja(lojaDTO, opcao);
        
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
    public String atualizarLoja(LojaDTO lojaDTO){
        try{
            if(lojaDAO.atualizarLoja(lojaDTO)){
                return "Loja Alterado com Sucesso!!";
            } else{
                return "Loja Não Atualizado!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Loja Não Alterado!!";
        }
    }
    
    public String excluirLoja(LojaDTO lojaDTO){
        try{
            if(lojaDAO.excluirLoja(lojaDTO)){
                return "Loja Excluído com Sucesso!!";
            } else{
                return "Loja Não Excluído!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Loja Não Excluído!!";
        }
    }
    
}
