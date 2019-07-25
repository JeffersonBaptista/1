package zup.com.br.controllers;

import javax.validation.Valid;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zup.com.br.models.MensagemModel;
import zup.com.br.repositories.MensagemRepository;
import zup.com.br.services.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemControler {

	@Autowired
	private MensagemService mensagemService;

//	@GetMapping
//	public ResponseEntity getOlaMundo() {
//		return ResponseEntity.ok("Ola Mundo");
//
//	}

	@GetMapping
	public ResponseEntity<?> pegarMensagens() {
		if (mensagemService.quantidadeMensagens() > 0) {
			return ResponseEntity.ok(mensagemService.pegarMensagens());
		}
		return ResponseEntity.noContent().build();

	}

	@PostMapping
	public ResponseEntity<MensagemModel> criarMansagem(@RequestBody MensagemModel mensagem) {
		
			mensagemService.salvarMensagem(mensagem);
			return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);


	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarMensagem(@PathVariable int id, @Valid @RequestBody MensagemModel mensagem) {
		
			mensagemService.atualizarmensagem(id, mensagem);
			return ResponseEntity.ok(mensagem);


	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> atualizarMensagem(@PathVariable int id) {

	
			mensagemService.apagarMensasgem(id);
			return ResponseEntity.ok().build();
	}



	@GetMapping("/{id}")
	public ResponseEntity<?> pegarMensagemId(@PathVariable int id) {
		try {
			MensagemModel mensagen = mensagemService.pegarMensagenId(id);
			return ResponseEntity.ok(mensagen);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

}
