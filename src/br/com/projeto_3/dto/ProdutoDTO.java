package br.com.projeto_3.dto;

public class ProdutoDTO {
    
    private String nome_prod, desc_prod, cod_prod;
    private Double p_prod;
    private int id_prod;

    /**
     * @return the nome_prod
     */
    public String getNome_prod() {
        return nome_prod;
    }

    /**
     * @param nome_prod the nome_prod to set
     */
    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    /**
     * @return the desc_prod
     */
    public String getDesc_prod() {
        return desc_prod;
    }

    /**
     * @param desc_prod the desc_prod to set
     */
    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }

    /**
     * @return the cod_prod
     */
    public String getCod_prod() {
        return cod_prod;
    }

    /**
     * @param cod_prod the cod_prod to set
     */
    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    /**
     * @return the p_prod
     */
    public Double getP_prod() {
        return p_prod;
    }

    /**
     * @param p_prod the p_prod to set
     */
    public void setP_prod(Double p_prod) {
        this.p_prod = p_prod;
    }

    /**
     * @return the id_prod
     */
    public int getId_prod() {
        return id_prod;
    }

    /**
     * @param id_prod the id_prod to set
     */
    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    
    
}
