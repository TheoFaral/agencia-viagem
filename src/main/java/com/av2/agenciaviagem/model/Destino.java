package com.av2.agenciaviagem.model;

public class Destino {

    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;
    private Double precoPacote;
    private Double notaMedia;
    private Integer quantidadeAvaliacoes;
    private Boolean reservado;
    private String nomeClienteReserva;

    public Destino() {
    }

    public Destino(Long id, String nome, String localizacao, String descricao, Double precoPacote) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.precoPacote = precoPacote;
        this.notaMedia = 0.0;
        this.quantidadeAvaliacoes = 0;
        this.reservado = false;
        this.nomeClienteReserva = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoPacote() {
        return precoPacote;
    }

    public void setPrecoPacote(Double precoPacote) {
        this.precoPacote = precoPacote;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public Integer getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(Integer quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public String getNomeClienteReserva() {
        return nomeClienteReserva;
    }

    public void setNomeClienteReserva(String nomeClienteReserva) {
        this.nomeClienteReserva = nomeClienteReserva;
    }
}