package br.com.tor4neto.view;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.tor4neto.service.EstudanteServiceImpl;

@Controller
@ViewScoped
public class UsuarioMB {

	@Autowired
	private EstudanteServiceImpl estudanteServiceImpl;
	
	
	public void ola(){
		System.out.println(estudanteServiceImpl.ola());
	}
	
}
