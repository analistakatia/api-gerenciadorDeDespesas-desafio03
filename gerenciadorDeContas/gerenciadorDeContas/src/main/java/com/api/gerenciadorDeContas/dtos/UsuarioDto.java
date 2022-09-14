package com.api.gerenciadorDeContas.dtos;

import com.api.gerenciadorDeContas.models.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long codigo;
    private String nome;
    private LocalDate dataNascimento;
    private String email;

    public static UsuarioDto converterParaDto(Usuario usuario){
        return new UsuarioDto(usuario.getCodigo(), usuario.getNomeUsuario(), usuario.getDataNascimento(), usuario.getEmail());
    }

    public static List<UsuarioDto> converterUsuario(List<Usuario> usuarios){
        List<UsuarioDto> listaUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios){
            UsuarioDto usuarioResposta = new UsuarioDto(usuario.getCodigo(), usuario.getNomeUsuario(), usuario.getDataNascimento(), usuario.getEmail());
            listaUsuarios.add(usuarioResposta);
        }
        return listaUsuarios;
    }

}
