package br.com.db1.gumga.passwordmeter.rules.deductions;

import java.util.Objects;

import br.com.db1.gumga.passwordmeter.rules.commons.Rate;
import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

/**
 * Uses the ASC2 table to know what is the next character
 */
public abstract class AbstractSequentialDeductionRule implements Rule {
	public Rate check(String password) {
		Objects.requireNonNull(password);

		char[] charArrayPassword = password.toCharArray();

		Long count = 0L;

		for (int i = 0; i < charArrayPassword.length - 2; i++) {
			Character currentCharacter = charArrayPassword[i];
			Character nextInPassword = charArrayPassword[i + 1];
			Character nextToNextInPassword = charArrayPassword[i + 2];

			char nextInAsc2 = (char) (currentCharacter + 1);
			char nextToNextInAsc2 = (char) (currentCharacter + 2);

			if (String.valueOf(nextInAsc2).equalsIgnoreCase(String.valueOf(nextInPassword))
					&& (String.valueOf(nextToNextInAsc2).equalsIgnoreCase(String.valueOf(nextToNextInPassword)))) {
				count += 1;
			}
		}

		return new Rate(count, Math.negateExact(count * 3), false);
	}
}
