package br.com.tor4neto.view;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.tor4neto.service.EstudanteServiceImpl;




//@Scope("session")
//@KeepAlive(ajaxOnly = true)
//@Component("comunicadosVisao")


//@ManagedBean
@Controller("usuarioMB")
@ViewScoped
public class UsuarioMB {

	@Autowired
	private EstudanteServiceImpl estudanteServiceImpl;

	private String ola;
	
	public void digaOla(){
		ola = estudanteServiceImpl.ola();
		System.out.println(ola);
	}

	public void limpar(){
		ola=null;
	}
	
	
	public String getOla() {
		return ola;
	}

	public void setOla(String ola) {
		this.ola = ola;
	}
	
}
