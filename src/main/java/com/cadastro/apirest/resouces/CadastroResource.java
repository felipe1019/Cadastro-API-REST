package com.cadastro.apirest.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.apirest.repository.CadastroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.cadastro.apirest.models.Cadastro;

@RestController
@RequestMapping(value="/api")
@Api(value= "API REST Cadastros")
@CrossOrigin(origins="*")
public class CadastroResource {
	
	@Autowired
	CadastroRepository cadastroRepository;
	
	@GetMapping("/cadastros")
	@ApiOperation(value="Retorna uma lista de cadastros")
	public List<Cadastro> listaCadastro(){
		return cadastroRepository.findAll();
	}
	
	@GetMapping("/cadastro/{id}")
	@ApiOperation(value="Retorna um cadastro unico")
	public Cadastro listaCadastroUnico(@PathVariable(value="id")long id){
		return cadastroRepository.findById(id);
	}
	
	@PostMapping ("/cadastro")
	@ApiOperation(value="Salva um cadastro")
	public Cadastro salvaCadastro(@RequestBody Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
	@DeleteMapping ("/cadastro")
	@ApiOperation(value="Deleta um cadastro")
	public void deletaCadastro(@RequestBody Cadastro cadastro) {
		cadastroRepository.delete(cadastro);
	}
	
	@PutMapping ("/cadastro")
	@ApiOperation(value="Atualiza um cadastro")
	public Cadastro atualizaCadastro(@RequestBody Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
}
