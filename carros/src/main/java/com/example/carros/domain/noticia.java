package com.example.carros.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String noticiaCompleta;

    public noticia() {

    }

    public noticia(Long id, String titulo, String resumo, String noticiaCompleta) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.noticiaCompleta = noticiaCompleta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getNoticiaCompleta() {
        return noticiaCompleta;
    }

    public void setNoticiaCompleta(String noticiaCompleta) {
        this.noticiaCompleta = noticiaCompleta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
