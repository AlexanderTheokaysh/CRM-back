package CRM.service;

import CRM.repository.PersonContactRepository;
import CRM.domain.PersonContactEntity;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonContactServiceBean implements PersonContactService {

    private final PersonContactRepository personContactRepository;

    @Override
    public PersonContactEntity get(Long id) {
        Optional<PersonContactEntity> optionalPersonContactEntity = personContactRepository.findById(id);
        return new TemplateUtil<PersonContactEntity>().get(optionalPersonContactEntity);
    }

    @Override
    public PersonContactEntity edit(PersonContactEntity entity) {
        return personContactRepository.save(entity);
    }

    @Override
    public List<PersonContactEntity> list(Long id) {
        return personContactRepository.findAllByPersonId(id);

    }

    @Override
    public void delete(Long id) {
        PersonContactEntity personContactEntity = get(id);
        personContactRepository.delete(personContactEntity);
    }
}
