package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.EntityAbstract;
import br.com.uniceub.easy.exception.EasyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class ServiceAbstract<T extends EntityAbstract, R extends JpaRepository> {

    protected static final Logger LOG = LoggerFactory.getLogger(ServiceAbstract.class);

    R repository;

    @Transactional(rollbackFor = EasyException.class)
    public Page<T> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional (rollbackFor = EasyException.class)
    public List<T> listar() {
        return repository.findAll();
    }

    @Transactional (rollbackFor = EasyException.class)
    public T buscarPorId(Object id) throws EasyException {

        Optional<T> optional = repository.findById(id);

        return optional
                .orElseThrow(() -> new EasyException("erro.naoencontrada:Informação", HttpStatus.NOT_FOUND));
    }

    @Transactional (rollbackFor = EasyException.class)
    public T salvar(T t) {
        try {
            return (T) repository.save(t);
        } catch (DataIntegrityViolationException e){
            if (e.getMostSpecificCause().getMessage().contains("duplicate key")
                    || e.getMostSpecificCause().getMessage().contains("primary key")) {
                LOG.error("Erro ao salvar - ", e);
                throw new EasyException("erro.duplicado");
            }

            LOG.error("Erro ao salvar - ", e);
            throw new EasyException("erro.violacao");
        } catch (Exception e) {
            LOG.error("Erro ao salvar - ", e);
            throw new EasyException("erro.persistir");
        }
    }

    @Transactional (rollbackFor = EasyException.class)
    public void excluir(Object id) {
        try {
            repository.deleteById(id);
        } catch (UnexpectedRollbackException ue) {
            if (ue.getMostSpecificCause().getMessage().contains("conflicted with the REFERENCE")) {
                LOG.error("Erro ao excluir - ", ue);
                throw new EasyException("erro.violacao");
            }
        } catch (Exception ex) {
            LOG.error("Erro ao excluir - ", ex);
            throw new EasyException("erro.excluir");
        }
    }

    @Transactional (rollbackFor = EasyException.class)
    public T editar(T t){

        this.buscarPorId(t.getId());

        return this.salvar(t);
    }
}
