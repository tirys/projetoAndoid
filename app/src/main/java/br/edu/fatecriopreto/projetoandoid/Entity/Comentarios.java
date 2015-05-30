package br.edu.fatecriopreto.projetoandoid.Entity;

import android.content.Intent;

import java.util.Date;

/**
 * Created by Jessica on 29/05/2015.
 */
public class Comentarios {
    private String conteudo;
    private String data;
    private Integer idpessoa;

    public Comentarios(){}

    public Comentarios(Integer idpessoa, String conteudo,String data)
    {
        this.setIdpessoa(idpessoa);
        this.setConteudo(conteudo);
        this.setData(data);
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }



}
