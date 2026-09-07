package com.dobu.dobu.controller;

import com.dobu.dobu.dto.UsuarioDTO;
import com.dobu.dobu.dto.UsuarioResponseDTO;
import com.dobu.dobu.entity.Usuario;
import com.dobu.dobu.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public Page<UsuarioResponseDTO> listar(Pageable pageable) {
        return service.listar(pageable).map(this::toResponse);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return toResponse(service.buscarPorId(id));
    }

    @PostMapping
    public UsuarioResponseDTO salvar(@Valid @RequestBody UsuarioDTO dto) {
        return toResponse(service.salvar(toEntity(dto)));
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id,
                                        @Valid @RequestBody UsuarioDTO dto) {
        return toResponse(service.atualizar(id, toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    private Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        return usuario;
    }

    private UsuarioResponseDTO toResponse(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
    }
}
