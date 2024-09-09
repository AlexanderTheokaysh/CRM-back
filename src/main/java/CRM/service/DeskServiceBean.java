package CRM.service;

import CRM.domain.DeskEntity;
import CRM.repository.DeskRepository;
import CRM.utils.TemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@NotNull
public class DeskServiceBean implements DeskService {

    @Autowired
    DeskRepository deskRepository;

    @Override
    public DeskEntity add(DeskEntity deskEntity) {
        return deskRepository.save(deskEntity);

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
