package com.thoughtmechanix.organization_service.service;

import com.thoughtmechanix.organization_service.model.Organization;
import com.thoughtmechanix.organization_service.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository orgRepository;

    public Organization getOrg(String organizationId) {
        Optional<Organization> obj = orgRepository.findById(organizationId);
        return obj.orElse(null);
    }

    public void saveOrg(Organization org){
        org.setId(UUID.randomUUID().toString());

        orgRepository.save(org);

    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.delete(org);
    }
}
