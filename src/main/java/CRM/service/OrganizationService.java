package CRM.service;

import CRM.domain.OrganizationEntity;
import org.springframework.data.domain.Page;

public interface OrganizationService {

    OrganizationEntity get(Long id);
    OrganizationEntity getOrganizationByID(String code);

    OrganizationEntity edit(OrganizationEntity entity);


    Page<OrganizationEntity> page(Integer start,
                                  Integer limit,
                                  String orgName,
                                  String cadastrialCode);

    void delete(Long id);
}
