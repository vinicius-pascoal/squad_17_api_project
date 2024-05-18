package com.squad_17_api.demo.controller;

import com.squad_17_api.demo.model.Aluno;
import com.squad_17_api.demo.model.Curso;
import com.squad_17_api.demo.model.Usuario;
import com.squad_17_api.demo.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.squad_17_api.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Usuario foundUser = userService.buscarPorEmail(usuario.getEmail());
        if (foundUser != null && foundUser.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(userService.criar(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok(userService.buscarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = userService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return ResponseEntity.ok(userService.atualizar(usuario));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable String email) {
        return ResponseEntity.ok(userService.deletar(email));
    }
}
