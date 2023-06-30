package br.com.projeto_3.dao;

import java.sql.*;
import br.com.projeto_3.dto.ClienteDTO;

public class ClienteDAO {
    
    public ClienteDAO(){
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirCliente(ClienteDTO clienteDTO){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into cliente (nome_cli, logradouro_cli, numero_cli, "
                    + "bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values ( "
                    + "'" + clienteDTO.getNome() + "', "
                    + "'" + clienteDTO.getLogradouro() + "', "
                    + "" + clienteDTO.getNumero() + ", "
                    + "'" + clienteDTO.getBairro() + "', "
                    + "'" + clienteDTO.getCidade() + "', "
                    + "'" + clienteDTO.getEstado() + "', "
                    + "'" + clienteDTO.getCep()+ "', "
                    + "'" + clienteDTO.getCpf()+ "', "
                    + "'" + clienteDTO.getRg()+ "') ";
            
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean alterarCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update cliente set "
                    + "nome_cli = '" + clienteDTO.getNome()+ "', "
                    + "logradouro_cli = '" + clienteDTO.getLogradouro()+ "', "
                    + "numero_cli = " + clienteDTO.getNumero()+ ", "
                    + "bairro_cli = '" + clienteDTO.getBairro()+ "', "
                    + "cidade_cli = '" + clienteDTO.getCidade()+ "', "
                    + "estado_cli = '" + clienteDTO.getEstado()+ "', "
                    + "cep_cli = '" + clienteDTO.getCep()+ "', "
                    + "cpf_cli = '" + clienteDTO.getCpf() + "', "
                    + "rg_cli = '" + clienteDTO.getRg()+ "' "
                    + "where id_cliente = " + clienteDTO.getId_cliente();
                       
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem 
          //no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean excluirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from cliente where id_cliente = " 
                             + clienteDTO.getId_cliente();

            
            stmt.execute(comando);
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } 
        finally {
           
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        try {
            
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select c.* "+
                              "from cliente c "+
                              "where nome_cli like '" + clienteDTO.getNome()+ "%' " +
                              "order by c.nome_cli";    
                break;
                case 2:
                    comando = "Select c.* "+
                              "from cliente c " +
                              "where c.id_cliente = " + clienteDTO.getId_cliente();
                break;
                case 3:
                    comando = "Select c.id_cliente, c.nome_cliente "+
                              "from cliente c ";
                break; 
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarCliente
}
