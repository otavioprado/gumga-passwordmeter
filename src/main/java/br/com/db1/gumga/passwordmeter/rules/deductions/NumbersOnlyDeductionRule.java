package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class NumbersOnlyDeductionRule implements Rule {

	private static final String REGEX_NUMBERS = "[0-9]";

	@Override
	public Long check(String password) {
		long count = Pattern.compile(REGEX_NUMBERS).matcher(password).results().count();
		Long passwordLength = Long.valueOf(password.length());
		
		if (passwordLength == count) {
			return Math.negateExact(passwordLength);
		}

		return 0L;
	}

}
