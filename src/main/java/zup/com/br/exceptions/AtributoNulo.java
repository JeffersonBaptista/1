package zup.com.br.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtributoNulo extends RuntimeException{
	
	public AtributoNulo(String excecao) {
		super(excecao);
	}
	

}
