package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor {

    Optional<Usuario> findByLogin(String login);
}
