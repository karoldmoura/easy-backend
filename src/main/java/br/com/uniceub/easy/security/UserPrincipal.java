package br.com.uniceub.easy.security;

import br.com.uniceub.easy.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = -181326870758836880L;

	private Long id;

	private String nome;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(Long id){
		this.id = id;
	}

	public static UserPrincipal create(Usuario usuario) {

		List<GrantedAuthority> authorities = Stream.of(new SimpleGrantedAuthority("ADMIN"))
				.collect(Collectors.toList());

		return new UserPrincipal(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getEmail(), usuario.getSenha(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
