package br.com.db1.gumga.passwordmeter.service;

import br.com.db1.gumga.passwordmeter.dto.PasswordMeterResponse;

@FunctionalInterface
public interface PasswordMeterService {
	PasswordMeterResponse checkPassword(String password);
}
