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

    public List<Usuario> buscarTodos(){
        //List<Usuario> buscar = iUsuarioRepository.findAll();
        return iUsuarioRepository.findAll();
    }

//    private UsuarioDto converterParaDto(Usuario usuario) {
//        UsuarioDto dto = new UsuarioDto();
//        dto.setCodigo(usuario.getCodigo());
//        dto.setNome(usuario.getNomeUsuario());
//        dto.setDataNascimento(usuario.getDataNascimento());
//        dto.setEmail(usuario.getEmail());
//        return dto;
//    }
//    private static List<UsuarioDto> converterListParaDto(List<Usuario> usuarios){
//        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
//    }

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
