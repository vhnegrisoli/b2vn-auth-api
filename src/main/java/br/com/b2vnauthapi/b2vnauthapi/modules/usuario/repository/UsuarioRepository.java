package br.com.b2vnauthapi.b2vnauthapi.modules.usuario.repository;

import br.com.b2vnauthapi.b2vnauthapi.modules.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByCpf(String cpf);
}
