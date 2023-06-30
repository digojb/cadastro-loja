package br.com.projeto_3.ctr;

import java.sql.ResultSet;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dao.FornecedorDAO;
import br.com.projeto_3.dao.ConexaoDAO;
import javax.swing.JOptionPane;

public class FornecedorCTR {

    FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public FornecedorCTR() {
    }

    public String inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.inserirFornecedor(fornecedorDTO)) {
                return "Fornecedor Cadastrado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Cadastrado";
        }
    }

    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
    }

    public String alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.alterarFornecedor(fornecedorDTO)) {
                return "Fornecedor Alterado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Alterado!!!";
        }
    }

    public String excluirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.excluirFornecedor(fornecedorDTO)) {
                return "Fornecedor Excluído com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Excluído!!!";
        }
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

}
