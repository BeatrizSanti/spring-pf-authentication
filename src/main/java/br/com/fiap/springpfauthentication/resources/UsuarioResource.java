package br.com.fiap.springpfauthentication.resources;

import br.com.fiap.springpfauthentication.repository.UsuarioRepository;
import java.util.List;
import br.com.fiap.springpfauthentication.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.coyote.Response;
import org.hibernate.mapping.Array;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {

    // conectando PermissaoRepository a repo
    @Autowired
    private UsuarioRepository repo;

    //Criando Rotas 
    @GetMapping
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @GetMapping(value="/{id}")
    public Usuario findById(@PathVariable Long id) {

        return repo.findById( id ).orElseThrow();
    }

    //Fazendo transação para o banco de dados
    @Transactional
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {

        return repo.save( usuario );
    }

}
