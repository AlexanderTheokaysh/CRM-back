package CRM.service;

import CRM.domain.DeskEntity;

import java.util.List;

public interface DeskService {

    DeskEntity get(Long id);

    DeskEntity add(DeskEntity deskEntity);

    DeskEntity addTeamToDesk(Long deskId, Long employeeId);

    DeskEntity addManagerToDesk(Long deskId, Long employeeId);

    DeskEntity edit(DeskEntity entity);


    List<DeskEntity> list();

}
