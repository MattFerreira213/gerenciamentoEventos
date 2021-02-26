package com.mateus.ferreira.gerenciamento.eventos.reposotiry;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mateus.ferreira.gerenciamento.eventos.entity.Pessoa;
import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;

@Repository
public class PessoaRepositoryImpl {

	@Autowired
	private EntityManager entityManager;

	public List<Pessoa> listaPessoasPorSalaOuEspaco(String filtro) {

		StringBuilder sql = new StringBuilder();
		sql.append("select distinct p.nome,p.sobrenome,p.id,pe.espacocafe_id,ps.salaevento_id from pessoa p ");
		sql.append("join pessoa_salaevento ps on ps.pessoa_id = p.id ");
		sql.append("join salaevento s on s.id = ps.salaevento_id ");
		sql.append("join pessoa_espacocafe pe on pe.pessoa_id = p.id ");
		sql.append("join espacocafe e on e.id = pe.espacocafe_id ");
		sql.append("where s.nome = :filtro or e.nome = :filtro ");

		@SuppressWarnings("unchecked")
		TypedQuery<Pessoa> typedQuery = (TypedQuery<Pessoa>) entityManager.createNativeQuery(sql.toString(), Pessoa.class);
		typedQuery.setParameter("filtro", filtro);

		List<Pessoa> pessoas = typedQuery.getResultList();

		return pessoas;
	}
	
	public void relacionarPessoaComSala(Pessoa idPessoa, Sala idSala) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into pessoa_salaevento (pessoa_id, salaevento_id) values( :idPessoa, :idSala)");
	}
	

}
