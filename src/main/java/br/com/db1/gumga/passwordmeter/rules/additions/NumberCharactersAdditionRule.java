package br.com.db1.gumga.passwordmeter.rules.additions;

import br.com.db1.gumga.passwordmeter.rules.commons.Rule;

public class NumberCharactersAdditionRule implements Rule {

	@Override
	public Long check(String password) {
		return (long) (password.length() * 4);
	}

}
