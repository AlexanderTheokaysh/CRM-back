package CRM.service;

import CRM.domain.DeskEntity;

import java.util.List;

public interface DeskService {

    DeskEntity get(Long id);

    DeskEntity add(DeskEntity deskEntity);

    DeskEntity edit(DeskEntity entity);


    List<DeskEntity> list();

}