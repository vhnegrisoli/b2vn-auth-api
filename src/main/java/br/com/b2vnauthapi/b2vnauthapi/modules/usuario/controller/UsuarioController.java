package br.com.b2vnauthapi.b2vnauthapi.modules.usuario.controller;

import br.com.b2vnauthapi.b2vnauthapi.modules.usuario.dto.UsuarioAdminRequest;
import br.com.b2vnauthapi.b2vnauthapi.modules.usuario.dto.UsuarioAutenticado;
import br.com.b2vnauthapi.b2vnauthapi.modules.usuario.dto.UsuarioRequest;
import br.com.b2vnauthapi.b2vnauthapi.modules.usuario.model.Usuario;
import br.com.b2vnauthapi.b2vnauthapi.modules.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<Usuario> getUsuarios(@PathParam("page") Integer page,
                                     @PathParam("size") Integer size) {
        return usuarioService.getUsuarios(page, size);
    }

    @GetMapping("/check-session")
    public ResponseEntity checkSession() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/novo")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Usuário inserido com sucesso!")
    public void novoUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        usuarioService.save(usuarioRequest);
    }

    @PutMapping("/alterar-acesso")
    @ResponseStatus(code = HttpStatus.OK, reason = "Usuário alterado com sucesso!")
    public void alterarDadosUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        usuarioService.save(usuarioRequest);
    }

    @GetMapping("/usuario-autenticado")
    public UsuarioAutenticado getUsuarioAutenticado(HttpServletRequest request) {
        return usuarioService.getUsuarioAutenticadoAtualizaUltimaData();
    }

    @PostMapping("/admin/novo")
    public void tornarAdmin(@RequestBody UsuarioAdminRequest usuarioAdminRequest) {

    }
}
