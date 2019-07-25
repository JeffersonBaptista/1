package zup.com.br.controllers;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import zup.com.br.exceptions.MensagemNaoEncontradaExcepion;
import zup.com.br.helpers.DetalhesErro;

@RestController
@ControllerAdvice
public class MensagemControlerAdvice {

	@ExceptionHandler(MensagemNaoEncontradaExcepion.class)
	public ResponseEntity<DetalhesErro> handleMesagemNaoEncontradaException(MensagemNaoEncontradaExcepion e,
			WebRequest requisicao) {

		DetalhesErro detalhesErro = new DetalhesErro(HttpStatus.NOT_FOUND, e.getMessage(),
				requisicao.getDescription(false));

		return ResponseEntity.status(detalhesErro.getStatus()).body(detalhesErro);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalhesErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
			WebRequest requisicao) {
		DetalhesErro detalhesErro = new DetalhesErro(HttpStatus.BAD_REQUEST, e.getMessage(),
				requisicao.getDescription(false));

		return ResponseEntity.status(detalhesErro.getStatus()).body(detalhesErro);

	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<DetalhesErro> handleConstraintViolationException(ConstraintViolationException e, WebRequest requisicao){
		DetalhesErro detalhesErro = new DetalhesErro(HttpStatus.BAD_REQUEST, e.getMessage(),
				requisicao.getDescription(false));

		return ResponseEntity.status(detalhesErro.getStatus()).body(detalhesErro);
	}
	

}
