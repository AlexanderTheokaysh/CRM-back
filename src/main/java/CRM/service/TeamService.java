package CRM.service;

import CRM.domain.EmployeeEntity;
import CRM.domain.TeamEntity;

import java.util.List;

public interface TeamService {


    TeamEntity add(TeamEntity teamEntity);

    TeamEntity get(Long id);

    TeamEntity addNewMember(TeamEntity team, EmployeeEntity employee);

    List<TeamEntity> list();


}