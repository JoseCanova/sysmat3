package br.com.connemat;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import br.com.connemat.model.entity.Ncm;

@Validated
public interface NcmBaseService 
extends CrudBaseService<Ncm,String>{

	Ncm addNcm(Ncm ncm);

	Ncm updateNcm(String code , Ncm ncm);

	Object deleteNcm(String code);

	Ncm findByNcmId(String code);
	
	Optional<Ncm> findNcmByNcmCode(@Valid @NotEmpty @Size(min = 8, max = 8) String code) ;

	@Override
	default Ncm addEntity(@Valid @NotNull(groups = CreateValidationGroup.class) Ncm entity) {
		return addNcm(entity);
	}
	
	@Override
	default Ncm updateEntity(@Valid @NotNull(groups = UpdateValidationGroup.class) String id,
			@Valid @NotNull(groups = UpdateValidationGroup.class) Ncm entity) {
		return updateNcm(id, entity);
	}
	
	@Override
	default Object deleteEntity(@Valid @NotNull String id) {
		return deleteNcm(id);
	}
	
	@Override
	default Ncm findByEntityId(@Valid @NotNull String id) {
		return findByNcmId(id);
	}
	
}