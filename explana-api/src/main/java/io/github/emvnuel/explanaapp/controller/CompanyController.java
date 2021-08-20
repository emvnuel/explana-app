package io.github.emvnuel.explanaapp.controller;

import io.github.emvnuel.explanaapp.controller.dto.CompanyDetailsResponse;
import io.github.emvnuel.explanaapp.controller.dto.CompanyRequest;
import io.github.emvnuel.explanaapp.controller.dto.CompanyResponse;
import io.github.emvnuel.explanaapp.mapper.CompanyMapper;
import io.github.emvnuel.explanaapp.model.Company;
import io.github.emvnuel.explanaapp.repository.projections.SalaryStatistic;
import io.github.emvnuel.explanaapp.service.CompanyService;
import io.github.emvnuel.explanaapp.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    public CompanyController(CompanyService companyService,
                             CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> getCompanies(@PageableDefault(size = 12, page = 0) Pageable pageable) {
        return ResponseEntity.ok(companyService.findAll(pageable).map(companyMapper::toCompanyResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetailsResponse> getCompanyById(@PathVariable String id) {
        return ResponseEntity.ok(companyMapper.toCompanyDetailsResponse(companyService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<?> saveCompany(@Valid @RequestBody CompanyRequest companyRequest) {
        Company company = companyService.save(companyMapper.toModel(companyRequest));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(company.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }



}
