package CRM.service;

import CRM.domain.DeskEntity;
import CRM.domain.TeamEntity;
import CRM.repository.DeskRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@NotNull
@RequiredArgsConstructor
public class DeskServiceBean implements DeskService {

    private final DeskRepository deskRepository;
    private final TeamService teamService;


    @Override
    public DeskEntity add(DeskEntity deskEntity) {
        return deskRepository.save(deskEntity);
    }

    @Override
    public DeskEntity addTeamToDesk(Long deskId, Long teamId) {
        DeskEntity desk = this.get(deskId);
        TeamEntity team = teamService.get(teamId);
        team.setDeskId(deskId);
        return deskRepository.save(desk);
    }

    @Override
    public DeskEntity get(Long id) {
        Optional<DeskEntity> deskEntity = deskRepository.findById(id);
        return new TemplateUtil<DeskEntity>().get(deskEntity);

    }

    @Override
    public DeskEntity edit(DeskEntity deskEntity) {
        deskEntity.setTeams(deskRepository.findById(deskEntity.getId()).get().getTeams());
        return deskRepository.save(deskEntity);
    }

    @Override
    public List<DeskEntity> list() {
        return deskRepository.findAll();
    }
}
