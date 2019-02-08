package com.renu.zuul.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renu.zuul.models.ProfessionalSkill;
import com.renu.zuul.models.Workplace;

@RestController
@RequestMapping(value="/zuul-profileAbout")
public class ProfileAboutRouteController {
private static final Logger LOGGER=LoggerFactory.getLogger(ProfileAboutRouteController.class);
// REST TEMPLATE
@Autowired
RestTemplate restTemplate;
// START WORKPLACE URL
// WORKPLACE ADD URL
private static final String WORKPLACE_ADD_URL="http://aboutStock-service/aboutStock-post/workplace/add";
//GET ALL WORKPLACES URL
private static final String GET_ALL_WORKPLACES_URL="http://aboutStock-service/aboutStock-get/workplace/getAll/";
//GET WORKPLACE BY ID URL
private static final String GET_SINGLE_WORKPLACE_URL="http://aboutStock-service/aboutStock-get/workplace/single/";
//UPDATE WORKPLACE BY ID URL
private static final String UPDATE_SINGLE_WORKPLACE_URL="http://aboutStock-service/aboutStock-update/workplace/update/";
//DELETE WORKPLACE BY ID URL
private static final String DELETE_SINGLE_WORKPLACE_URL="http://aboutStock-service/aboutStock-get/workplace/single/delete/";

//START PROFESSIONAL SKILLS URL
//PROFESSIONAL SKILLS ADD URL
private static final String PROFESSIONAL_SKILLS_ADD_URL="http://aboutStock-service/aboutStock-post/professionalSkills/add";
//GET ALL PROFESSIONAL SKILLS URL
private static final String GET_ALL_PROFESSIONAL_SKILLS_URL="http://aboutStock-service/aboutStock-get/professionalSkills/getAll/";
//GET PROFESSIONAL SKILLS BY ID URL
private static final String GET_SINGLE_PROFESSIONAL_SKILLS_URL="http://aboutStock-service/aboutStock-get/professionalSkills/single/";
//UPDATE PROFESSIONAL SKILLS BY ID URL
private static final String UPDATE_SINGLE_PROFESSIONAL_SKILLS_URL="http://aboutStock-service/aboutStock-update/professionalSkills/update/";
//DELETE PROFESSIONAL SKILLS BY ID URL
private static final String DELETE_SINGLE_PROFESSIONAL_SKILLS_URL="http://aboutStock-service/aboutStock-get/professionalSkills/single/delete/";
//--------------------------------------------------------------------------------------------------------------------
// START WRKPLACE METHOD
@RequestMapping(value="/workplace/add")
public ResponseEntity<?>workplaceAdd(@RequestBody Workplace workplace){
	LOGGER.info("From class ProfileAboutRouteController,method : workplaceAdd()--ENTER--workplace : "+workplace.getWorkPlace());

Workplace responseEntity=restTemplate.postForObject(WORKPLACE_ADD_URL,workplace,Workplace.class);
return ResponseEntity.ok().body(responseEntity);
}

//---------------------
//GET ALL WORKPLACES
	@RequestMapping(value="/workplace/getAll/{uid}")
	public ResponseEntity<?>getAllWorkplaces(@PathVariable("uid") String uid) {
		LOGGER.info("FROM class ProfileStockServiceController,method : getAllWorkplaces()--ENTER--UID : "+uid);

		ResponseEntity<List<?>> profilePhotosEntities =
		        restTemplate.exchange(GET_ALL_WORKPLACES_URL+uid,
		            HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
		            });
		
		
		
		return profilePhotosEntities;
		
		
	}

