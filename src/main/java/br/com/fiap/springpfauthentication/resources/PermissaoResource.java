package br.com.fiap.springpfauthentication.resources;

import br.com.fiap.springpfauthentication.repository.PermissaoRepository;
import java.util.List;
import br.com.fiap.springpfauthentication.entity.Permissao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/permissao")
public class PermissaoResource {

    // conectando PermissaoRepository a repo
    @Autowired
    private PermissaoRepository repo;

    @GetMapping
    public List<Permissao> findAll() {
        return repo.findAll();
    }

    //Criando Rotas 
    @GetMapping(value="/{id}")
    public Permissao findById(@PathVariable Long id) {

        return repo.findById( id ).orElseThrow();
    }

    //Fazendo transação para o banco de dados
    @Transactional
    @PostMapping
    public Permissao save(@RequestBody Permissao permissao) {
        return repo.save( permissao );
    }

}
