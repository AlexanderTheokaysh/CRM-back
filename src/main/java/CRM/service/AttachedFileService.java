package CRM.service;

import CRM.domain.AttachedFileEntity;

import java.util.List;

public interface AttachedFileService {

    AttachedFileEntity get(Long id);

    AttachedFileEntity edit(AttachedFileEntity entity);

    List<AttachedFileEntity> list(Long id);

    void delete(Long id);

}




