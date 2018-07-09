package br.com.db1.gumga.passwordmeter.rules.deductions;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class RepeatCharactersDeductionRule implements Rule {

	@Override
	public Rate check(String password) {
		String passwordValidate = password.replaceAll(" ", "");
		Double repeat = 0.0;
		Long qtdRepeat = 0L;
		Double length = Double.valueOf(passwordValidate.length());

		for (int firstLoop = 0; firstLoop < length; firstLoop++) {
			boolean existChar = false;
			for (int secondLoop = 0; secondLoop < length; secondLoop++) {
				if (passwordValidate.charAt(firstLoop) == passwordValidate.charAt(secondLoop)
						&& firstLoop != secondLoop) {
					existChar = true;
					repeat += Math.abs(length / (secondLoop - firstLoop));
				}
			}
			if (existChar) {
				qtdRepeat++;
				Double unique = length - qtdRepeat;
				repeat = unique > 0 ? Math.ceil(repeat / unique) : Math.ceil(repeat);
			}
		}

		Long bonus = Long.valueOf(repeat.intValue());

		return new Rate(bonus / 3, Math.negateExact(bonus), false);
	}

}
