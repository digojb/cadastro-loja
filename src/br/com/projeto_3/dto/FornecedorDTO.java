package br.com.projeto_3.dto;
import java.util.Date;

public class FornecedorDTO {
    
    private String nome_for, cnpj_for, tel_for;
    //private Date data_cad_for;
    private int id_for;

    public String getNome_for() {
        return nome_for;
    }

    public void setNome_for(String nome_for) {
        this.nome_for = nome_for;
    }

    public String getCnpj_for() {
        return cnpj_for;
    }

    public void setCnpj_for(String cnpj_for) {
        this.cnpj_for = cnpj_for;
    }

    public String getTel_for() {
        return tel_for;
    }

    public void setTel_for(String tel_for) {
        this.tel_for = tel_for;
    }


    public int getId_for() {
        return id_for;
    }

    public void setId_for(int id_for) {
        this.id_for = id_for;
    }

    
}
