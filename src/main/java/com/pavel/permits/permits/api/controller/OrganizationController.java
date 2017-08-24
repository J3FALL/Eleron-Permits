package com.pavel.permits.permits.api.controller;

import com.pavel.permits.permits.api.dto.OrganizationDto;
import com.pavel.permits.permits.core.service.OrganizationService;
import com.pavel.permits.permits.model.Organization;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;

/**
 * Created by Pavel on 24.08.2017.
 */

@RestController
@RequestMapping("/api/org")
@Api(value = "/api/org", description = "Organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OrganizationDto createOrganization(@RequestBody OrganizationDto orgDto) {
        Organization org = convertToEntity(orgDto);
        Organization createdOrg = service.save(org);

        return convertToDto(createdOrg);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<OrganizationDto> getAllOrganizations() {
        List<Organization> orgs = service.findAll();

        return orgs.stream()
                .map(org -> convertToDto(org))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public OrganizationDto getOrganization(@PathVariable("id") Integer id) {

        return convertToDto(service.findOne(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public OrganizationDto updateOrganization(
            @PathVariable("id") Integer id, @RequestBody OrganizationDto orgDto) {
        Organization org = convertToEntity(orgDto);
        org.setId(id);

        return convertToDto(service.save(org));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCode(@PathVariable("id") Integer id) {

        service.delete(id);
    }

    private OrganizationDto convertToDto(Organization org) {
        OrganizationDto orgDto = mapper.map(org, OrganizationDto.class);
        return orgDto;
    }

    private Organization convertToEntity(OrganizationDto orgDto) {
        Organization org = mapper.map(orgDto, Organization.class);
        return org;
    }
}
