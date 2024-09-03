package CRM.service;

import CRM.domain.CountryEntity;

import java.util.List;

public interface CountryService {

    List<CountryEntity> list();

    CountryEntity findCountryByCountryCode(String countryCode);
}

