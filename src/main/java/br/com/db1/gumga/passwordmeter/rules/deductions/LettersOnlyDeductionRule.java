package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class LettersOnlyDeductionRule implements Rule {

	private static final String REGEX_LETTERS = "[A-z]";

	@Override
	public Long check(String password) {
		long count = Pattern.compile(REGEX_LETTERS).matcher(password).results().count();
		Long passwordLength = Long.valueOf(password.length());
		
		if (passwordLength == count) {
			return Math.negateExact(passwordLength);
		}

		return 0L;
	}

}
