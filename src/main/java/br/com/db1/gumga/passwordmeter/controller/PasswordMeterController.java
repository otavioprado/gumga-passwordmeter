package br.com.db1.gumga.passwordmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.gumga.passwordmeter.dto.PasswordMeterRequest;
import br.com.db1.gumga.passwordmeter.dto.PasswordMeterResponse;
import br.com.db1.gumga.passwordmeter.service.PasswordMeterService;

@RestController
public class PasswordMeterController {

	@Autowired
	private PasswordMeterService passwordMeterService;

	@PostMapping(value = "/api/v1/password-meter/check")
	public PasswordMeterResponse checkPassword(@RequestBody PasswordMeterRequest request) {
		PasswordMeterResponse response = passwordMeterService.checkPassword(request.getPassword());
		return response;
	}
}
