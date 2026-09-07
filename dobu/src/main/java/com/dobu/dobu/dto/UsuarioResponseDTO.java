package com.dobu.dobu.dto;

import com.dobu.dobu.enums.TipoUsuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        TipoUsuario tipoUsuario
) {
}
