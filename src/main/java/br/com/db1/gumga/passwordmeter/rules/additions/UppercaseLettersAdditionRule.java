package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class UppercaseLettersAdditionRule implements Rule {

	private static final String REGEX_UPPERCASE = "[A-Z]";

	@Override
	public Long check(String password) {
		
		long count = Pattern.compile(REGEX_UPPERCASE).matcher(password).results().count();
		
		if(password.length() > 0) {
			return (password.length() - count) * 2;
		}
		
		return 0L;
	}

}
