package zup.com.br.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MensagemNaoEncontradaExcepion extends RuntimeException{
	
	public MensagemNaoEncontradaExcepion(String excecao) {
		super(excecao);
	}

}
