package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.Objects;
import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class LowercaseLettersAdditionRule implements Rule {
	private static final String REGEX_LOWERCASE = "[a-z]";

	@Override
	public Rate check(String password) {
		Objects.requireNonNull(password);
		
		long count = Pattern.compile(REGEX_LOWERCASE).matcher(password).results().count();
		Long bonus = 0L;
		
		if(count > 0) {
			bonus = (password.length() - count) * 2;
		}
		
		return new Rate(count, bonus, bonus > 0);
	}
}
