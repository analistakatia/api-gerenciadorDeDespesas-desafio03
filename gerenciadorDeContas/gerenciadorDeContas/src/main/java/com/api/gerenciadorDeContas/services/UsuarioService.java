package com.api.gerenciadorDeContas.services;

import com.api.gerenciadorDeContas.dtos.UsuarioDto;
import com.api.gerenciadorDeContas.models.Usuario;
import com.api.gerenciadorDeContas.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    public List<UsuarioDto> buscarTodos(){
        List<Usuario> usuarios = iUsuarioRepository.findAll();
        return UsuarioDto.converterUsuario(usuarios);
    }

    public Optional<Usuario> buscarPorId(Long codigo){
        return iUsuarioRepository.findById(codigo);
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        usuario.getNomeUsuario();
        usuario.getDataNascimento();
        usuario.getEmail();
        usuario.getCpf();
        return iUsuarioRepository.save(usuario);
    }

    public Usuario alterarUsuario(Usuario usuario){
        usuario.getNomeUsuario();
        usuario.getDataNascimento();
        usuario.getEmail();
        usuario.getCpf();
        return iUsuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long codigo){
        iUsuarioRepository.deleteById(codigo);
    }

}
