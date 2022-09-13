package com.api.gerenciadorDeContas.controllers;

import com.api.gerenciadorDeContas.models.Usuario;
import com.api.gerenciadorDeContas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/usuarios")
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioService.buscarTodos();
    }

    @GetMapping(path = "/usuarios/{codigo}")
    public Optional<Usuario> buscarPorId(@PathVariable Long codigo){
        return usuarioService.buscarPorId(codigo);
    }

    @PostMapping(path = "/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PutMapping(path = "/usuarios/{codigo}")
    public Usuario alterarUsuario(@RequestBody Usuario usuario){
        return usuarioService.alterarUsuario(usuario);
    }

    @DeleteMapping(path = "/usuarios/{codigo}")
    public void deletarUsuario(@PathVariable Long codigo){
        usuarioService.deletarUsuario(codigo);
    }
}
