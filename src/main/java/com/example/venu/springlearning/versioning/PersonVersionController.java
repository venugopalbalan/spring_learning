/**
 * 
 */
package com.example.venu.springlearning.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author venugopal
 *
 */
@RestController
public class PersonVersionController {
	
	@GetMapping("/v1/person")
	public PersonV1 retrivePersonNameV1() {
		return new PersonV1("Venugopal Balan");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 retrivePersonNameV2() {
		return new PersonV2(new Name("Venugopal","Balan"));
	}

	@GetMapping(value="/person",params = "version=1")
	public PersonV1 retriveParamNameV1() {
		return new PersonV1("Venu Balan");
	}
	
	@GetMapping(value="/person",params = "version=2")
	public PersonV2 retriveParamNameV2() {
		return new PersonV2(new Name("Venu","Balan"));
	}
	
	@GetMapping(value="/person/header",headers = "X-API-VERSION=1")
	public PersonV1 retriveHeaderNameV1() {
		return new PersonV1("Venu B");
	}
	
	@GetMapping(value="/person/header",headers = "X-API-VERSION=2")
	public PersonV2 retriveHeaderNameV2() {
		return new PersonV2(new Name("Venu","B"));
	}
	
	@GetMapping(value="/person/produces",produces = "application/v1+json")
	public PersonV1 retriveProducesNameV1() {
		return new PersonV1("Venu B");
	}
	
	@GetMapping(value="/person/produces",produces = "application/v2+json")
	public PersonV2 retriveProducesNameV2() {
		return new PersonV2(new Name("Venu","B"));
	}
}
