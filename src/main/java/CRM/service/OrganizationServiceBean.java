package CRM.service;

import CRM.domain.OrganizationEntity;
import CRM.repository.OrganizationRepository;
import com.george.orca.domain.*;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationServiceBean implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationEntity get(Long id) {
        Optional<OrganizationEntity> optionalOrganizationEntity = organizationRepository.findById(id);
        return new TemplateUtil<OrganizationEntity>().get(optionalOrganizationEntity);
    }

    @Override
    public OrganizationEntity getOrganizationByID(String code) {
        Optional<OrganizationEntity> optionalOrganizationEntity = organizationRepository.findOrganizationEntityByCadastrialCode(code);
        return new TemplateUtil<OrganizationEntity>().get(optionalOrganizationEntity);
    }

    @Override
    public OrganizationEntity edit(OrganizationEntity entity) {
        return organizationRepository.save(entity);
    }


    @Override
    public Page<OrganizationEntity> page(Integer start, Integer limit, String orgName, String cadastrialCode) {

        Pageable paging = PageRequest.of(start, limit);


        return organizationRepository.findPagedOrganizations(orgName, cadastrialCode, paging);
    }

    @Override
    public void delete(Long id) {
        OrganizationEntity organizationEntity = get(id);
        organizationRepository.delete(organizationEntity);
    }
}
