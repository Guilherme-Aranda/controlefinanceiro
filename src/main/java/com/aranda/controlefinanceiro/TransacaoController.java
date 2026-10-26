package com.aranda.controlefinanceiro.controller;

import com.aranda.controlefinanceiro.model.Transacao;
import com.aranda.controlefinanceiro.repository.TransacaoRepository;
import org.springframework.web.bind.annotation.*;

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
    public Transacao cadastrar(@RequestBody Transacao transacao) {
        return transacaoRepository.save(transacao);
    }
}