//---------------------

	//GET WORKPLACE BY ID
		@RequestMapping(value="/workplace/single/{id}")
		public ResponseEntity<?>getSingleWorkplace(@PathVariable("id") Long id) {
			LOGGER.info("FROM class ProfileStockServiceController,method : getSingleWorkplace()--ENTER--ID : "+id);

			ResponseEntity<Workplace> profilePhotosEntity =
			        restTemplate.exchange(GET_SINGLE_WORKPLACE_URL+id,
			            HttpMethod.GET, null, new ParameterizedTypeReference<Workplace>() {
			            });
			
			
			
			return profilePhotosEntity;
			
			
		}

		//---------------------

		//DELETE WORKPLACE BY ID
			@RequestMapping(value="/workplace/single/delete/{id}")
			public ResponseEntity<?>getSingleDELETEWorkplace(@PathVariable("id") Long id) {
				LOGGER.info("FROM class ProfileStockServiceController,method : getSingleWorkplace()--ENTER--ID : "+id);

				ResponseEntity<String> profilePhotosEntity =
				        restTemplate.exchange(DELETE_SINGLE_WORKPLACE_URL+id,
				            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				            });
				
				
				
				return profilePhotosEntity;
				
				
			}

			//---------------------

			//UPDATE WORKPLACE BY ID
				@RequestMapping(value="/workplace/update/{id}")
				public ResponseEntity<?>updateSingleWorkplace(@RequestBody Workplace workplace,@PathVariable("id") Long id) {
					LOGGER.info("FROM class ProfileStockServiceController,method : updateSingleWorkplace()--ENTER--ID : "+id);
                restTemplate.put(UPDATE_SINGLE_WORKPLACE_URL+id, workplace);
					return ResponseEntity.ok().body("success update");
					
				}
				
				//----------------------------------------------------------------------------------------------------

				// START PROFESSIONAL SKILLS METHOD
				@RequestMapping(value="/professionalSkills/add")
				public ResponseEntity<?>professionalSkillsAdd(@RequestBody ProfessionalSkill professionalSkill){
					LOGGER.info("From class ProfileAboutRouteController,method : professionalSkillsAdd()--ENTER--professionalSkills : "+professionalSkill.getProfessionalSkill());

				ProfessionalSkill responseEntity=restTemplate.postForObject(PROFESSIONAL_SKILLS_ADD_URL,professionalSkill,ProfessionalSkill.class);
				return ResponseEntity.ok().body(responseEntity);
				}

				//---------------------
				//GET ALL PROFESSIONAL SKILLS
					@RequestMapping(value="/professionalSkills/getAll/{uid}")
					public ResponseEntity<?>getAllProfessionalSkills(@PathVariable("uid") String uid) {
						LOGGER.info("FROM class ProfileStockServiceController,method : getAllProfessionalSkills()--ENTER--UID : "+uid);

						ResponseEntity<List<?>> profilePhotosEntities =
						        restTemplate.exchange(GET_ALL_PROFESSIONAL_SKILLS_URL+uid,
						            HttpMethod.GET, null, new ParameterizedTypeReference<List<?>>() {
						            });
						
						
						
						return profilePhotosEntities;
						
						
					}

				//---------------------

					//GET PROFESSIONAL SKILLS BY ID
						@RequestMapping(value="/professionalSkills/single/{id}")
						public ResponseEntity<?>getSingleProfessionalSkills(@PathVariable("id") Long id) {
							LOGGER.info("FROM class ProfileStockServiceController,method : getSingleProfessionalSkills()--ENTER--ID : "+id);

							ResponseEntity<ProfessionalSkill> profilePhotosEntity =
							        restTemplate.exchange(GET_SINGLE_PROFESSIONAL_SKILLS_URL+id,
							            HttpMethod.GET, null, new ParameterizedTypeReference<ProfessionalSkill>() {
							            });
							
							
							
							return profilePhotosEntity;
							
							
						}

						//---------------------

						//DELETE PROFESSIONAL SKILL BY ID
							@RequestMapping(value="/professionalSkills/single/delete/{id}")
							public ResponseEntity<?>getSingleDELETEProfessionalSkills(@PathVariable("id") Long id) {
								LOGGER.info("FROM class ProfileStockServiceController,method : getSingleDELETEProfessionalSkills()--ENTER--ID : "+id);

								ResponseEntity<String> profilePhotosEntity =
								        restTemplate.exchange(DELETE_SINGLE_PROFESSIONAL_SKILLS_URL+id,
								            HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
								            });
								
								
								
								return profilePhotosEntity;
								
								
							}

							//---------------------

							//UPDATE PROFESSIONAL SKILLS BY ID
								@RequestMapping(value="/professionalSkills/update/{id}")
								public ResponseEntity<?>updateSingleProfessionalSkills(@RequestBody ProfessionalSkill professionalSkill,@PathVariable("id") Long id) {
									LOGGER.info("FROM class ProfileStockServiceController,method : updateSingleProfessionalSkills()--ENTER--ID : "+id);
				                restTemplate.put(UPDATE_SINGLE_PROFESSIONAL_SKILLS_URL+id, professionalSkill);
									return ResponseEntity.ok().body("success update");
									
								}

}
