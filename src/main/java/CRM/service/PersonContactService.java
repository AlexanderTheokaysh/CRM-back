package CRM.service;

import CRM.domain.PersonContactEntity;

import java.util.List;

public interface PersonContactService {

    PersonContactEntity get(Long id);

    PersonContactEntity edit(PersonContactEntity entity);

    List<PersonContactEntity> list(Long id);

    void delete(Long id);
}
