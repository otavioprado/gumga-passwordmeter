package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class LowercaseLettersAdditionRule implements Rule {
	private static final String REGEX_LOWERCASE = "[a-z]";

	@Override
	public Long check(String password) {
		
		long count = Pattern.compile(REGEX_LOWERCASE).matcher(password).results().count();
		
		if(password.length() > 0) {
			return (password.length() - count) * 2;
		}
		
		return 0L;
	}
}
