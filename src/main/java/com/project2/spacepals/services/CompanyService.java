package com.project2.spacepals.services;

import com.project2.spacepals.entities.Company;
import com.project2.spacepals.entities.Users;
import com.project2.spacepals.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepo;

    @Autowired
    public CompanyService(CompanyRepository repo){
        super();
        this.companyRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<Company> getAllCompanies(){return companyRepo.findAll();}

    @Transactional(readOnly = true)
    public Company getCompanyByOwner(Users thisUser){return companyRepo.getCompanyByOwnerId(thisUser.getId());}
}
