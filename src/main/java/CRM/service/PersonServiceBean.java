package CRM.service;

import CRM.repository.PersonRepository;
import CRM.domain.PersonEntity;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonServiceBean implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonEntity get(Long id) {
        Optional<PersonEntity> optimalPersonEntity = personRepository.findById(id);
        return new TemplateUtil<PersonEntity>().get(optimalPersonEntity);
    }

    @Override
    public PersonEntity edit(PersonEntity entity) {
        return personRepository.save(entity);
    }

    @Override
    public PersonEntity search(String personalNumber) {

        return new TemplateUtil<PersonEntity>().get( personRepository.findByPersonalNumberLike(personalNumber));
    }

    @Override
    public Page<PersonEntity> page(Integer start, Integer limit, String firstname, String lastname, String personalNumber) {

        Pageable paging = PageRequest.of(start, limit);

        return personRepository.findPagedPersons(firstname, lastname, personalNumber, paging);
    }


    @Override
    public void delete(Long id) {
        PersonEntity personEntity = get(id);
        personRepository.delete(personEntity);
    }

}
