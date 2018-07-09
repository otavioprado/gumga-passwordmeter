package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class NumbersOnlyDeductionRule implements Rule {

	private static final String REGEX_NUMBERS = "[0-9]";

	@Override
	public Rate check(String password) {
		long count = Pattern.compile(REGEX_NUMBERS).matcher(password).results().count();
		long bonus = 0l;
		
		Long passwordLength = Long.valueOf(password.length());
		if (passwordLength == count) {
			bonus = Math.negateExact(passwordLength);
		}

		return new Rate(count, bonus, false);
	}

}
