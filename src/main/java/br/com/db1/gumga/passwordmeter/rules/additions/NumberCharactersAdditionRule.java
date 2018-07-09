package br.com.db1.gumga.passwordmeter.rules.additions;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class NumberCharactersAdditionRule implements Rule  {
	
	@Override
	public Rate check(String password) {
		
		Rate rate = new Rate();
		rate.setCount(Long.valueOf(password.length()));
		rate.setBonus(rate.getCount() * 4);
		rate.setRequirement(rate.getCount() >= 8);
		
		return rate;
	}

}
