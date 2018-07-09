package br.com.db1.gumga.passwordmeter.rules.additions;

import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class MiddleNumbersSymbolsAdditionRule implements Rule {

	private static final String REGEX_LETTERS = "[A-z]";
	
	@Override
	public Long check(String password) {
		
		if(password.length() > 2 ) {
            String middlePassword = password.substring(1, password.length() - 1);
            
            long count = Pattern.compile(REGEX_LETTERS).matcher(middlePassword).results().count();
            
            return (password.length() - count) * 2;
        }
		
		return 0L;
	}

}
