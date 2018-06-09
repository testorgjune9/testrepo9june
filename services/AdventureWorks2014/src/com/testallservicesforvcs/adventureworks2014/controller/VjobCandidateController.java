/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.time.LocalDateTime;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testallservicesforvcs.adventureworks2014.VjobCandidate;
import com.testallservicesforvcs.adventureworks2014.VjobCandidateId;
import com.testallservicesforvcs.adventureworks2014.service.VjobCandidateService;


/**
 * Controller object for domain model class VjobCandidate.
 * @see VjobCandidate
 */
@RestController("AdventureWorks2014.VjobCandidateController")
@Api(value = "VjobCandidateController", description = "Exposes APIs to work with VjobCandidate resource.")
@RequestMapping("/AdventureWorks2014/VjobCandidate")
public class VjobCandidateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VjobCandidateController.class);

    @Autowired
	@Qualifier("AdventureWorks2014.VjobCandidateService")
	private VjobCandidateService vjobCandidateService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new VjobCandidate instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VjobCandidate createVjobCandidate(@RequestBody VjobCandidate vjobCandidate) {
		LOGGER.debug("Create VjobCandidate with information: {}" , vjobCandidate);

		vjobCandidate = vjobCandidateService.create(vjobCandidate);
		LOGGER.debug("Created VjobCandidate with information: {}" , vjobCandidate);

	    return vjobCandidate;
	}

    @ApiOperation(value = "Returns the VjobCandidate instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VjobCandidate getVjobCandidate(@RequestParam("jobCandidateId") Integer jobCandidateId, @RequestParam("businessEntityId") Integer businessEntityId, @RequestParam("name_prefix") String name_prefix, @RequestParam("name_first") String name_first, @RequestParam("name_middle") String name_middle, @RequestParam("name_last") String name_last, @RequestParam("name_suffix") String name_suffix, @RequestParam("skills") String skills, @RequestParam("addr_type") String addr_type, @RequestParam("addr_loc_countryRegion") String addr_loc_countryRegion, @RequestParam("addr_loc_state") String addr_loc_state, @RequestParam("addr_loc_city") String addr_loc_city, @RequestParam("addr_postalCode") String addr_postalCode, @RequestParam("email") String email, @RequestParam("webSite") String webSite, @RequestParam("modifiedDate") LocalDateTime modifiedDate) {

        VjobCandidateId vjobcandidateId = new VjobCandidateId();
        vjobcandidateId.setJobCandidateId(jobCandidateId);
        vjobcandidateId.setBusinessEntityId(businessEntityId);
        vjobcandidateId.setName_prefix(name_prefix);
        vjobcandidateId.setName_first(name_first);
        vjobcandidateId.setName_middle(name_middle);
        vjobcandidateId.setName_last(name_last);
        vjobcandidateId.setName_suffix(name_suffix);
        vjobcandidateId.setSkills(skills);
        vjobcandidateId.setAddr_type(addr_type);
        vjobcandidateId.setAddr_loc_countryRegion(addr_loc_countryRegion);
        vjobcandidateId.setAddr_loc_state(addr_loc_state);
        vjobcandidateId.setAddr_loc_city(addr_loc_city);
        vjobcandidateId.setAddr_postalCode(addr_postalCode);
        vjobcandidateId.setEmail(email);
        vjobcandidateId.setWebSite(webSite);
        vjobcandidateId.setModifiedDate(modifiedDate);

        LOGGER.debug("Getting VjobCandidate with id: {}" , vjobcandidateId);
        VjobCandidate vjobCandidate = vjobCandidateService.getById(vjobcandidateId);
        LOGGER.debug("VjobCandidate details with id: {}" , vjobCandidate);

        return vjobCandidate;
    }



    @ApiOperation(value = "Updates the VjobCandidate instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VjobCandidate editVjobCandidate(@RequestParam("jobCandidateId") Integer jobCandidateId, @RequestParam("businessEntityId") Integer businessEntityId, @RequestParam("name_prefix") String name_prefix, @RequestParam("name_first") String name_first, @RequestParam("name_middle") String name_middle, @RequestParam("name_last") String name_last, @RequestParam("name_suffix") String name_suffix, @RequestParam("skills") String skills, @RequestParam("addr_type") String addr_type, @RequestParam("addr_loc_countryRegion") String addr_loc_countryRegion, @RequestParam("addr_loc_state") String addr_loc_state, @RequestParam("addr_loc_city") String addr_loc_city, @RequestParam("addr_postalCode") String addr_postalCode, @RequestParam("email") String email, @RequestParam("webSite") String webSite, @RequestParam("modifiedDate") LocalDateTime modifiedDate, @RequestBody VjobCandidate vjobCandidate) {

        vjobCandidate.setJobCandidateId(jobCandidateId);
        vjobCandidate.setBusinessEntityId(businessEntityId);
        vjobCandidate.setName_prefix(name_prefix);
        vjobCandidate.setName_first(name_first);
        vjobCandidate.setName_middle(name_middle);
        vjobCandidate.setName_last(name_last);
        vjobCandidate.setName_suffix(name_suffix);
        vjobCandidate.setSkills(skills);
        vjobCandidate.setAddr_type(addr_type);
        vjobCandidate.setAddr_loc_countryRegion(addr_loc_countryRegion);
        vjobCandidate.setAddr_loc_state(addr_loc_state);
        vjobCandidate.setAddr_loc_city(addr_loc_city);
        vjobCandidate.setAddr_postalCode(addr_postalCode);
        vjobCandidate.setEmail(email);
        vjobCandidate.setWebSite(webSite);
        vjobCandidate.setModifiedDate(modifiedDate);

        LOGGER.debug("VjobCandidate details with id is updated with: {}" , vjobCandidate);

        return vjobCandidateService.update(vjobCandidate);
    }


    @ApiOperation(value = "Deletes the VjobCandidate instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteVjobCandidate(@RequestParam("jobCandidateId") Integer jobCandidateId, @RequestParam("businessEntityId") Integer businessEntityId, @RequestParam("name_prefix") String name_prefix, @RequestParam("name_first") String name_first, @RequestParam("name_middle") String name_middle, @RequestParam("name_last") String name_last, @RequestParam("name_suffix") String name_suffix, @RequestParam("skills") String skills, @RequestParam("addr_type") String addr_type, @RequestParam("addr_loc_countryRegion") String addr_loc_countryRegion, @RequestParam("addr_loc_state") String addr_loc_state, @RequestParam("addr_loc_city") String addr_loc_city, @RequestParam("addr_postalCode") String addr_postalCode, @RequestParam("email") String email, @RequestParam("webSite") String webSite, @RequestParam("modifiedDate") LocalDateTime modifiedDate) {

        VjobCandidateId vjobcandidateId = new VjobCandidateId();
        vjobcandidateId.setJobCandidateId(jobCandidateId);
        vjobcandidateId.setBusinessEntityId(businessEntityId);
        vjobcandidateId.setName_prefix(name_prefix);
        vjobcandidateId.setName_first(name_first);
        vjobcandidateId.setName_middle(name_middle);
        vjobcandidateId.setName_last(name_last);
        vjobcandidateId.setName_suffix(name_suffix);
        vjobcandidateId.setSkills(skills);
        vjobcandidateId.setAddr_type(addr_type);
        vjobcandidateId.setAddr_loc_countryRegion(addr_loc_countryRegion);
        vjobcandidateId.setAddr_loc_state(addr_loc_state);
        vjobcandidateId.setAddr_loc_city(addr_loc_city);
        vjobcandidateId.setAddr_postalCode(addr_postalCode);
        vjobcandidateId.setEmail(email);
        vjobcandidateId.setWebSite(webSite);
        vjobcandidateId.setModifiedDate(modifiedDate);

        LOGGER.debug("Deleting VjobCandidate with id: {}" , vjobcandidateId);
        VjobCandidate vjobCandidate = vjobCandidateService.delete(vjobcandidateId);

        return vjobCandidate != null;
    }


    /**
     * @deprecated Use {@link #findVjobCandidates(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of VjobCandidate instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VjobCandidate> searchVjobCandidatesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VjobCandidates list by query filter:{}", (Object) queryFilters);
        return vjobCandidateService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VjobCandidate instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VjobCandidate> findVjobCandidates(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VjobCandidates list by filter:", query);
        return vjobCandidateService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VjobCandidate instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VjobCandidate> filterVjobCandidates(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VjobCandidates list by filter", query);
        return vjobCandidateService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVjobCandidates(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return vjobCandidateService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportVjobCandidatesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = VjobCandidate.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> vjobCandidateService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of VjobCandidate instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countVjobCandidates( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting VjobCandidates");
		return vjobCandidateService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getVjobCandidateAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return vjobCandidateService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VjobCandidateService instance
	 */
	protected void setVjobCandidateService(VjobCandidateService service) {
		this.vjobCandidateService = service;
	}

}