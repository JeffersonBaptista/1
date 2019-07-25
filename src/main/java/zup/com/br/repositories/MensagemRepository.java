package zup.com.br.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import zup.com.br.models.MensagemModel;

@Repository
public interface MensagemRepository extends CrudRepository<MensagemModel, Integer>{

}
