package CRM.service;

import CRM.domain.CountryEntity;
import CRM.repository.CountryRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceBean implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<CountryEntity> list() {
        return countryRepository.findAll();
    }

    @Override
    public CountryEntity findCountryByCountryCode(String countryCode) {
        Optional<CountryEntity> optionalCountryEntity = countryRepository.findByCountryCode(countryCode);
        return new TemplateUtil<CountryEntity>().get(optionalCountryEntity);
    }
}
