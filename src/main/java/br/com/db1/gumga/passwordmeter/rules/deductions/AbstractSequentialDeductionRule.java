package br.com.db1.gumga.passwordmeter.rules.deductions;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

/**
 * Uses the ASC2 table to know what is the next character
 * 
 * @author Otávio Prado
 */
public abstract class AbstractSequentialDeductionRule implements Rule {
	public Long check(String password) {

		char[] charArrayPassword = password.toCharArray();

		Long total = 0L;

		for (int i = 0; i < charArrayPassword.length - 2; i++) {
			Character currentCharacter = charArrayPassword[i];
			Character nextInPassword = charArrayPassword[i + 1];
			Character nextToNextInPassword = charArrayPassword[i + 2];

			char nextInAsc2 = (char) (currentCharacter + 1);
			char nextToNextInAsc2 = (char) (currentCharacter + 2);

			if (String.valueOf(nextInAsc2).equalsIgnoreCase(String.valueOf(nextInPassword))
					&& (String.valueOf(nextToNextInAsc2).equalsIgnoreCase(String.valueOf(nextToNextInPassword)))) {
				total += 1;
			}
		}

		return Math.negateExact(total * 3);
	}
}
