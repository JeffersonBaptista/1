package zup.com.br.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Service;

import zup.com.br.exceptions.AtributoNulo;
import zup.com.br.exceptions.MensagemNaoEncontradaExcepion;
import zup.com.br.models.MensagemModel;
import zup.com.br.repositories.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;

	public Iterable<MensagemModel> pegarMensagens() {
		return mensagemRepository.findAll();
	}

	public void salvarMensagem(MensagemModel mensagem) {
		if(mensagem.getConteudo()==null) {
			throw new AtributoNulo("Atributo não pode ser nulo");	
		}
		mensagemRepository.save(mensagem);

	}

	public long quantidadeMensagens() {
		return mensagemRepository.count();

	}

	public void atualizarmensagem(int id, MensagemModel mensagem){
		
		Optional<MensagemModel> optionalMensagem = mensagemRepository.findById(id);
		if (!optionalMensagem.isPresent()) {
			throw new MensagemNaoEncontradaExcepion("Id não encontrado");			
		}
		mensagem.setId(id);
		mensagemRepository.save(mensagem);

	}

	public void apagarMensasgem(int id) {
		try {
			mensagemRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new MensagemNaoEncontradaExcepion("Id não encontrado");	
			
		}
		

	}

	public MensagemModel pegarMensagenId(int id) {

		return mensagemRepository.findById(id).get();

	}

}
