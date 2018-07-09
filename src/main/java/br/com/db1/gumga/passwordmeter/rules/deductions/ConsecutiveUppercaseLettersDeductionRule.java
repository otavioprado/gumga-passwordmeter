package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class ConsecutiveUppercaseLettersDeductionRule implements Rule {

	private static final String REGEX_CONSECUTIVE_UPPERCASE = "[A-Z]{2,}";
	
	@Override
	public Long check(String password) {
		long count = Pattern.compile(REGEX_CONSECUTIVE_UPPERCASE).matcher(password).results().count();
		
		if(password.length() > 0) {
			return Math.negateExact((password.length() - count) * 2);
		}
		
		return 0L;
	}

}
