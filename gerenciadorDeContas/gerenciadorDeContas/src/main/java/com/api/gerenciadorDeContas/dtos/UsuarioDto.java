package com.api.gerenciadorDeContas.dtos;

import com.api.gerenciadorDeContas.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UsuarioDto {

    private Long codigo;
    @NotBlank(message = "Nome não pode estar em branco")
    private String nome;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private String dataNascimento;
    @NotBlank @Email(message = "Endereço de e-mail invalido")
    private String email;
    @NotBlank @CPF(message = "CPF precisa ser informado")
    private String cpf;

    public UsuarioDto(Usuario usuario) {
        codigo = usuario.getCodigo();
        nome = usuario.getNomeUsuario();
        dataNascimento = usuario.getDataNascimento();
        email = usuario.getEmail();
    }
}
