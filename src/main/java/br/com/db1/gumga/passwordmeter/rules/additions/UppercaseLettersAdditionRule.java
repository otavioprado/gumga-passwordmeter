package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.Objects;
import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class UppercaseLettersAdditionRule implements Rule {

	private static final String REGEX_UPPERCASE = "[A-Z]";

	@Override
	public Rate check(String password) {
		Objects.requireNonNull(password);
		
		long count = Pattern.compile(REGEX_UPPERCASE).matcher(password).results().count();
		long bonus = 0L;
		
		if(count > 0) {
			bonus = (password.length() - count) * 2;
		}
		
		return new Rate(count, bonus, count > 0);
	}

}
