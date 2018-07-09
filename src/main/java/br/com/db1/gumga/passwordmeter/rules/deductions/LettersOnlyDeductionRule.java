package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.Objects;
import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class LettersOnlyDeductionRule implements Rule {

	private static final String REGEX_LETTERS = "[A-z]";

	@Override
	public Rate check(String password) {
		Objects.requireNonNull(password);
		
		long count = Pattern.compile(REGEX_LETTERS).matcher(password).results().count();
		long bonus = 0l;
		
		Long passwordLength = Long.valueOf(password.length());
		if (passwordLength == count) {
			bonus = Math.negateExact(passwordLength);
		}

		return new Rate(count, bonus, false);
	}

}
