package com.algaworks.algafood.infrastructure.repository;

import static com.algaworks.algafood.infrastructure.repository.spec.RestaurantesSpec.comFreteGratis;
import static com.algaworks.algafood.infrastructure.repository.spec.RestaurantesSpec.comNomeSemelhante;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired @Lazy
	private RestauranteRepository restauranteRepository;
	
	@Override
	public List<Restaurante> find(String nome,
			String taxaFreteInicial, String taxaFreteFinal){

		
/*	===================== CONSULTA SIMPLES =====================
		String jpql = " from Restaurante where nome like :nome "
					+ " and taxa_frete between :taxaInicial and :taxaFinal";
							
		
/*	===================== CONSULTA DINÂMICA ===================== 
  		StringBuilder jpql = new StringBuilder();
		jpql.append("from Restaurante where 0 = 0 ");
		HashMap<String, Object> paramentros = new HashMap<>();
			
		if (StringUtils.hasLength(nome)) {
			jpql.append(" and nome like :nome ");
			paramentros.put("nome", "%"+nome+"%");
		}
		
		if (taxaFreteInicial != null) {
			jpql.append(" and taxa_frete >= : taxaInicial");
			paramentros.put("taxaInicial", taxaFreteInicial);
		}
		
		if (taxaFreteFinal != null) {
			jpql.append(" and taxa_frete <= : taxaFinal");
			paramentros.put("taxaFinal", taxaFreteFinal);
		}
		
		TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);
		paramentros.forEach((chave, valor) -> query.setParameter(chave, valor));
		
		return query.getResultList();
*/		
		
/*	===================== CONSULTA SIMPLES COM CRITERIA ===================== */
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		Root<Restaurante> root = criteria.from(Restaurante.class); // from Restaurante
		ArrayList<Predicate> predicates = new ArrayList<>(); 
		
		if(StringUtils.hasLength(nome))
			predicates.add(builder.like(root.get("nome"), "%"+nome+"%"));
	
		if(StringUtils.hasLength(taxaFreteInicial))
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		
		if(StringUtils.hasLength(taxaFreteFinal))
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		
		
		criteria.where(predicates.toArray(new Predicate[0])); // Convertendo List em Array
		
		
		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

	@Override
	public List<Restaurante> findComFreteGratis(String nome) {
		return restauranteRepository.findAll(comFreteGratis()
				.and(comNomeSemelhante(nome)));
	}

}
