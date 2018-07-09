package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class NumbersAdditionRule implements Rule {
	
	private static final String REGEX_NUMBER = "[0-9]";
	
	@Override
    public Long check(String password) {
		long count = Pattern.compile(REGEX_NUMBER).matcher(password).results().count();
        
		return count * 4;
    }
}
