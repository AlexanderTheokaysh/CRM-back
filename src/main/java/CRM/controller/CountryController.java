package CRM.controller;

import CRM.domain.CountryEntity;
import CRM.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("country")
@Slf4j
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("list")
    public ResponseEntity<List<CountryEntity>> list() {

        List<CountryEntity> list = countryService.list();

        return ResponseEntity.ok(list);
    }


    @GetMapping("findByCountryCode")
    public ResponseEntity<CountryEntity> findByCountryCode(String countryCode) {

        CountryEntity countryEntity = countryService.findCountryByCountryCode(countryCode);

        return ResponseEntity.ok(countryEntity);
    }

}
