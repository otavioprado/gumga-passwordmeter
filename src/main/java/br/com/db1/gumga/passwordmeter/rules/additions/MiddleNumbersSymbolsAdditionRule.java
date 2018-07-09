package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.Objects;
import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class MiddleNumbersSymbolsAdditionRule implements Rule {

	private static final String REGEX_LETTERS = "[A-z]";

	@Override
	public Rate check(String password) {
		Objects.requireNonNull(password);
		
		long countLetters = 0;
		long countNotLetters = 0;
		Rate result = new Rate();
		
		if (password.length() > 2) {
			String middlePassword = password.substring(1, password.length() - 1);

			countLetters = Pattern.compile(REGEX_LETTERS).matcher(middlePassword).results().count();
			countNotLetters = middlePassword.length() - countLetters;
			
			if(countNotLetters > 0) {
				result = new Rate(countNotLetters, countNotLetters * 2, countNotLetters > 0);
			} else {
				result = new Rate(countNotLetters, 0L, countNotLetters > 0);
			}
		}

		return result;
	}

}
