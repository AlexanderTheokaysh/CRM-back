package CRM.service;

import CRM.domain.PromiseEntity;

import java.util.List;

public interface PromiseService {
    PromiseEntity get(Long id);

    PromiseEntity edit(PromiseEntity entity);

    List<PromiseEntity> list(Long id);

    void delete(Long id);

}
