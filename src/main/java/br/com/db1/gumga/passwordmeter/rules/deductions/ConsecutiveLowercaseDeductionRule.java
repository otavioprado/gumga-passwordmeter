package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class ConsecutiveLowercaseDeductionRule implements Rule {

	private static final String REGEX_CONSECUTIVE_LOWERCASE = "[a-z]{2,}";
	private static final String REGEX_LOWERCASE = "[a-z]";
	
	@Override
	public Rate check(String password) {
		Objects.requireNonNull(password);
		
		Matcher matcher = Pattern.compile(REGEX_CONSECUTIVE_LOWERCASE).matcher(password);
		long lowercaseCount = Pattern.compile(REGEX_LOWERCASE).matcher(password).results().count();
		
		long qtd = 0;
		while(matcher.find()) {
			qtd++;
		}
		
		long bonus = 0l;
		
		long count = lowercaseCount - qtd;
		if(password.length() > 0) {
			bonus = Math.negateExact(count) * 2;
		}
		
		return new Rate(count, bonus, false);
	}

}
