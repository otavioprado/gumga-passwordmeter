package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.Objects;
import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class SymbolsAdditionRule implements Rule {

	public static final String REGEX_LETTERS_NUMBERS = "[A-z0-9]";
	
	@Override
	public Rate check(String password) {
		Objects.requireNonNull(password);
		
		long count = Pattern.compile(REGEX_LETTERS_NUMBERS).matcher(password).results().count();
		
		count = password.length() - count;
		long bonus = count * 6;
		
		return new Rate(count, bonus, count > 0);
	}

}
