package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Usuario;
import br.com.uniceub.easy.exception.EasyException;
import br.com.uniceub.easy.repository.IUsuarioRepository;
import br.com.uniceub.easy.security.UserPrincipal;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class UsuarioService
        extends ServiceAbstract<Usuario, IUsuarioRepository>
        implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(IUsuarioRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserById(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        return UserPrincipal.create(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Usuário não encontrado com o Login: " + login)
                );
        return UserPrincipal.create(usuario);
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        try {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

            return super.salvar(usuario);
        }catch (Exception e){
            throw new EasyException("erro.persistir");
        }
    }
}
