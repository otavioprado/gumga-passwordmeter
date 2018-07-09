package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class ConsecutiveNumbersDeductionRule implements Rule {

	private static final String REGEX_CONSECUTIVE_NUMBERS = "[0-9]{2,}";
	private static final String REGEX_NUMBERS = "[0-9]";
	
	@Override
	public Rate check(String password) {
		Objects.requireNonNull(password);
		
		Matcher matcher = Pattern.compile(REGEX_CONSECUTIVE_NUMBERS).matcher(password);
		long numberCount = Pattern.compile(REGEX_NUMBERS).matcher(password).results().count();
		
		long qtd = 0;
		while(matcher.find()) {
			qtd++;
		}
		
		long bonus = 0l;
		
		long count = numberCount - qtd;
		if(password.length() > 0) {
			bonus = Math.negateExact(count) * 2;
		}
		
		return new Rate(count, bonus, false);
	}


}
