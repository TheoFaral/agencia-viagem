package com.av2.agenciaviagem.service;

import com.av2.agenciaviagem.model.Destino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final List<Destino> destinos = new ArrayList<>();
    private Long proximoId = 1L;

    public DestinoService() {
        destinos.add(new Destino(proximoId++, "Paris", "França", "Cidade turística famosa pela Torre Eiffel.", 8500.0));
        destinos.add(new Destino(proximoId++, "Rio de Janeiro", "Brasil", "Destino conhecido pelas praias e pelo Cristo Redentor.", 3500.0));
        destinos.add(new Destino(proximoId++, "Roma", "Itália", "Cidade histórica com grande patrimônio cultural.", 7200.0));
    }

    public Destino cadastrar(Destino destino) {
        destino.setId(proximoId++);
        destino.setNotaMedia(0.0);
        destino.setQuantidadeAvaliacoes(0);
        destino.setReservado(false);
        destino.setNomeClienteReserva(null);

        destinos.add(destino);
        return destino;
    }

    public List<Destino> listarTodos() {
        return destinos;
    }

    public Optional<Destino> buscarPorId(Long id) {
        return destinos.stream()
                .filter(destino -> destino.getId().equals(id))
                .findFirst();
    }

    public List<Destino> pesquisar(String nome, String localizacao) {
        return destinos.stream()
                .filter(destino -> {
                    boolean correspondeNome = nome == null ||
                            destino.getNome().toLowerCase().contains(nome.toLowerCase());

                    boolean correspondeLocalizacao = localizacao == null ||
                            destino.getLocalizacao().toLowerCase().contains(localizacao.toLowerCase());

                    return correspondeNome && correspondeLocalizacao;
                })
                .collect(Collectors.toList());
    }

    public Optional<Destino> reservar(Long id, String nomeCliente) {
        Optional<Destino> destinoEncontrado = buscarPorId(id);

        if (destinoEncontrado.isPresent()) {
            Destino destino = destinoEncontrado.get();
            destino.setReservado(true);
            destino.setNomeClienteReserva(nomeCliente);
        }

        return destinoEncontrado;
    }

    public Optional<Destino> avaliar(Long id, Integer nota) {
        if (nota == null || nota < 1 || nota > 10) {
            throw new IllegalArgumentException("A nota deve ser um valor entre 1 e 10.");
        }

        Optional<Destino> destinoEncontrado = buscarPorId(id);

        if (destinoEncontrado.isPresent()) {
            Destino destino = destinoEncontrado.get();

            double notaAtual = destino.getNotaMedia();
            int quantidadeAtual = destino.getQuantidadeAvaliacoes();

            double novaMedia = ((notaAtual * quantidadeAtual) + nota) / (quantidadeAtual + 1);

            destino.setNotaMedia(novaMedia);
            destino.setQuantidadeAvaliacoes(quantidadeAtual + 1);
        }

        return destinoEncontrado;
    }

    public boolean excluir(Long id) {
        return destinos.removeIf(destino -> destino.getId().equals(id));
    }
}