package br.com.calderani.metrorecyclerviewer.model;

import br.com.calderani.metrorecyclerviewer.api.APIUtils;

/**
 * Created by logonrm on 26/06/2017.
 */

public class Metro {
    private String cor;
    public String getCor() { return cor; }
    public void setCor(String nome) { this.cor = cor; }

    private String numero;
    public String getNumero() { return numero; }
    public void setNumero(String api) { this.numero = numero; }

    private String urlImagem;
    public String getUrlImagem() { return APIUtils.BASE_URL + urlImagem; }
    public void setUrlImagem(String urlImagem) { this.urlImagem = APIUtils.BASE_URL + urlImagem; }
}
