package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

}