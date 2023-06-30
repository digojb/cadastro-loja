package br.com.projeto_3.ctr;

import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dao.ClienteDAO;
import br.com.projeto_3.dao.ConexaoDAO;
import java.sql.ResultSet;

public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteCTR() {
    }
    
    public String inserirCliente(ClienteDTO clienteDTO) {
        try {
     
            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente Cadastrado com Sucesso!!!";
            } else {
                return "Cliente NÃO Cadastrado!!!";
            }
        }		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Cadastrado";
        }
    }
    
    public String alterarCliente(ClienteDTO clienteDTO) {
        try {
            
            if (clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente Alterado com Sucesso!!!";
            } else {
                return "Cliente NÃO Alterado!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Alterado!!!";
        }
    }

    public String excluirCliente(ClienteDTO clienteDTO) {
        try {
            
            if (clienteDAO.excluirCliente(clienteDTO)) {
                return "Cliente Excluído com Sucesso!!!";
            } else {
                return "Cliente NÃO Excluído!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Excluído!!!";
        }
    }

    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        
        ResultSet rs = null;
    
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        return rs;
    }//Fecha o método consultarCliente
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
}
