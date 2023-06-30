package br.com.projeto_3.ctr;

import java.sql.ResultSet;
import br.com.projeto_3.dto.FuncionarioDTO;
import br.com.projeto_3.dao.FuncionarioDAO;
import br.com.projeto_3.dao.ConexaoDAO;

public class FuncionarioCTR {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public FuncionarioCTR() {

    }

    public String inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionario Cadastrada com sucesso!!!";

            } else {
                return "Funcionario NÃO cadastrado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO cadastrado";
        }
    }

    public String alteraFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            if (funcionarioDAO.alteraFuncionario(funcionarioDTO)) {
                return "Funcionario Alterado com sucesso!!!";

            } else {
                return "Funcionario NÃO alterado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario nao Alterado!!!";
        }
    }

    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionario Excluido com sucesso!!!";

            } else {
                return "Funcionario NÃO excluido!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario nao Excluido!!!";
        }
    }

    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {

        ResultSet rs = null;
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        return rs;

    }

    public String logarFuncionario(FuncionarioDTO funcionarioDTO) {

        return funcionarioDAO.logarFuncionario(funcionarioDTO);
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

}
