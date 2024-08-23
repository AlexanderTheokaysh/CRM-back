package CRM.service;

import CRM.domain.EmployeeEntity;
import CRM.domain.TeamEntity;
import CRM.repository.TeamRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceBean implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public TeamEntity add(TeamEntity entity) {
        return teamRepository.save(entity);
    }

    @Override
    public TeamEntity get(Long id) {
        Optional<TeamEntity> optionalTeamEntity = teamRepository.findById(id);
        return new TemplateUtil<TeamEntity>().get(optionalTeamEntity);
    }


    @Override
    public List<TeamEntity> list() {
        return teamRepository.findAll();
    }


    @Override
    public TeamEntity addNewMember(TeamEntity team, EmployeeEntity employee) {


        return null;


    }
}
