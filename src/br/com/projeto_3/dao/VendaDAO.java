package br.com.projeto_3.dao;

import br.com.projeto_3.dto.VendaDTO;
import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dto.LojaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

public class VendaDAO {

    public VendaDAO() {
    }

    private ResultSet rs = null;

    Statement stmt = null;
    Statement stmt1 = null;

    public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, LojaDTO lojaDTO, JTable produtos) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();

            String comando1 = "Insert into venda (id_vend, id_loja, val_vend, "
                    + "id_cliente) values ( "
                    + vendaDTO.getId_vend() + ", "
                    + lojaDTO.getId_loja() + ", "
                    + vendaDTO.getVal_vend() + ", "
                    + clienteDTO.getId_cliente() + ")";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();

            for (int cont = 0; cont < produtos.getRowCount(); cont++) {
                String comando2 = "Insert into produto_venda (id_vend, id_prod, "
                        + "val_prod, qtd_prod) values ( "
                        + rs.getInt("id_vend") + ", "
                        + produtos.getValueAt(cont, 0) + ", "
                        + produtos.getValueAt(cont, 2) + ", "
                        + produtos.getValueAt(cont, 3) + "); ";

                stmt1.execute(comando2);
            }

            ConexaoDAO.con.commit();

            stmt.close();
            stmt1.close();
            rs.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
