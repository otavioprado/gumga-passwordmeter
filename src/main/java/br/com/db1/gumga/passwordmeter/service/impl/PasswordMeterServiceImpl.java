package br.com.db1.gumga.passwordmeter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.gumga.passwordmeter.dto.PasswordMeterResponse;
import br.com.db1.gumga.passwordmeter.enums.LevelScore;
import br.com.db1.gumga.passwordmeter.service.PasswordMeterService;
import br.com.db1.gumga.passwordmeter.service.RateCalculatorService;

@Service
public class PasswordMeterServiceImpl implements PasswordMeterService {

	@Autowired
	private RateCalculatorService rateCalculatorService;
	
	@Override
	public PasswordMeterResponse checkPassword(String password) {
		Long totalBonus = rateCalculatorService.calculate(password);
		
		return new PasswordMeterResponse(totalBonus, LevelScore.byScore(totalBonus));
	}

}
