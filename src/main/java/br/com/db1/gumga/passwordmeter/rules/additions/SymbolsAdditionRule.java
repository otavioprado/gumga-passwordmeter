package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class SymbolsAdditionRule implements Rule {

	public static final String REGEX_LETTERS_NUMBERS = "[A-z0-9]";
	
	@Override
	public Long check(String password) {
		
		long count = Pattern.compile(REGEX_LETTERS_NUMBERS).matcher(password).results().count();
		
		return (password.length() - count) * 6;
	}

}
