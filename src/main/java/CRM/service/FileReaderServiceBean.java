package CRM.service;

import CRM.domain.LoanEntity;
import CRM.domain.OrganizationEntity;
import CRM.domain.PersonEntity;
import CRM.repository.OrganizationRepository;
import CRM.repository.PersonRepository;
import CRM.service.PersonsDBServices.Persons1Service;
import CRM.config.FileConfig;
import com.george.orca.domain.*;
import CRM.dto.ExcelRowDTO;
import CRM.utils.ExcelParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileReaderServiceBean implements FileReaderService {
    private final PersonService personService;
    private final PersonContactService personContactService;
    private final OrganisationContactService organizationContactService;
    private final OrganizationService organizationService;
    private final EmployeeService employeeService;
    private final LoanPaymentService loanPaymentService;

    private final Persons1Service personsDB1;

    private final EntityManager entitymanager;

    private final LoanService loanService;

    private final PersonRepository personRepository;
    private final OrganizationRepository organizationRepository;

    private final FileConfig fileConfig;

    @Override
    public File readFile(String filename) {

        String filePath = fileConfig.getFolderPath();
        if (!filePath.endsWith("/")) {
            filePath += "/";
        }
        filePath += filename;
        log.info("reading file: " + filePath);

        File file = new File(filePath);

        IOUtils.setByteArrayMaxOverride(245304546);

        ExcelParser excelParser = new ExcelParser(file);

        Integer counter = 0;
        List<ExcelRowDTO> rowData = excelParser.getPersons();

        for (ExcelRowDTO record : rowData) {

//
//            Persons1Entity persona = new Persons1Entity().builder()
//                    .firstname(record.getName())
//                    .lastname(record.getLastname())
//                    .birthYear(record.getBirthYear())
//                    .personalNumber(record.getPersonalNumber())
//                    .phone(record.getPhone())
//                    .physicalAddress(record.getPhysicalAddress())
//                    .build();
//            personsDB1.edit(persona);
//
//
//            PersonEntity person = personService.search(record.getIdCode());
//            if (person != null) {
//                log.info("we have a match !! : " + record.getIdCode());
//                PersonContactEntity personContact = PersonContactEntity.builder()
//                        .contact(record.getFirstname() + " " + record.getLastname() + " პ/ნ : " + record.getIdCode())
//                        .personId(person.getId())
//                        .phone(record.getPhone())
//                        .physicalAddress(record.getPhysicalAddress())
//                        .contactInfo(record.getBirthYear())
//                        .build();
//
//                personContactService.edit(personContact);
//            }
//            counter++;

//            log.info("current: " + counter);


//            LoanEntity loan = loanService.get(record.getLoanId());

//            if (loan != null) {
//                if (loan.getDebtorOrganization() != null) {
//                    OrganisationContactEntity orgContact = OrganisationContactEntity.builder()
//                            .contact(record.getContact())
//                            .organizationId(loan.getDebtorOrganization().getId())
//                            .build();
//                    organisationContactService.edit(orgContact);
//                } else if (loan.getDebtorPerson() != null) {
//                    PersonContactEntity personContact = PersonContactEntity.builder()
//                            .contact(record.getContact())
//                            .personId(loan.getDebtorPerson().getId())
//                            .build();
//                    personContactService.edit(personContact);
//                }
//            }else{
//                log.info("loan: "+ record.getLoanId());
//
//            }
//
//

            OrganizationEntity orgEntity = new OrganizationEntity();
            orgEntity.setPhysicalAddress(record.getPhysicalAddress());
            orgEntity.setLegalAddress(record.getLegalAddress());
            orgEntity.setDirector(record.getContact());
            orgEntity.setCadastrialCode(record.getIdCode());
            orgEntity.setPhoneNumber(record.getPhone());

            organizationService.edit(orgEntity);

            organizationRepository.save(orgEntity);

//            Long personId = personEntity.getId();
//
//            OrganizationEntity creditor = organizationService.get(record.getCreditorOrganizationId());
//
//            loanEntity.setCreditorOrganization(creditor);
//

//
//debtor
            long creditorOrganization = 7;
            LoanEntity loanEntity = new LoanEntity();


            loanEntity.setAmount(record.getAmount());
            loanEntity.setInitialAmount(record.getAmount());
            loanEntity.setIncomeDate(record.getIncomeDate());
            loanEntity.setStartDate(record.getStartDate());

            PersonEntity person = personService.search(record.getIdCode());
            if (person != null) {
                log.info("we have a match !! : " + record.getIdCode());
                loanEntity.setDebtorPerson(person);
            } else {
                PersonEntity debtor = new PersonEntity().builder()
                        .personalNumber(record.getIdCode())
                        .firstname(record.getFirstname())
                        .lastname(record.getLastname())
                        .legalAddress(record.getLegalAddress())
                        .physicalAddress(record.getPhysicalAddress())
                        .phone(record.getPhone())
                        .build();
                debtor = personService.edit(debtor);
                loanEntity.setDebtorPerson(debtor);
            }


            OrganizationEntity creditorOrg;
            creditorOrg = organizationService.get(creditorOrganization);

            loanEntity.setCreditorOrganization(creditorOrg);
            loanEntity.setDebtorPerson(person);
//            loanEntity.setDebtorOrganization(orgEntity);

//            loanEntity.setId(record.getLoanId());
            loanEntity.setStartDate(record.getStartDate());
            loanEntity.setIncomeDate(record.getIncomeDate());

            loanService.edit(loanEntity);

//            entitymanager.clear();


        }


        return null;
    }
}
