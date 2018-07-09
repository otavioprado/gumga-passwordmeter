package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class NumbersAdditionRule implements Rule {
	
	private static final String REGEX_NUMBER = "[0-9]";
	
	@Override
    public Rate check(String password) {
		long countNumbers = Pattern.compile(REGEX_NUMBER).matcher(password).results().count();
		long countNotNumbers = password.length() - countNumbers;
		
		if(countNotNumbers > 0) {
			return new Rate(countNumbers, countNumbers * 4, countNumbers > 0);
		} else {
			return new Rate(countNumbers, 0L, countNumbers > 0);
		}
    }
}
