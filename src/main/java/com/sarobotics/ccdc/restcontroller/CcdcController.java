package com.sarobotics.ccdc.restcontroller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarobotics.ccdc.service.CheckDigitCalculator;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1")
public class CcdcController {
	
	@Autowired
	CheckDigitCalculator cdc;
	
	@CrossOrigin
	@RequestMapping(value = "/ccdc/{container_nr}", method = GET)
	@ApiOperation(value = "Validate the container number.")
	public boolean canCommunicate( @PathVariable( name = "container_nr" ) String containerNr) {
		
		int checkDigitCalculated = cdc.CalculateCheckDigit(containerNr);
				
		return cdc.isCorrect(checkDigitCalculated,containerNr);
		//return true;
	}

}
