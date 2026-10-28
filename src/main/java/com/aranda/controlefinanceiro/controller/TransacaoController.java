package com.aranda.controlefinanceiro.controller;

import com.aranda.controlefinanceiro.model.Transacao;
import com.aranda.controlefinanceiro.repository.TransacaoRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public List<Transacao> listar() {

        return transacaoRepository.findAll();
    }

    @PostMapping
    public Transacao cadastrar(@Valid @RequestBody Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    @PutMapping("/{id}")
    public Transacao editar(
            @PathVariable Long id,
            @Valid @RequestBody Transacao dadosAtualizados) {

        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Transação não encontrada"));

        transacao.setDescricao(dadosAtualizados.getDescricao());
        transacao.setValor(dadosAtualizados.getValor());
        transacao.setTipo(dadosAtualizados.getTipo());
        transacao.setData(dadosAtualizados.getData());

        return transacaoRepository.save(transacao);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        transacaoRepository.deleteById(id);
    }
}
