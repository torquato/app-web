package br.com.tor4neto.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.tor4neto.model.Usuario;
import br.com.tor4neto.secutiry.CustomAuthenticationManager;

@Component("loginMB")
@ManagedBean
@ViewScoped
public class LoginMB {

	private String user;
	private String password;

	public void login(){
		
		//TODO somente um exemplo
		AuthenticationManager am = new CustomAuthenticationManager();

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new GrantedAuthorityImpl(perfil.getPerfil().getNome()));
//		authorities.add(new GrantedAuthorityImpl(esfera));

		Usuario usuario = new Usuario();
		usuario.setNome("neto");
		usuario.setLogin("neto");
		usuario.setSenha("a");
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, "default", authorities);
		Authentication retorno = am.authenticate(authentication);
		SecurityContextHolder.getContext().setAuthentication(retorno);
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
