package zup.com.br.helpers;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class DetalhesErro {

	private Date data;
	private int status;
	private String mensagem;
	private String origem;

	public DetalhesErro(HttpStatus status, String mensagem, String origem) {
		this.data = new Date();
		this.status = status.value();
		this.mensagem = mensagem;
		this.origem = origem;
	}

	public Date getData() {
		return data;
	}

	public int getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getOrigem() {
		return origem;
	}

}
