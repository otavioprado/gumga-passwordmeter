package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class ConsecutiveUppercaseLettersDeductionRule implements Rule {

	private static final String REGEX_CONSECUTIVE_UPPERCASE = "[A-Z]{2,}";
	
	@Override
	public Rate check(String password) {
		long count = Pattern.compile(REGEX_CONSECUTIVE_UPPERCASE).matcher(password).results().count();
		long bonus = 0l;
		
		if(password.length() > 0) {
			bonus = Math.negateExact((password.length() - count) * 2);
		}
		
		return new Rate(count, bonus, false);
	}

}
